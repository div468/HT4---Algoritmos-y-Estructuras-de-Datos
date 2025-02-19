package com.ejemplo;

import java.util.Iterator;
import java.util.Vector;

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
 * File Name: StackVector.java
 * Descripción: Implementación de un Stack basado en Vector
 */
public class StackVector<E> extends StackAbstract<E> 
{
    private Vector<E> stack;
    
    public StackVector() {
        stack = new Vector<>();
    }
    
    @Override
    public void push(E item) {
        stack.add(item);
    }
    
    @Override
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("El stack está vacío");
        return stack.remove(stack.size() - 1);
    }
    
    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("El stack está vacío");
        return stack.lastElement();
    }
    
    @Override
    public int size() {
        return stack.size();
    }
    
    @Override
    public Iterator<E> iterator() {
        return stack.iterator();
    }
}