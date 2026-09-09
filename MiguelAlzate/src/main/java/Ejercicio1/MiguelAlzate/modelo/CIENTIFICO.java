package Ejercicio1.MiguelAlzate.modelo;

public class CIENTIFICO implements InterfaceReina {
    private Experimento experimento;

    public CIENTIFICO(Experimento experimento) {
        this.experimento = experimento;
    }

    @Override
    public String formularHipotesis(Experimento e) {
        return "El CIENTIFICO está formulando una hipótesis para el experimento: " + e.getNombre() + " de tipo " + e.getTipo();
    }

    @Override
    public String ejecutar(Experimento e) {
        return "El CIENTIFICO está ejecutando el experimento: " + e.getNombre();
    }

    @Override
    public String analizarResultados(Experimento e) {
        return "El CIENTIFICO está analizando los resultados de: " + e.getNombre();
    }
}
