package Ejercicio1.MiguelAlzate.controlador;

import Ejercicio1.MiguelAlzate.modelo.Experimento;
import Ejercicio1.MiguelAlzate.modelo.InterfaceReina;
import Ejercicio1.MiguelAlzate.repositorio.CientificoRepository;
import Ejercicio1.MiguelAlzate.repositorio.IARepository;
import Ejercicio1.MiguelAlzate.repositorio.InvestigadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Controller
public class ExperimentoController {

    @Autowired
    private CientificoRepository cientificoRepository;

    @Autowired
    private InvestigadorRepository investigadorRepository;

    @Autowired
    private IARepository iaRepository;

    private List<InterfaceReina> obtenerTodosLosObjetos() {
        List<InterfaceReina> todos = new ArrayList<>();
        todos.addAll(cientificoRepository.obtenerCientificos());
        todos.addAll(investigadorRepository.obtenerInvestigadores());
        todos.addAll(iaRepository.obtenerIAs());
        return todos;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/peticion1";
    }

    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        List<InterfaceReina> objetos = obtenerTodosLosObjetos();

        String nombresUnidos = objetos.stream()
                .map(InterfaceReina::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("titulo", "Petición 1");
        model.addAttribute("resultadoCadena", nombresUnidos);

        return "vista";
    }

    @GetMapping("/peticion2")
    public String peticion2(Model model) {
        List<InterfaceReina> objetos = obtenerTodosLosObjetos();

        IntSummaryStatistics estadisticas = objetos.stream()
                .flatMap(o -> o.getExperimentos().stream())
                .collect(Collectors.summarizingInt(Experimento::getPresupuesto));

        String resultadoStats = "Conteo: " + estadisticas.getCount() +
                " | Suma Total: " + estadisticas.getSum() +
                " | Promedio: " + String.format(Locale.US, "%.2f", estadisticas.getAverage()) +
                " | Mínimo: " + estadisticas.getMin() +
                " | Máximo: " + estadisticas.getMax();

        model.addAttribute("titulo", "Petición 2");
        model.addAttribute("resultadoCadena", resultadoStats);

        return "vista";
    }

    @GetMapping("/peticion3")
    public String peticion3(Model model) {
        List<InterfaceReina> objetos = obtenerTodosLosObjetos();

        List<String> nombresExperimentos = objetos.stream()
                .flatMap(o -> o.getExperimentos().stream())
                .map(Experimento::getNombre)
                .collect(Collectors.toList());

        model.addAttribute("titulo", "Petición 3");
        model.addAttribute("listaStrings", nombresExperimentos);

        return "vista";
    }

    @GetMapping("/peticion4")
    public String peticion4(Model model) {
        List<InterfaceReina> objetos = obtenerTodosLosObjetos();

        Predicate<Experimento> duracionMayor500Predicate = exp -> exp.getDuracionHoras() > 500;
        Predicate<Experimento> duracionMayor300Predicate = exp -> exp.getDuracionHoras() > 300;
        Predicate<Experimento> presupuestoNegativoPredicate = exp -> exp.getPresupuesto() < 0;

        // 1. allMatch: ¿TODOS los experimentos duran más de 500 horas? (Resultado: false)
        boolean allMatchDuracion = objetos.stream()
                .flatMap(o -> o.getExperimentos().stream())
                .allMatch(duracionMayor500Predicate);

        // 2. anyMatch: ¿Existe al menos un experimento con duración > 300 horas? (Resultado: true)
        boolean anyMatchDuracion = objetos.stream()
                .flatMap(o -> o.getExperimentos().stream())
                .anyMatch(duracionMayor300Predicate);

        // 3. noneMatch: ¿NINGÚN experimento tiene presupuesto negativo? (Resultado: true)
        boolean noneMatchPresupuestoNegativo = objetos.stream()
                .flatMap(o -> o.getExperimentos().stream())
                .noneMatch(presupuestoNegativoPredicate);

        List<String> validaciones = List.of(
                "allMatch (¿TODOS los experimentos duran > 500h?): " + allMatchDuracion + " (FALSO)",
                "anyMatch (¿Existe alguno con duración > 300h?): " + anyMatchDuracion + " (VERDADERO)",
                "noneMatch (¿NINGUNO tiene presupuesto negativo < 0?): " + noneMatchPresupuestoNegativo + " (VERDADERO)"
        );

        model.addAttribute("titulo", "Petición 4");
        model.addAttribute("listaStrings", validaciones);

        return "vista";
    }

    @GetMapping("/peticion5")
    public String peticion5(Model model) {
        List<InterfaceReina> objetos = obtenerTodosLosObjetos();

        Optional<Experimento> expMax = objetos.stream()
                .flatMap(o -> o.getExperimentos().stream())
                .max(Comparator.comparingInt(Experimento::getDuracionHoras));

        String res = expMax.map(m ->
                "El experimento con la mayor duración de tipo Integer es: '" + m.getNombre() + "'" +
                " | Tipo de Experimento: " + m.getTipo() +
                " | Duración: " + m.getDuracionHoras() + " horas" +
                " | Presupuesto: $" + m.getPresupuesto())
                .orElse("No se encontraron experimentos.");

        model.addAttribute("titulo", "Petición 5");
        model.addAttribute("resultadoCadena", res);

        return "vista";
    }
}   