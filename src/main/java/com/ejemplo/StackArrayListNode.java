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
 * Nombre del archivo: StackArrayListNode.java
 * 
 * Descripción: 
 * Clase que define un nodo para la implementación de un stack basado en ArrayList.
 * Cada nodo almacena un valor y una referencia al siguiente nodo en la estructura.
 * 
 * @param <E> Tipo de dato que se almacenará en el nodo.
 */
package com.ejemplo;

public class StackArrayListNode<E> {

    protected E data; // Valor almacenado en el nodo.
    protected StackArrayListNode<E> nextElement; // Referencia al siguiente nodo en la estructura.

    /**
     * Constructor que inicializa un nodo con un valor y una referencia al siguiente nodo.
     * 
     * @param value El valor que se almacenará en el nodo.
     * @param next Referencia al siguiente nodo en la estructura.
     */
    public StackArrayListNode(E value, StackArrayListNode<E> next) {
        data = value;
        nextElement = next;
    }

    /**
     * Constructor que inicializa un nodo con un valor y sin referencia al siguiente nodo.
     * 
     * @param value El valor que se almacenará en el nodo.
     */
    public StackArrayListNode(E value) {
        this(value, null);
    }

    /**
     * Devuelve la referencia al siguiente nodo en la estructura.
     * 
     * @return Referencia al siguiente nodo.
     */
    public StackArrayListNode<E> next() {
        return nextElement;
    }

    /**
     * Establece la referencia al siguiente nodo en la estructura.
     * 
     * @param next Referencia al siguiente nodo.
     */
    public void setNext(StackArrayListNode<E> next) {
        nextElement = next;
    }

    /**
     * Devuelve el valor almacenado en el nodo.
     * 
     * @return El valor almacenado en el nodo.
     */
    public E value() {
        return data;
    }

    /**
     * Establece el valor que se almacenará en el nodo.
     * 
     * @param value El valor a almacenar en el nodo.
     */
    public void setValue(E value) {
        data = value;
    }
}