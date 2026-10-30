package Ejercicio1.MiguelAlzate.modelo;

import java.util.Stack;
import java.util.function.Function;

public class Experimento {
    private String nombre;
    private String tipo;
    private Integer duracionHoras;
    private Integer presupuesto;
    private EnumExperimento enumExperimento;
    private Categoria categoria;
    private Stack<Integer> conteo;

    // Constructor vacío requerido por el taller
    public Experimento() {
        this.conteo = new Stack<>();
    }

    // Constructor compatible con Trabajos 1 y 2
    public Experimento(String nombre, String tipo, Integer duracionHoras, Integer presupuesto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracionHoras = duracionHoras;
        this.presupuesto = presupuesto;
        this.conteo = new Stack<>();
    }

    // Constructor completo con todos los atributos requeridos en el Trabajo 3
    public Experimento(String nombre, String tipo, Integer duracionHoras, Integer presupuesto,
                       EnumExperimento enumExperimento, Categoria categoria, Stack<Integer> conteo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracionHoras = duracionHoras;
        this.presupuesto = presupuesto;
        this.enumExperimento = enumExperimento;
        this.categoria = categoria;
        this.conteo = (conteo != null) ? conteo : new Stack<>();
    }

    // Método para agregar datos al Stack de números llamado conteo
    public void agregarConteo(Integer valor) {
        if (this.conteo == null) {
            this.conteo = new Stack<>();
        }
        this.conteo.push(valor);
    }

    // Punto 5: Método verTotales que recibe la función de tipo Function<Experimento, Integer>
    public Integer verTotales(Function<Experimento, Integer> funcion) {
        if (funcion != null) {
            Integer total = funcion.apply(this);
            System.out.println("Total de datos en conteo para el experimento '" + this.nombre + "': " + total);
            return total;
        }
        return 0;
    }

    // Métodos getters y setters
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

    public EnumExperimento getEnumExperimento() {
        return enumExperimento;
    }

    public void setEnumExperimento(EnumExperimento enumExperimento) {
        this.enumExperimento = enumExperimento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Stack<Integer> getConteo() {
        return conteo;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.conteo = conteo;
    }

    @Override
    public String toString() {
        return "Experimento{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", duracionHoras=" + duracionHoras +
                ", presupuesto=" + presupuesto +
                ", enumExperimento=" + enumExperimento +
                ", categoria=" + categoria +
                ", conteo=" + conteo +
                '}';
    }
}
