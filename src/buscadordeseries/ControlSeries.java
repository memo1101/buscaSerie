package buscadordeseries;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class ControlSeries extends CsvControlador<Serie>{

    public ControlSeries() {
        super();
    }

    @Override
    protected String getFileName() {
        return "base.csv";
    }

    @Override
    public void save(LinkedList<Serie> entidades)throws IOException {
        File archivoSeries = new File(getFileName());
        archivoSeries.delete();
        CsvWriter csvWriter =new CsvWriter(new FileWriter(getFileName(),true),';');

        addHeaders(csvWriter);
        for (Serie serie:
             entidades) {
            writeSeries(csvWriter,serie);
        }
        csvWriter.close();


    }
    private void addHeaders(CsvWriter csvWriter)throws IOException{

        csvWriter.write("title");
        csvWriter.write("mediaType");
        csvWriter.write("eps");
        csvWriter.write("startYr");
        csvWriter.write("finishYr");
        csvWriter.write("sznOfRelease");
        csvWriter.write("description");
        csvWriter.write("studios");
        csvWriter.write("tags");
        csvWriter.write("like");
        csvWriter.write("dislike");
        csvWriter.endRecord();
    }
    private void writeSeries(CsvWriter csvWriter, Serie serie)throws IOException{

        csvWriter.write(serie.getTitle());
        csvWriter.write(serie.getMediaType());
        csvWriter.write(String.valueOf(serie.getEps()));
        csvWriter.write(serie.getStartYr());
        csvWriter.write(serie.getFinishYr());
        csvWriter.write(serie.getSznOfRelease());
        csvWriter.write(serie.getDescription());
        csvWriter.write(serie.getStudios());
        String tags= serie.getTags().stream().reduce((acum,value)-> acum +"," + value ).get();
        csvWriter.write(tags);
        csvWriter.write(String.valueOf(serie.getLike()));
        csvWriter.write(String.valueOf(serie.getDislike()));
        csvWriter.endRecord();
    }

    private Serie parseSerie(CsvReader leerSeries, int cont) throws IOException, ParseException {

        String tittle = leerSeries.get(0);
        String mediaType = leerSeries.get(1);
        int eps =  Integer.parseInt(leerSeries.get(2));
        String startYr= leerSeries.get(3);
        String finishYr = leerSeries.get(4);
        String sznOfRelease = leerSeries.get(5);
        String description = leerSeries.get(6);
        String studios = leerSeries.get(7);
        String tags = leerSeries.get(8);
        List<String> tagList= Arrays.asList(tags.split(","));
        int like=0;
        if (leerSeries.get(9)!=null &&!leerSeries.get(9).isEmpty()){
            like = Integer.parseInt(leerSeries.get(9));
        }
        int dislike =0;
        if (leerSeries.get(10)!=null &&!leerSeries.get(10).isEmpty()){
            dislike = Integer.parseInt(leerSeries.get(10));
        }

        return new Serie(cont,tittle,mediaType,eps,startYr,finishYr,sznOfRelease,description,studios,tagList,like,dislike);
    }

    @Override
    public LinkedList<Serie> load() {
        try{
            entidades = new LinkedList<>();
            CsvReader leerSeries = new CsvReader(getFileName(),';');
            leerSeries.readHeaders();
            int cont=1;
            while (leerSeries.readRecord()){
                entidades.add(parseSerie(leerSeries,cont));
                cont++;
            }
            leerSeries.close();

        } catch(IOException | ParseException e){
            e.printStackTrace();
        }
        return entidades;
    }

    public List<Serie> buscarPorCategoria(String categoria){
        load();
        //solucion funcional:
        return entidades.stream().filter((entidad)-> entidad.getTags().stream().anyMatch((tag)->tag.equals(categoria))).collect(Collectors.toList());

        /*
        List<Serie> seriesFiltradas = new LinkedList<>();
        for (Serie serie:
                entidades
             ) {
            boolean hasTag=false;
            for (String tag: serie.getTags()){
                if (tag.equals(categoria)){
                    hasTag =true;
                    break;
                }
            }
            if (hasTag){
                seriesFiltradas.add(serie);
            }
        }
        return seriesFiltradas;
        */
    }

}
