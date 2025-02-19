/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 18/02/2025
 * última modificación: 18/02/2025
 * File Name: StackNode.java
 * Descripción: Nodo del stack basado en Vector
 */

package com.ejemplo;

/**
 * Clase que define un nodo para la implementación de un stack basado en Vector
 * @param <E> Tipo de dato que se almacenará en el nodo
 */

public class StackVectorNode<E> {
    protected E data; // Valor almacenado en el nodo
    protected StackVectorNode<E> nextElement; // Referencia al siguiente nodo

    public StackVectorNode(E value, StackVectorNode<E> next) {
        data = value;
        nextElement = next;
    }

    public StackVectorNode(E value) {
        this(value, null);
    }

    public StackVectorNode<E> next() {
        return nextElement;
    }

    public void setNext(StackVectorNode<E> next) {
        nextElement = next;
    }

    public E value() {
        return data;
    }

    public void setValue(E value) {
        data = value;
    }
}
