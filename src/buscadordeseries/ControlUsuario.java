package buscadordeseries;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class ControlUsuario extends CsvControlador<Usuario> {
    private LinkedList<Usuario> usuarios ;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public ControlUsuario() {
        this.usuarios= new LinkedList<>();
    }

    @Override
    protected String getFileName() {
        return "usuarios.csv";
    }

    @Override
    public void save(LinkedList<Usuario> entidad) throws IOException {
        File archivoUsuarios = new File(getFileName());
        archivoUsuarios.delete();
        CsvWriter csvWriter =new CsvWriter(new FileWriter(getFileName(),true),';');

        addHeaders(csvWriter);
        for (Usuario usuario:
                entidades) {
            writeUsuarios(csvWriter,usuario);
        }
        csvWriter.close();
    }

    @Override
    public LinkedList<Usuario> load() {
        try{
            entidades = new LinkedList<>();
            CsvReader leerUsuarios = new CsvReader(getFileName(),';');
            leerUsuarios.readHeaders();
            int cont=1;
            while (leerUsuarios.readRecord()){
                entidades.add(parseSerie(leerUsuarios,cont));
                cont++;
            }
            leerUsuarios.close();

        } catch(IOException | ParseException e){
            e.printStackTrace();
        }
        return entidades;
    }
    private void addHeaders(CsvWriter csvWriter)throws IOException{

        csvWriter.write("nombre");
        csvWriter.write("apellido");
        csvWriter.write("ocupacion");
        csvWriter.write("email");
        csvWriter.write("contraseña");
        csvWriter.write("fechaNacimiento");
        csvWriter.write("mayor14");
        csvWriter.write("tipoUsuario");
        csvWriter.endRecord();
    }
    private void writeUsuarios(CsvWriter csvWriter, Usuario usuario)throws IOException{

        csvWriter.write(usuario.getNombre());
        csvWriter.write(usuario.getApellido());
        csvWriter.write(usuario.getOcupacion());
        csvWriter.write(usuario.getEmail());
        csvWriter.write(usuario.getContraseña());
        csvWriter.write(dateFormat.format(usuario.getFechaNacimiento()));
        csvWriter.write((usuario.getTipoUsuario().value));
        csvWriter.write(String.valueOf(usuario.isMayor14()));
        csvWriter.endRecord();
    }
    private Usuario parseSerie(CsvReader leerUsuarios, int cont) throws IOException, ParseException {

        String nombre = leerUsuarios.get(0);
        String apellido = leerUsuarios.get(1);
        String ocupacion =  leerUsuarios.get(2);
        String email= leerUsuarios.get(3);
        String contraseña = leerUsuarios.get(5);
        Date fechaNacimiento = dateFormat.parse(leerUsuarios.get(4));
        boolean mayor14 = Boolean.parseBoolean(leerUsuarios.get(6));
        TipoUsuario tipoUsuario = TipoUsuario.get(leerUsuarios.get(7));

        return new Usuario(cont,nombre,apellido,ocupacion,email,contraseña,fechaNacimiento,mayor14,tipoUsuario);
    }
}
