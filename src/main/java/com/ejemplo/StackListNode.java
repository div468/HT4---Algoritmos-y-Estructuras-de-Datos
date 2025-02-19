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
 * File Name: StackListNode.java
 * Descripción: Nodo del stack basado en listas enlazadas
 */

package com.ejemplo;

public class StackListNode<E> 
{
    protected E data;
    protected StackListNode<E> nextElement;

    public StackListNode(E value, StackListNode<E> next) {
        data = value;
        nextElement = next;
    }

    public StackListNode(E value) {
        this(value, null);
    }

    public StackListNode<E> next() {
        return nextElement;
    }

    public void setNext(StackListNode<E> next) {
        nextElement = next;
    }

    public E value() {
        return data;
    }

    public void setValue(E value) {
        data = value;
    }
}
