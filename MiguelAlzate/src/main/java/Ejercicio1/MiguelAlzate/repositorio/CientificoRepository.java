package Ejercicio1.MiguelAlzate.repositorio;

import Ejercicio1.MiguelAlzate.modelo.CIENTIFICO;
import Ejercicio1.MiguelAlzate.modelo.Experimento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class CientificoRepository {

    public List<CIENTIFICO> obtenerCientificos() {
        List<CIENTIFICO> lista = new ArrayList<>();

        // 1. Científico con 0
        lista.add(new CIENTIFICO("Dr. Isaac Newton", Collections.emptyList()));

        // 2. Científico con 1
        List<Experimento> exps1 = List.of(
                new Experimento("Gravedad Universal", "Física", 120, 5000)
        );
        lista.add(new CIENTIFICO("Dr. Albert Einstein", exps1));

        // 3. Científico con 2
        List<Experimento> exps2 = List.of(
                new Experimento("Radioactividad del Radio", "Química", 200, 15000),
                new Experimento("Aislamiento del Polonio", "Química", 180, 12000)
        );
        lista.add(new CIENTIFICO("Dra. Marie Curie", exps2));

        // 4. Científico con 3
        List<Experimento> exps3 = List.of(
                new Experimento("Bobina de Alta Frecuencia", "Física Electrónica", 90, 8000),
                new Experimento("Transmisión Inalámbrica", "Ingeniería", 300, 25000),
                new Experimento("Motor de Corriente Alterna", "Ingeniería", 150, 18000)
        );
        lista.add(new CIENTIFICO("Dr. Nikola Tesla", exps3));

        return lista;
    }
}
