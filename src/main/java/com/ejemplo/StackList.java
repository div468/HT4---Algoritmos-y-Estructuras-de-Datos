package com.ejemplo;

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
 * Nombre del archivo: StackList.java
 * 
 * Descripción: 
 * Implementación de un Stack (pila) utilizando una lista enlazada.
 * Esta clase hereda de StackAbstract y proporciona métodos para manipular
 * una pila, como push, pop, peek, size e iterator.
 * 
 * @param <E> El tipo de elementos que contendrá el stack.
 */
public class StackList<E> extends StackAbstract<E> {

    private StackListNode<E> head; // Referencia al primer nodo de la lista enlazada.
    private int size; // Tamaño actual del stack.

    /**
     * Constructor de la clase StackList.
     * Inicializa un stack vacío con head nulo y tamaño 0.
     */
    public StackList() {
        head = null;
        size = 0;
    }

    /**
     * Agrega un elemento a la parte superior del stack.
     * 
     * @param item El elemento a agregar.
     * @post El elemento se coloca en la parte superior del stack.
     */
    @Override
    public void push(E item) {
        head = new StackListNode<>(item, head);
        size++;
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
        E value = head.value();
        head = head.next();
        size--;
        return value;
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
        return head.value();
    }

    /**
     * Devuelve el número de elementos en el stack.
     * 
     * @return El número de elementos en el stack.
     * @post Devuelve la cantidad de elementos en el stack.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Devuelve un iterador para recorrer los elementos del stack.
     * 
     * @return Un iterador que permite recorrer los elementos del stack en orden.
     * @post Devuelve un iterador para recorrer el stack.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private StackListNode<E> current = head; // Referencia al nodo actual durante la iteración.

            /**
             * Verifica si hay más elementos en el stack para iterar.
             * 
             * @return true si hay más elementos, false en caso contrario.
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }

            /**
             * Devuelve el siguiente elemento en el stack y avanza el iterador.
             * 
             * @return El siguiente elemento en el stack.
             * @throws IllegalStateException Si no hay más elementos para iterar.
             */
            @Override
            public E next() {
                if (!hasNext()) throw new IllegalStateException("No hay más elementos");
                E value = current.value();
                current = current.next();
                return value;
            }
        };
    }
}