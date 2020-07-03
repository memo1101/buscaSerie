package buscadordeseries;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ControlUsuario controlUsuario =new ControlUsuario();
        LinkedList<Usuario> usuarios = new LinkedList<>();
        usuarios= controlUsuario.load();
        System.out.println("");
        ControlSeries controlSeries =new ControlSeries();
        LinkedList<Serie> series = new LinkedList<>();
        series= controlSeries.load();
        System.out.println();

    }
}
