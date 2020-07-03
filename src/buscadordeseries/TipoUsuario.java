package buscadordeseries;

public enum TipoUsuario {
    USUARIO("USUARIO"),ADMINISTRADOR("ADMINISTRADOR");
    public String value;
    TipoUsuario(String value) {
        this.value=value;
    }

    public static TipoUsuario get(String value){
        TipoUsuario tipoUsuario=null;
        for (TipoUsuario t:TipoUsuario.values()
             ) {
            if (t.value.equals(value)){
                tipoUsuario=t;
            }
        }
        return tipoUsuario;
    }
}
