package app.cine.servicios;

import app.cine.entidades.Cine;
import app.cine.entidades.Espectador;
import app.cine.entidades.Pelicula;
import java.util.Scanner;

public class CineServicio extends Cine{

    Scanner sc;

    public String[][] inicializarCine() {

        String[][] matrizAux = new String[8][6];
        char letra = 'A';
        int cont = 1;

        for (int i = 0; i < matrizAux.length; i++) {
            for (int j = 0; j < 6; j++) {

                String fila = Integer.toString(cont);
                matrizAux[i][j] = fila + letra;

                letra++;
            }
            cont++;
            letra = 'A';
        }

        setSala(matrizAux);
        sc = new Scanner(System.in).useDelimiter("\n");

        return matrizAux;
    }

    public Pelicula cargarPelicula(){

        sc = new Scanner(System.in).useDelimiter("\n");
        Pelicula peli = new Pelicula();

        System.out.print("Ingrese el nombre de la pelicula: ");
        peli.setTitulo(sc.nextLine());

        System.out.print("Ingrese el director: ");
        peli.setDirector(sc.nextLine());

        System.out.print("Ingrese la duracion de la pelicula: ");
        peli.setDuracion(sc.nextDouble());

        System.out.print("Ingrese la edad minima: ");
        peli.setEdadMinima(sc.nextInt());

        return peli;
    }

    public Espectador cargarEspectador(){

        sc = new Scanner(System.in).useDelimiter("\n");
        Espectador espectador = new Espectador();

        System.out.print("Ingrese el nombre del espectador: ");
        espectador.setNombre(sc.nextLine());

        System.out.print("Ingrese la edad del espectador: ");
        espectador.setEdad(sc.nextInt());

        System.out.print("Ingrese el dinero disponible: ");
        espectador.setDineroDisponible(sc.nextDouble());
        System.out.println();

        return espectador;
    }

    public void ubicar(){

        String[][] cine = inicializarCine();
        System.out.println("-----DATOS DE PELICULA-----\n");
        Pelicula pelicula = cargarPelicula();
        
        System.out.print("ingrese el precio de la pelicula: ");
        setPrecio(sc.nextDouble());
        System.out.println();

        String resp = "";

        do {
            int fila = (int) (Math.random()*8);
            int columna = (int) (Math.random()*6);

            System.out.println("-----DATOS DEL ESPECTADOR-----\n");
            Espectador espectador = cargarEspectador();
            boolean ocupado = false;

            while (!ocupado){
                if (!cine[fila][columna].contains("x") && espectador.getDineroDisponible() >= getPrecio() &&
                        espectador.getEdad() >= pelicula.getEdadMinima()){

                    String aux = cine[fila][columna];
                    cine[fila][columna] = aux + " X";

                    System.out.println("---Ubicado correctamente---\n");
                    ocupado = true;
                } else if (espectador.getDineroDisponible() < getPrecio()) {

                    System.out.println("Dinero insuficiente");
                    ocupado = true;
                } else if (espectador.getEdad() < pelicula.getEdadMinima()) {

                    System.out.println("No puedes ingresar eres menor de edad");
                    ocupado = true;
                } else {

                    System.out.println("El lugar esta ocupado");
                    System.out.println("Reubicando...");

                    fila = (fila +1) %8;
                    columna = ((columna +1) %7);
                }
            }

            System.out.print("Ingresar a otro espectador si/no: \n");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("si"));

        for (int i = 7; i >= 0; i--){

            for (int j = 0; j < 6; j++){
                System.out.print(cine[i][j] + " | ");
            }
            System.out.println();
        }

    }

}
