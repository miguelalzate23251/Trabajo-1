package Ejercicio1.MiguelAlzate.repositorio;

import Ejercicio1.MiguelAlzate.modelo.Experimento;
import Ejercicio1.MiguelAlzate.modelo.INVESTIGADOR;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvestigadorRepository {

    public List<INVESTIGADOR> obtenerInvestigadores() {
        List<INVESTIGADOR> lista = new ArrayList<>();

        // 1. Investigador con 1
        List<Experimento> exps1 = List.of(
                new Experimento("Cultivo de Penicilina", "Microbiología", 110, 6000)
        );
        lista.add(new INVESTIGADOR("Lic. Alexander Fleming", exps1));

        // 2. Investigador con 2
        List<Experimento> exps2 = List.of(
                new Experimento("Vacuna contra la Rabia", "Medicina", 240, 20000),
                new Experimento("Pasteurización de Leche", "Biología", 80, 4500)
        );
        lista.add(new INVESTIGADOR("Lic. Louis Pasteur", exps2));

        // 3. Investigador con 3
        List<Experimento> exps3 = List.of(
                new Experimento("Estructura de ADN Foto 51", "Biofísica", 160, 14000),
                new Experimento("Difracción de Rayos X en Virus", "Bioquímica", 210, 19000),
                new Experimento("Estudio del Grafito", "Química", 70, 3500)
        );
        lista.add(new INVESTIGADOR("Dra. Rosalind Franklin", exps3));

        // 4. Investigador con 4
        List<Experimento> exps4 = List.of(
                new Experimento("Selección Natural en Galápagos", "Biología Evolutiva", 350, 30000),
                new Experimento("Análisis de Pinzones", "Zoología", 100, 7000),
                new Experimento("Fosilización de Moluscos", "Geología", 130, 9500),
                new Experimento("Clasificación de Orquídeas", "Botánica", 85, 4000)
        );
        lista.add(new INVESTIGADOR("Lic. Charles Darwin", exps4));

        return lista;
    }
}
