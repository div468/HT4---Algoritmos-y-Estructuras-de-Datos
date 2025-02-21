package com.ejemplo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * Colaboradores: 
 * Marcelo Detlefsen - 24554
 * Julián Divas - 24687
 * Alejandro Jeréz - 24678
 * Creación: 18/02/2025
 * Última modificación: 18/02/2025
 * Nombre del archivo: StackArrayList.java
 * 
 * Descripción: 
 * Implementación de un Stack (pila) utilizando la clase ArrayList de Java.
 * Esta clase hereda de StackAbstract y proporciona métodos para manipular
 * una pila, como push, pop, peek, size e iterator.
 * Este código fue generado por DeepSeek (https://www.deepseek.com) y adaptado para su uso en este proyecto.
 * Modificaciones realizadas por Marcelo Detlefsen el 18/02/2025
 * 
 * @param <E> El tipo de elementos que contendrá el stack.
 */
public class StackArrayList<E> extends StackAbstract<E> {

    private ArrayList<E> stack; // ArrayList que almacena los elementos del stack.

    /**
     * Constructor de la clase StackArrayList.
     * Inicializa un ArrayList vacío para almacenar los elementos del stack.
     */
    public StackArrayList() {
        stack = new ArrayList<>();
    }

    /**
     * Agrega un elemento a la parte superior del stack.
     * 
     * @param item El elemento a agregar.
     * @post El elemento se coloca en la parte superior del stack.
     */
    @Override
    public void push(E item) {
        stack.add(item);
    }

    /**
     * Elimina y devuelve el elemento en la parte superior del stack.
     * 
     * @return El elemento eliminado de la parte superior del stack.
     * @throws IllegalStateException Si el stack está vacío.
     * @pre El stack no debe estar vacío.
     * @post El elemento superior es eliminado y devuelto.
     */
    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("El stack está vacío");
        return stack.remove(stack.size() - 1);
    }

    /**
     * Devuelve el elemento en la parte superior del stack sin eliminarlo.
     * 
     * @return El elemento en la parte superior del stack.
     * @throws IllegalStateException Si el stack está vacío.
     * @pre El stack no debe estar vacío.
     * @post El elemento superior es devuelto sin ser eliminado.
     */
    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("El stack está vacío");
        return stack.get(stack.size() - 1);
    }

    /**
     * Devuelve el número de elementos en el stack.
     * 
     * @return El número de elementos en el stack.
     * @post Devuelve la cantidad de elementos en el stack.
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * Devuelve un iterador para recorrer los elementos del stack.
     * 
     * @return Un iterador que permite recorrer los elementos del stack en orden.
     * @post Devuelve un iterador para recorrer el stack.
     */
    @Override
    public Iterator<E> iterator() {
        return stack.iterator();
    }
}