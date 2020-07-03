package buscadordeseries;

public abstract class Entidad<T> {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
