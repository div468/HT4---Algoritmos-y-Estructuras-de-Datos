/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * Colaboradores: 
 * Marcelo Detlefsen - 24554
 * Julián Divas - 24687
 * Alejandro Jeréz - 24678
 * Creación: 18/02/2025
 * última modificación: 18/02/2025
 * File Name: StackArrayNode.java
 * Descripción: Nodo de la pila basada en ArrayList
 */
package com.ejemplo;

public class StackArrayListNode<E> {
    protected E data; // Valor almacenado en el nodo
    protected StackArrayListNode<E> nextElement; // Referencia al siguiente nodo

    public StackArrayListNode(E value, StackArrayListNode<E> next) {
        data = value;
        nextElement = next;
    }

    public StackArrayListNode(E value) {
        this(value, null);
    }

    public StackArrayListNode<E> next() {
        return nextElement;
    }

    public void setNext(StackArrayListNode<E> next) {
        nextElement = next;
    }

    public E value() {
        return data;
    }

    public void setValue(E value) {
        data = value;
    }
}