package buscadordeseries;

import java.util.LinkedList;

public interface Mantenedor<T extends Entidad>  {
    LinkedList<T> buscarDatos();
    void editarDatos(int id, T entidad);
    void agregarDatos(T entidad);
    void eliminarDatos(int id);
}
