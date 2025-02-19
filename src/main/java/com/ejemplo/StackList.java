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
 * última modificación: 18/02/2025
 * File Name: StackList.java
 * Descripción: Implementación de un stack basado en una lista enlazada
 */
public class StackList<E> extends StackAbstract<E> 
{
    private StackListNode<E> head;
    private int size;

    public StackList() {
        head = null;
        size = 0;
    }

    @Override
    public void push(E item) {
        head = new StackListNode<>(item, head);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("El stack está vacío");
        E value = head.value();
        head = head.next();
        size--;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("El stack está vacío");
        return head.value();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private StackListNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

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