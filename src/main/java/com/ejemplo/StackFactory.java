/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de datos
 * Ing. Douglas Barrios
 * Colaboradores: 
 * Marcelo Detlefsen - 24554
 * Julián Divas - 24687
 * Alejandro Jeréz - 24678
 * Fecha: 18/02/2025
 * Descripción: Factory para decidir cual es el Stack a instanciar en base a la elección del usuario.
 */

package com.ejemplo;
/*
* Utilización del patrón de diseño Factory para la elección del tipo de stack a usarse dentro del programa.
* @param <E> el tipo de elementos almacenados en el stack
*/
public class StackFactory {
    public static <E> Stack<E> getStack(String stackSolicitado) {
        if (stackSolicitado.equalsIgnoreCase("Vector")) {
            return new StackVector<>();
        } else if (stackSolicitado.equalsIgnoreCase("ArrayList")) {
            return new StackArrayList<>();
        } else if (stackSolicitado.equalsIgnoreCase("Simple") || stackSolicitado.equalsIgnoreCase("Doble")) {
            // Si el usuario elige una lista, se obtiene desde ListFactory
            return new StackList<>(stackSolicitado);
        } else {
            throw new IllegalArgumentException("Este tipo de stack no existe: " + stackSolicitado);
        }
    }
}
