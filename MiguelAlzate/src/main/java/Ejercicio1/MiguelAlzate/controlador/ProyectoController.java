package Ejercicio1.MiguelAlzate.controlador;

import Ejercicio1.MiguelAlzate.modelo.EnumExperimento;
import Ejercicio1.MiguelAlzate.modelo.Experimento;
import Ejercicio1.MiguelAlzate.modelo.Proyecto;
import Ejercicio1.MiguelAlzate.repositorio.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @GetMapping({"/", "/trabajo3"})
    public String index() {
        return "index";
    }

    // PUNTO 1: Petición 1 - Verificación de la estructura y objetos en Stack y Deque
    @GetMapping({"/peticion1", "/trabajo3/peticion1"})
    public String peticion1(Model model) {
        Stack<Experimento> stack = proyectoRepository.obtenerStackExperimentos();
        Proyecto proyecto = proyectoRepository.obtenerProyecto();

        List<String> detalles = new ArrayList<>();
        detalles.add("Proyecto creado: " + proyecto.getNombre() + " (Código: " + proyecto.getCodigo() + ")");
        detalles.add("Enums del Proyecto -> EnumExperimento: " + proyecto.getEnumExperimento() + " | Categoria: " + proyecto.getCategoria());
        detalles.add("Total de experimentos en Deque del Proyecto: " + proyecto.getExperimentos().size());
        detalles.add("Total de experimentos en Stack individual: " + stack.size());
        detalles.add("--- Detalle de los 5 Experimentos creados en el Stack ---");

        int i = 1;
        for (Experimento exp : stack) {
            detalles.add("Experimento " + i + ": " + exp.getNombre() +
                    " | Enum: " + exp.getEnumExperimento() +
                    " | Categoría: " + exp.getCategoria() +
                    " | Conteo (Stack): " + exp.getConteo() +
                    " (Cantidad de datos en conteo: " + exp.getConteo().size() + ")");
            i++;
        }

        model.addAttribute("titulo", "Trabajo 3 - Punto 1: Creación de Enums, Stack y Deque");
        model.addAttribute("listaStrings", detalles);

        return "trabajo3";
    }

    // PUNTO 2: Petición 2 - Uso de ListIterator (Stack) e Iterator (Deque)
    @GetMapping({"/peticion2", "/trabajo3/peticion2"})
    public String peticion2(Model model) {
        Stack<Experimento> stack = proyectoRepository.obtenerStackExperimentos();
        Proyecto proyecto = proyectoRepository.obtenerProyecto();

        List<String> resultados = new ArrayList<>();

        resultados.add("=== 1. Recorrido con ListIterator sobre el Stack de 5 Experimentos ===");
        ListIterator<Experimento> listIterator = stack.listIterator();
        while (listIterator.hasNext()) {
            Experimento exp = listIterator.next();
            resultados.add("[ListIterator] " + exp.getNombre() +
                    " | Tipo: " + exp.getTipo() +
                    " | Enum: " + exp.getEnumExperimento() +
                    " | Categoría: " + exp.getCategoria() +
                    " | Presupuesto: $" + exp.getPresupuesto() +
                    " | Conteo: " + exp.getConteo());
        }

        resultados.add("=== 2. Recorrido con Iterator sobre el Deque del objeto Proyecto ===");
        Iterator<Experimento> dequeIterator = proyecto.getExperimentos().iterator();
        while (dequeIterator.hasNext()) {
            Experimento exp = dequeIterator.next();
            resultados.add("[Iterator Deque] " + exp.getNombre() +
                    " | Tipo: " + exp.getTipo() +
                    " | Enum: " + exp.getEnumExperimento() +
                    " | Categoría: " + exp.getCategoria() +
                    " | Presupuesto: $" + exp.getPresupuesto() +
                    " | Conteo: " + exp.getConteo());
        }

        model.addAttribute("titulo", "Trabajo 3 - Punto 2: Recorridos con ListIterator e Iterator");
        model.addAttribute("listaStrings", resultados);

        return "trabajo3";
    }

    // PUNTO 3: Petición 3 - Conversión y Programación funcional sobre el Deque filtrando por Enum
    @GetMapping({"/peticion3", "/trabajo3/peticion3"})
    public String peticion3(Model model) {
        Stack<Experimento> stack = proyectoRepository.obtenerStackExperimentos();
        // Conversión explícita según la rúbrica del docente: Deque<T> deque = new ArrayDeque<>(T);
        Deque<Experimento> deque = new ArrayDeque<>(stack);

        Proyecto proyecto = proyectoRepository.obtenerProyecto();
        Deque<Experimento> dequeProyecto = proyecto.getExperimentos();

        EnumExperimento enumBuscado = EnumExperimento.INTELIGENCIA_ARTIFICIAL;

        // Filtrado funcional sobre el Deque por el Enum específico
        List<String> filtrados = deque.stream()
                .filter(exp -> exp.getEnumExperimento() == enumBuscado)
                .map(exp -> "Experimento: " + exp.getNombre() +
                        " | Enum: " + exp.getEnumExperimento() +
                        " | Categoría: " + exp.getCategoria() +
                        " | Duración: " + exp.getDuracionHoras() + "h" +
                        " | Conteo: " + exp.getConteo())
                .collect(Collectors.toList());

        List<String> resultados = new ArrayList<>();
        resultados.add("Conversión explícita aplicada: Deque<Experimento> deque = new ArrayDeque<>(stack);");
        resultados.add("Deque del objeto Proyecto ('" + proyecto.getNombre() + "') con " + dequeProyecto.size() + " experimentos.");
        resultados.add("Filtro aplicado sobre Deque con Programación Funcional: EnumExperimento == " + enumBuscado);
        resultados.add("Total de objetos coincidentes: " + filtrados.size());
        resultados.addAll(filtrados);

        model.addAttribute("titulo", "Trabajo 3 - Punto 3: Filtrado Funcional sobre Deque por Enum");
        model.addAttribute("listaStrings", resultados);

        return "trabajo3";
    }

    // PUNTO 4: Petición 4 - Interface Function<T,R> para sumar datos del Stack conteo
    @GetMapping({"/peticion4", "/trabajo3/peticion4"})
    public String peticion4(Model model) {
        Stack<Experimento> stack = proyectoRepository.obtenerStackExperimentos();

        // Función que utiliza Function<T, R> (recibe Experimento y retorna la suma Integer de su Stack)
        Function<Experimento, Integer> sumarConteoFunction = exp -> {
            if (exp.getConteo() == null || exp.getConteo().isEmpty()) {
                return 0;
            }
            return exp.getConteo().stream().mapToInt(Integer::intValue).sum();
        };

        List<String> resultados = new ArrayList<>();
        resultados.add("Definición de función: Function<Experimento, Integer> sumarConteoFunction = exp -> exp.getConteo().sum()");
        resultados.add("Invocación con el método sumarConteoFunction.apply(experimento):");

        for (Experimento exp : stack) {
            Integer suma = sumarConteoFunction.apply(exp);
            resultados.add("-> " + exp.getNombre() +
                    " | Datos en Stack conteo: " + exp.getConteo() +
                    " | Total Sumado: " + suma);
        }

        model.addAttribute("titulo", "Trabajo 3 - Punto 4: Function<T,R> para Sumar Datos del Stack");
        model.addAttribute("listaStrings", resultados);

        return "trabajo3";
    }

    // PUNTO 5: Petición 5 - Método verTotales() en Experimento que recibe Function<T,R>
    @GetMapping({"/peticion5", "/trabajo3/peticion5"})
    public String peticion5(Model model) {
        Stack<Experimento> stack = proyectoRepository.obtenerStackExperimentos();

        // Función del Punto 4
        Function<Experimento, Integer> sumarConteoFunction = exp -> {
            if (exp.getConteo() == null || exp.getConteo().isEmpty()) {
                return 0;
            }
            return exp.getConteo().stream().mapToInt(Integer::intValue).sum();
        };

        // Objeto de la clase Experimento que llama a su método verTotales()
        Experimento expEjemplo = stack.peek(); // Objeto 5: Red Generativa GAN con [8, 12, 40, 50]
        Integer totalObtenido = expEjemplo.verTotales(sumarConteoFunction);

        String resultado = "El objeto '" + expEjemplo.getNombre() + "' ejecutó el método exp.verTotales(sumarConteoFunction)." +
                " | Datos en Stack: " + expEjemplo.getConteo() +
                " | Total de datos enteros devuelto: " + totalObtenido;

        model.addAttribute("titulo", "Trabajo 3 - Punto 5: Método verTotales(Function) en Experimento");
        model.addAttribute("resultadoCadena", resultado);

        return "trabajo3";
    }
}
