package com.ejemplo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas, Marcelo Detlefsen, Alejandro Jerez
 * Creación: 19/02/2025
 * última modificación: 19/02/2025
 * File Name: Calculadora.java
 * Descripción: Calculadora encargada de evaluar las expresiones infix
 */

/*
 * Clase calculadora encargada de leer la expresión infix, convertirla en expresión postfix y calcular el resultado
 */
public class Calculadora {
    private final Stack<String> stack; // Stack para la conversión infix a postfix
    private final Stack<Integer> stackEvaluacion; // Stack para evaluar la expresión postfix
    private static Calculadora instancia;

    // Método principal (Main)
    public static void main(String[] args) {
        // Mostrar el menú y obtener la selección del usuario
        String eleccion = mostrarMenu();

        // Obtener la instancia de la Calculadora (Singleton)
        Calculadora calculadora = Calculadora.getInstancia(eleccion);

        // Ejecuta la lectura del archivo, y su traducción y evaluación indiviualmente
        calculadora.procesarArchivo();
    }

    // Método para mostrar el menú y seleccionar la implementación del stack
    public static String mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación del Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. List");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                return "ArrayList";
            case 2:
                return "Vector";
            case 3:
                System.out.println("Seleccione el tipo de List:");
                System.out.println("1. Simplemente encadenada");
                System.out.println("2. Doblemente encadenada");
                System.out.print("Opción: ");
                int tipoLista = scanner.nextInt();
                return (tipoLista == 1) ? "Simple" : "Doble";
            default:
                throw new IllegalArgumentException("Opción no válida");
        }
    }

    // Constructor privado (corregido)
    private Calculadora(String eleccion) {
        this.stack = StackFactory.getStack(eleccion); // Stack para infix a postfix
        this.stackEvaluacion = StackFactory.getStack(eleccion); // Stack para evaluación
    }

    // Método para obtener la instancia de la Calculadora
    public static Calculadora getInstancia(String eleccion) {
        if (instancia == null) {
            instancia = new Calculadora(eleccion);
        }
        return instancia;
    }

    // Método para leer el archivo datos.txt
    public void procesarArchivo() {
        try (Scanner scanner = new Scanner(new File("datos.txt"));
            FileWriter writer = new FileWriter("datosPostFix.txt")) {
    
            while (scanner.hasNextLine()) {
                String expresionInfix = scanner.nextLine().trim();
    
                if (!expresionInfix.isEmpty()) { // Evita líneas vacías
                    String expresionPostfix = infixAPostfix(expresionInfix);
                    int resultado = evaluarPostfix(expresionPostfix);
    
                    // Imprimir en consola
                    System.out.println("Expresión Infix: " + expresionInfix);
                    System.out.println("Expresión Postfix: " + expresionPostfix);
                    System.out.println("Resultado: " + resultado);
                    System.out.println("----------------------------");
    
                    // Guardar en archivo
                    writer.write(expresionPostfix + " = " + resultado + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para convertir una expresión infix a postfix
    public String infixAPostfix(String expresionInfix) {
        StringBuilder postfix = new StringBuilder();
        stack.push("#"); // Carácter especial para evitar underflow
        StringBuilder numero = new StringBuilder();
    
        for (int i = 0; i < expresionInfix.length(); i++) {
            char ch = expresionInfix.charAt(i);
    
            if (Character.isDigit(ch)) {
                numero.append(ch); // Construye el número completo
            } else {
                if (numero.length() > 0) {
                    postfix.append(numero).append(" "); // Agrega el número completo
                    numero.setLength(0); // Reinicia el buffer
                }
                if (ch == '(') {
                    stack.push(String.valueOf(ch)); // Apila paréntesis de apertura
                } else if (ch == ')') {
                    // Desapila hasta encontrar el paréntesis de apertura
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.pop(); // Elimina el paréntesis de apertura
                } else if (esOperador(ch)) {
                    // Desapila operadores con mayor o igual precedencia
                    while (!stack.isEmpty() && precedencia(ch) <= precedencia(stack.peek().charAt(0))) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.push(String.valueOf(ch)); // Apila el operador actual
                }
            }
        }
    
        // Agregar cualquier número que haya quedado pendiente
        if (numero.length() > 0) {
            postfix.append(numero).append(" ");
        }
    
        // Desapilar los operadores restantes
        while (!stack.isEmpty() && !stack.peek().equals("#")) {
            postfix.append(stack.pop()).append(" ");
        }
    
        return postfix.toString().trim(); // Elimina el espacio final
    }
    

    // Método para evaluar una expresión postfix
    public int evaluarPostfix(String expresionPostfix) {
        for (String token : expresionPostfix.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                stackEvaluacion.push(Integer.parseInt(token)); // Apila números
            } else if (esOperador(token.charAt(0))) {
                int operando2 = stackEvaluacion.pop();
                int operando1 = stackEvaluacion.pop();
                int resultado = aplicarOperacion(token.charAt(0), operando1, operando2);
                stackEvaluacion.push(resultado); // Apila el resultado
            }
        }
        return stackEvaluacion.pop(); // El resultado final está en la cima del stack
    }

    // Método para guardar los resultados en datosPostFix.txt
    public void guardarPostfix(String expresionPostfix) {
        try (FileWriter writer = new FileWriter("datosPostFix.txt")) {
            writer.write(expresionPostfix);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo datosPostFix.txt: " + e.getMessage());
        }
    }

    // Métodos auxiliares
    private boolean esOperador(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private int aplicarOperacion(char operador, int operando1, int operando2) {
        switch (operador) {
            case '+':
                return operando1 + operando2;
            case '-':
                return operando1 - operando2;
            case '*':
                return operando1 * operando2;
            case '/':
                return operando1 / operando2;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
}