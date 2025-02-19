/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de datos
 * Ing. Douglas Barrios
 * Colaboradores: 
 * Marcelo Detlefsen - 24554
 * Julián Divas - 24687
 * Alejandro Jeréz - 24678
 * Fecha: 18/02/2025
 * Descripción: Interfaz que define métodos para manejar un sistema que incluye push, pop, peek, empty y size.
 */

package com.ejemplo;
import java.util.Iterator;

public interface Stack<E> 
{
    public void push(E item);
    // pre: 
    // post: item is added to stack
    // will be popped next if no intervening push
    
    public E pop();
    // pre: stack is not empty
    // post: most recently pushed item is removed and returned
    
    public E peek();
    // pre: stack is not empty
    // post: top value (next to be popped) is returned
    
    public boolean isEmpty();
    // post: returns true if and only if the stack is empty
    
    public int size();
    // post: returns the number of elements in the stack

    public Iterator<E> iterator();
    // post: returns an iterator allowing
    // ordered traversal of elements in list
}