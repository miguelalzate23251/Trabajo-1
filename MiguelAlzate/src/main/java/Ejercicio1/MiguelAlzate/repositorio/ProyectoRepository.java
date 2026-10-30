package Ejercicio1.MiguelAlzate.repositorio;

import Ejercicio1.MiguelAlzate.modelo.Categoria;
import Ejercicio1.MiguelAlzate.modelo.EnumExperimento;
import Ejercicio1.MiguelAlzate.modelo.Experimento;
import Ejercicio1.MiguelAlzate.modelo.Proyecto;
import org.springframework.stereotype.Repository;

import java.util.ArrayDeque;
import java.util.Stack;

@Repository
public class ProyectoRepository {

    public Stack<Experimento> obtenerStackExperimentos() {
        Stack<Experimento> stack = new Stack<>();

        // Los 5 objetos comparten los mismos enums según la consigna:
        EnumExperimento enumComun = EnumExperimento.INTELIGENCIA_ARTIFICIAL;
        Categoria categoriaComun = Categoria.TECNOLOGIA;

        // Objeto 1: Conteo con 0 datos
        Experimento exp1 = new Experimento("Simulación NLP", "Procesamiento de Lenguaje Natural", 50, 15000,
                enumComun, categoriaComun, new Stack<>());

        // Objeto 2: Conteo con 1 dato
        Experimento exp2 = new Experimento("Red Convolucional", "Visión Artificial", 80, 25000,
                enumComun, categoriaComun, new Stack<>());
        exp2.agregarConteo(15);

        // Objeto 3: Conteo con 2 datos
        Experimento exp3 = new Experimento("Modelo Predictivo", "Predicción de Series Temporales", 120, 35000,
                enumComun, categoriaComun, new Stack<>());
        exp3.agregarConteo(10);
        exp3.agregarConteo(20);

        // Objeto 4: Conteo con 3 datos
        Experimento exp4 = new Experimento("Agente Autónomo", "Aprendizaje por Refuerzo", 200, 50000,
                enumComun, categoriaComun, new Stack<>());
        exp4.agregarConteo(5);
        exp4.agregarConteo(25);
        exp4.agregarConteo(30);

        // Objeto 5: Conteo con 4 datos
        Experimento exp5 = new Experimento("Red Generativa GAN", "Generación de Datos Sintéticos", 300, 80000,
                enumComun, categoriaComun, new Stack<>());
        exp5.agregarConteo(8);
        exp5.agregarConteo(12);
        exp5.agregarConteo(40);
        exp5.agregarConteo(50);

        // Agregar al Stack de experimentos
        stack.push(exp1);
        stack.push(exp2);
        stack.push(exp3);
        stack.push(exp4);
        stack.push(exp5);

        return stack;
    }

    public Proyecto obtenerProyecto() {
        EnumExperimento enumComun = EnumExperimento.INTELIGENCIA_ARTIFICIAL;
        Categoria categoriaComun = Categoria.TECNOLOGIA;

        // Crear objeto Proyecto de la columna F con los mismos enums
        Proyecto proyecto = new Proyecto("Proyecto Innovación IA", "PRJ-IA-001",
                enumComun, categoriaComun, new ArrayDeque<>());

        // Obtener los 5 objetos del Stack y agregarlos al Deque usando el método asignado
        Stack<Experimento> stack = obtenerStackExperimentos();
        for (Experimento exp : stack) {
            proyecto.agregarExperimento(exp);
        }

        return proyecto;
    }
}
