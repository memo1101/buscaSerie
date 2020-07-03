package buscadordeseries;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public abstract class CsvControlador<T extends Entidad> implements  Mantenedor<T>{
    protected LinkedList<T> entidades;

    public CsvControlador() {
        entidades=new LinkedList<>();
    }

    @Override
    public LinkedList<T> buscarDatos() {
        return load();
    }

    @Override
    public void editarDatos(int id, T entidad) {
        try {
            load();
            entidades.set(id-1,entidad);
            save(entidades);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void agregarDatos(T entidad) {
        try {
            load();
            entidades.add(entidad);
            save(entidades);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarDatos(int id) {
        try {
            load();
            entidades.remove(id-1);
            save(entidades);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected abstract String getFileName();

    public abstract void save(LinkedList<T> entidad)throws IOException;

    public abstract LinkedList<T> load();

}
