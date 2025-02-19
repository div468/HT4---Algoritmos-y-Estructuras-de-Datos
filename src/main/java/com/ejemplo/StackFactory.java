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
public class StackFactory<E> {
    public Stack<E> getStack(String stackSolicitado){
        if(stackSolicitado.equals("Vector")){
            return new StackVector<E>();
        }
        else if (stackSolicitado.equals("ArrayList")){
            return new StackArrayList<E>();
        }
        else if (stackSolicitado.equals("List")){
            return new StackList<E>();
        }
        else {
            throw new IllegalArgumentException("Este tipo de stack no existe: " + stackSolicitado);
        }
    }
}
