package Ejercicio1.MiguelAlzate.repositorio;

import Ejercicio1.MiguelAlzate.modelo.Experimento;
import Ejercicio1.MiguelAlzate.modelo.IA;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IARepository {

    public List<IA> obtenerIAs() {
        List<IA> lista = new ArrayList<>();

        // 1. IA con 2
        List<Experimento> exps2 = List.of(
                new Experimento("Red Neuronal ", "Inteligencia Artificial", 45, 30000),
                new Experimento("Procesamiento de Lenguaje Natural", "IA", 60, 45000)
        );
        lista.add(new IA("GPT-4 Universo", exps2));

        // 2. IA con 3
        List<Experimento> exps3 = List.of(
                new Experimento("Plegamiento de Proteínas AlphaFold", "Bioinformática", 500, 100000),
                new Experimento("Optimizador de Algoritmos AlphaDev", "Computación", 320, 80000),
                new Experimento("Navegación Robótica Autónomica", "Robótica", 140, 50000)
        );
        lista.add(new IA("Agente DeepMind", exps3));

        // 3. IA con 4
        List<Experimento> exps4 = List.of(
                new Experimento("Visión por Computador en Vehículos", "Autónomos", 190, 65000),
                new Experimento("Reconocimiento de Patrones Médicos", "Medicina IA", 220, 75000),
                new Experimento("Generación de Imágenes Difusión", "Arte IA", 40, 15000),
                new Experimento("Detección de Anomalías Financieras", "Finanzas", 75, 40000)
        );
        lista.add(new IA("Claude Analista", exps4));

        // 4. IA con 5
        List<Experimento> exps5 = List.of(
                new Experimento("Simulación de Fusión Nuclear Cuántica", "Física Cuántica", 600, 150000),
                new Experimento("Modelado del Clima Global 2050", "Climatología", 400, 110000),
                new Experimento("Cálculo de Órbitas de Exoplanetas", "Astrofísica", 280, 90000),
                new Experimento("Síntesis Sintética de Genomas", "Genética", 310, 95000),
                new Experimento("Encriptación Poscuántica", "Ciberseguridad", 170, 60000)
        );
        lista.add(new IA("Gemini Cuantica", exps5));

        return lista;
    }
}
