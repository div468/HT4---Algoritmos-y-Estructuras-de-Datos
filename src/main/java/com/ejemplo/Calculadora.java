package com.ejemplo;

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
    private Stack<Integer> stack; // Usa la interfaz en lugar de Stack directamente
    private static Calculadora instancia;

    // Constructor privado (corregido)
    private Calculadora(String eleccion) {
        this.stack = StackFactory.getStack(eleccion); // Ahora sí se puede llamar correctamente
    }

    // Método para obtener la instancia de la Calculadora
    public static Calculadora getInstancia(String eleccion) {
        if (instancia == null) {
            instancia = new Calculadora(eleccion);
        }
        return instancia;
    }

    // Métodos para operar con el stack
    public void pushElemento(int valor) {
        stack.push(valor);
    }

    public int popElemento() {
        return stack.pop();
    }
}


