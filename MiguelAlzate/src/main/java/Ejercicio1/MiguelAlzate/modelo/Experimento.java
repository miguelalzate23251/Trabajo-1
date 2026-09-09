package Ejercicio1.MiguelAlzate.modelo;

public class Experimento {
    private String nombre;
    private String tipo;

    public Experimento(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
}