package Ejercicio1.MiguelAlzate.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class INVESTIGADOR implements InterfaceReina {
    private String nombre;
    private List<Experimento> experimentos;

    public INVESTIGADOR(String nombre, List<Experimento> experimentos) {
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
            return "El Investigador " + nombre + " sin experimentos asignados para hipótesis.";
        }
        String nombres = exps.stream().map(Experimento::getNombre).collect(Collectors.joining(", "));
        return "El Investigador " + nombre + " revisa la literatura y formula hipótesis sobre: [" + nombres + "]";
    }

    @Override
    public String ejecutar(List<Experimento> exps) {
        if (exps == null || exps.isEmpty()) {
            return "El Investigador " + nombre + " sin experimentos para pruebas de laboratorio.";
        }
        String nombres = exps.stream().map(Experimento::getNombre).collect(Collectors.joining(", "));
        return "El Investigador " + nombre + " realiza pruebas de laboratorio para: [" + nombres + "]";
    }

    @Override
    public String analizarResultados(List<Experimento> exps) {
        if (exps == null || exps.isEmpty()) {
            return "El Investigador " + nombre + " sin datos para tabular.";
        }
        String nombres = exps.stream().map(Experimento::getNombre).collect(Collectors.joining(", "));
        return "El Investigador " + nombre + " tabula los datos recopilados de: [" + nombres + "]";
    }
}
