
/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 18/02/2025
 * última modificación: 18/02/2025
 * File Name: DoublyLinkedNode.java
 * Descripción: Nodo de la lista doblemente encadenada
 */
package com.ejemplo;
/**
 * Clase que representa un nodo de una lista doblemente enlazada.
 * @param <E> el tipo de dato a almacenarse en el nodo.
 */
public class DoublyLinkedNode<E> {
    
    /** Dato almacenado en el nodo. */
    protected E data;
    
    /** Referencia al siguiente nodo en la lista. */
    protected DoublyLinkedNode<E> nextElement;
    
    /** Referencia al nodo anterior en la lista. */
    protected DoublyLinkedNode<E> previousElement;

    /**
     * Construye un nodo con un valor y referencias a los nodos adyacentes.
     *
     * @param v Valor almacenado en el nodo.
     * @param next Referencia al siguiente nodo en la lista.
     * @param previous Referencia al nodo anterior en la lista.
     */
    public DoublyLinkedNode(E v, DoublyLinkedNode<E> next, DoublyLinkedNode<E> previous) {
        data = v;
        nextElement = next;
        if (nextElement != null) {
            nextElement.previousElement = this;
        }
        previousElement = previous;
        if (previousElement != null) {
            previousElement.nextElement = this;
        }
    }

    /**
     * Construye un nodo con un valor sin referencias a otros nodos.
     *
     * @param v Valor almacenado en el nodo.
     */
    public DoublyLinkedNode(E v) {
        this(v, null, null);
    }
}
