/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de datos
 * Ing. Douglas Barrios
 * Colaboradores: 
 * Marcelo Detlefsen - 24554
 * Julián Divas - 24687
 * Alejandro Jeréz - 24678
 * Fecha: 18/02/2025
 * 
 * Descripción: 
 * Interfaz que define los métodos básicos para manejar una pila (Stack).
 * Incluye operaciones como push, pop, peek, isEmpty, size y un iterador para recorrer los elementos.
 * 
 * @param <E> El tipo de elementos que contendrá la pila.
 */
package com.ejemplo;
import java.util.Iterator;

public interface Stack<E> {

    /**
     * Agrega un elemento a la parte superior de la pila.
     * 
     * @param item El elemento a agregar.
     * @post El elemento se coloca en la parte superior de la pila.
     */
    public void push(E item);

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     * 
     * @return El elemento eliminado de la parte superior de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     * @pre La pila no debe estar vacía.
     * @post El elemento superior es eliminado y devuelto.
     */
    public E pop();

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     * 
     * @return El elemento en la parte superior de la pila.
     * @throws IllegalStateException Si la pila está vacía.
     * @pre La pila no debe estar vacía.
     * @post El elemento superior es devuelto sin ser eliminado.
     */
    public E peek();

    /**
     * Verifica si la pila está vacía.
     * 
     * @return true si la pila no contiene elementos, false en caso contrario.
     * @post Devuelve true si la pila está vacía, false si no lo está.
     */
    public boolean isEmpty();

    /**
     * Devuelve el número de elementos en la pila.
     * 
     * @return El número de elementos en la pila.
     * @post Devuelve la cantidad de elementos en la pila.
     */
    public int size();

    /**
     * Devuelve un iterador para recorrer los elementos de la pila.
     * 
     * @return Un iterador que permite recorrer los elementos de la pila en orden.
     * @post Devuelve un iterador para recorrer la pila.
     */
    public Iterator<E> iterator();
}