package app.cine;

import app.cine.servicios.CineServicio;

public class Main {

    public static void main(String[] args) {

        CineServicio cs = new CineServicio();

        cs.ubicar();
    }
}
