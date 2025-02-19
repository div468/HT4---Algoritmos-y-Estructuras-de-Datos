/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de datos
 * Ing. Douglas Barrios
 * Colaboradores: 
 * Marcelo Detlefsen - 24554
 * Julián Divas - 24687
 * Alejandro Jeréz - 24678
 * Fecha: 18/02/2025
 * Descripción: Clase abstracta de los Stack.
 */

package com.ejemplo;
public abstract class StackAbstract<E> implements Stack<E> 
{
    public StackAbstract()
    // post: does nothing
    {
        
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}