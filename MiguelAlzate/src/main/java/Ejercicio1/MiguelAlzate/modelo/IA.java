package Ejercicio1.MiguelAlzate.modelo;

public class IA implements InterfaceReina {
    private Experimento experimento;

    public IA(Experimento experimento) {
        this.experimento = experimento;
    }

    @Override
    public String formularHipotesis(Experimento e) {
        return "La IA procesa grandes volúmenes de datos para generar una hipótesis sobre: " + e.getNombre() + " de tipo " + e.getTipo();
    }

    @Override
    public String ejecutar(Experimento e) {
        return "La IA simula la ejecución en un entorno virtual del experimento: " + e.getNombre();
    }

    @Override
    public String analizarResultados(Experimento e) {
        return "La IA utiliza redes neuronales para analizar los resultados de: " + e.getNombre();
    }
}
