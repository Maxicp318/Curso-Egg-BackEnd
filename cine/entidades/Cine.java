package app.cine.entidades;

public class Cine {
    
    private String pelicula;
    private double precio;
    private String[][] sala;

    public Cine() {
    }

    public Cine(String pelicula, double precio) {
        this.pelicula = pelicula;
        this.precio = precio;
        this.sala = new String[8][6];
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String[][] getSala() {
        return sala;
    }

    public void setSala(String[][] sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Cine{" + "pelicula=" + pelicula + ", precio=" + precio + ", sala=" + sala + '}';
    }
}
