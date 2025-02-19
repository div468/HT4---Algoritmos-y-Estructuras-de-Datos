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
 * última modificación: 18/02/2025
 * File Name: StackArrayList.java
 * Descripción: Implementación de una pila basada en ArrayList
 */
public class StackArrayList<E> extends StackAbstract<E> {
    private ArrayList<E> stack;
    
    public StackArrayList() {
        stack = new ArrayList<>();
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
        return stack.get(stack.size() - 1);
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