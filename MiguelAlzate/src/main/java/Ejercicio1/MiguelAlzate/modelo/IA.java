package Ejercicio1.MiguelAlzate.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class IA implements InterfaceReina {
    private String nombre;
    private List<Experimento> experimentos;

    public IA(String nombre, List<Experimento> experimentos) {
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
            return "La " + nombre + " no registra datos para sintetizar hipótesis.";
        }
        String nombres = exps.stream().map(Experimento::getNombre).collect(Collectors.joining(", "));
        return "La " + nombre + " genera modelos predictivos e hipótesis para: [" + nombres + "]";
    }

    @Override
    public String ejecutar(List<Experimento> exps) {
        if (exps == null || exps.isEmpty()) {
            return "La " + nombre + " no registra experimentos para simular.";
        }
        String nombres = exps.stream().map(Experimento::getNombre).collect(Collectors.joining(", "));
        return "La " + nombre + " ejecuta simulaciones virtuales intensivas de: [" + nombres + "]";
    }

    @Override
    public String analizarResultados(List<Experimento> exps) {
        if (exps == null || exps.isEmpty()) {
            return "La " + nombre + " en estado de reposo (0 analíticas).";
        }
        String nombres = exps.stream().map(Experimento::getNombre).collect(Collectors.joining(", "));
        return "La " + nombre + " aplica redes neuronales profundas para analizar: [" + nombres + "]";
    }
}
