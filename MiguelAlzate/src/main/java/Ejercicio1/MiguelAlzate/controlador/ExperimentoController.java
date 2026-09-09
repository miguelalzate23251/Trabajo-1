package Ejercicio1.MiguelAlzate.controlador;

import Ejercicio1.MiguelAlzate.modelo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExperimentoController {

    @GetMapping("/trabajo1")
    public String mostrarPolimorfismo(Model model) {
        Experimento exp1 = new Experimento("Reacción Química A", "Química");
        Experimento exp2 = new Experimento("Cultivo de Bacterias", "Biología");
        Experimento exp3 = new Experimento("Simulación Cuántica", "Física");
        Experimento exp4 = new Experimento("Estudio Psicológico", "Psicología");
        Experimento exp5 = new Experimento("Resistencia de Materiales", "Ingeniería");
        Experimento exp6 = new Experimento("Análisis de Datos", "Informática");
        Experimento exp7 = new Experimento("Observación Astronómica", "Astronomía");
        Experimento exp8 = new Experimento("Crecimiento de Plantas", "Botánica");
        Experimento exp9 = new Experimento("Reacción Nuclear", "Física Nuclear");

        ArrayList<InterfaceReina> objetos = new ArrayList<>();
        objetos.add(new CIENTIFICO(exp1));
        objetos.add(new CIENTIFICO(exp2));
        objetos.add(new CIENTIFICO(exp3));
        objetos.add(new INVESTIGADOR(exp4));
        objetos.add(new INVESTIGADOR(exp5));
        objetos.add(new INVESTIGADOR(exp6));
        objetos.add(new IA(exp7));
        objetos.add(new IA(exp8));
        objetos.add(new IA(exp9));

        ArrayList<Experimento> experimentos = new ArrayList<>();
        experimentos.add(exp1);
        experimentos.add(exp2);
        experimentos.add(exp3);
        experimentos.add(exp4);
        experimentos.add(exp5);
        experimentos.add(exp6);
        experimentos.add(exp7);
        experimentos.add(exp8);
        experimentos.add(exp9);

        List<String> resultados = new ArrayList<>();

        // Iterar con polimorfismo como en las diapositivas usando ArrayList y for mejorado (foreach)
        int index = 0;
        for (InterfaceReina op : objetos) {
            Experimento expActual = experimentos.get(index);
            
            String res = "<b>Objeto " + (index + 1) + " (" + op.getClass().getSimpleName() + "):</b><br>";
            res += "- " + op.formularHipotesis(expActual) + "<br>";
            res += "- " + op.ejecutar(expActual) + "<br>";
            res += "- " + op.analizarResultados(expActual) + "<br><br>";
            
            resultados.add(res);
            index++;
        }

        model.addAttribute("resultados", resultados);

        return "vista";
    }
}
