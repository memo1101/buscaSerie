package buscadordeseries;

import java.util.Date;

public class Usuario extends Entidad {
    private String nombre;
    private String apellido;
    private String ocupacion;
    private String email;
    private String contrasenya;
    private Date fechaNacimiento;
    private boolean mayor14;
    private TipoUsuario tipoUsuario;

    public Usuario(int id,String nombre, String apellido, String ocupacion, String email, String contrasenya, Date fechaNacimiento, boolean mayor14, TipoUsuario tipoUsuario) {
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ocupacion = ocupacion;
        this.email = email;
        this.contrasenya = contrasenya;
        this.fechaNacimiento = fechaNacimiento;
        this.mayor14 = mayor14;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isMayor14() {
        return mayor14;
    }

    public void setMayor14(boolean mayor14) {
        this.mayor14 = mayor14;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
