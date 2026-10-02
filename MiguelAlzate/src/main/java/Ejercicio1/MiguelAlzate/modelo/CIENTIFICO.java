package Ejercicio1.MiguelAlzate.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class CIENTIFICO implements InterfaceReina {
    private String nombre;
    private List<Experimento> experimentos;

    public CIENTIFICO(String nombre, List<Experimento> experimentos) {
        this.nombre = nombre;
        this.experimentos = experimentos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public List<Experimento> getExperimentos() {
        return experimentos;
    }

    @Override
    public String formularHipotesis(List<Experimento> exps) {
        if (exps == null || exps.isEmpty()) {
            return "El Científico " + nombre + " no tiene experimentos para formular hipótesis.";
        }
        String nombres = exps.stream().map(Experimento::getNombre).collect(Collectors.joining(", "));
        return "El Científico " + nombre + " formula una hipótesis para los experimentos: [" + nombres + "]";
    }

    @Override
    public String ejecutar(List<Experimento> exps) {
        if (exps == null || exps.isEmpty()) {
            return "El Científico " + nombre + " no tiene experimentos para ejecutar.";
        }
        String nombres = exps.stream().map(Experimento::getNombre).collect(Collectors.joining(", "));
        return "El Científico " + nombre + " ejecuta los experimentos: [" + nombres + "]";
    }

    @Override
    public String analizarResultados(List<Experimento> exps) {
        if (exps == null || exps.isEmpty()) {
            return "El Científico " + nombre + " no tiene experimentos para analizar.";
        }
        String nombres = exps.stream().map(Experimento::getNombre).collect(Collectors.joining(", "));
        return "El Científico " + nombre + " analiza los resultados de los experimentos: [" + nombres + "]";
    }
}
