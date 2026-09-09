package Ejercicio1.MiguelAlzate.modelo;

public class INVESTIGADOR implements InterfaceReina {
    private Experimento experimento;

    public INVESTIGADOR(Experimento experimento) {
        this.experimento = experimento;
    }

    @Override
    public String formularHipotesis(Experimento e) {
        return "El INVESTIGADOR revisa la literatura y formula la hipótesis para: " + e.getNombre() + " de tipo " + e.getTipo();
    }

    @Override
    public String ejecutar(Experimento e) {
        return "El INVESTIGADOR lleva a cabo las pruebas de: " + e.getNombre();
    }

    @Override
    public String analizarResultados(Experimento e) {
        return "El INVESTIGADOR tabula y analiza los datos de: " + e.getNombre();
    }
}
