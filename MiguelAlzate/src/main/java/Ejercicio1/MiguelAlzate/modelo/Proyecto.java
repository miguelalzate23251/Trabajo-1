package Ejercicio1.MiguelAlzate.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class Proyecto {
    private String nombre;
    private String codigo;
    private EnumExperimento enumExperimento;
    private Categoria categoria;
    private Deque<Experimento> experimentos;

    // Constructor vacío requerido por el taller
    public Proyecto() {
        this.experimentos = new ArrayDeque<>();
    }

    // Constructor con todos los atributos requeridos incluyendo los dos enums
    public Proyecto(String nombre, String codigo, EnumExperimento enumExperimento,
                    Categoria categoria, Deque<Experimento> experimentos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.enumExperimento = enumExperimento;
        this.categoria = categoria;
        this.experimentos = (experimentos != null) ? experimentos : new ArrayDeque<>();
    }

    // Método para agregar datos al Deque de experimentos
    public void agregarExperimento(Experimento exp) {
        if (this.experimentos == null) {
            this.experimentos = new ArrayDeque<>();
        }
        this.experimentos.add(exp);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Deque<Experimento> getExperimentos() {
        return experimentos;
    }

    public void setExperimentos(Deque<Experimento> experimentos) {
        this.experimentos = experimentos;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", enumExperimento=" + enumExperimento +
                ", categoria=" + categoria +
                ", experimentos=" + experimentos +
                '}';
    }
}
