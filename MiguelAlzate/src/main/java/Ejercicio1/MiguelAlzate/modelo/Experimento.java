package Ejercicio1.MiguelAlzate.modelo;

public class Experimento {
    private String nombre;
    private String tipo;
    private Integer duracionHoras;
    private Integer presupuesto;

    public Experimento(String nombre, String tipo, Integer duracionHoras, Integer presupuesto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracionHoras = duracionHoras;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Experimento{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", duracionHoras=" + duracionHoras +
                ", presupuesto=" + presupuesto +
                '}';
    }
}