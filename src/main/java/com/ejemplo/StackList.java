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
 * Implementación de un Stack (pila) utilizando una lista (List) como estructura subyacente.
 * Esta clase hereda de StackAbstract y puede usar cualquier implementación de List,
 * como SingleLinkedList o DoubleLinkedList, para manejar los elementos del stack.
 * Este código fue generado por DeepSeek (https://www.deepseek.com) y adaptado para su uso en este proyecto.
 * Modificaciones realizadas por Marcelo Detlefsen el 18/02/2025
 * 
 * @param <E> El tipo de elementos que contendrá el stack.
 */
public class StackList<E> extends StackAbstract<E> {

    private List<E> list; // Lista subyacente para almacenar los elementos del stack.

    /**
     * Constructor de la clase StackList.
     * Inicializa el stack con una implementación de List (por ejemplo, SingleLinkedList o DoubleLinkedList).
     * 
     * @param list Implementación de la interfaz List que se utilizará como estructura subyacente.
     */
    public StackList(String tipoLista) {
        this.list = ListFactory.getList(tipoLista);
    }

    /**
     * Agrega un elemento a la parte superior del stack.
     * 
     * @param item El elemento a agregar.
     * @post El elemento se coloca en la parte superior del stack.
     */
    @Override
    public void push(E item) {
        list.addFirst(item); // Agrega el elemento al inicio de la lista (parte superior del stack).
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
        return list.removeFirst(); // Elimina y devuelve el primer elemento de la lista.
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
        return list.getFirst(); // Devuelve el primer elemento de la lista sin eliminarlo.
    }

    /**
     * Devuelve el número de elementos en el stack.
     * 
     * @return El número de elementos en el stack.
     * @post Devuelve la cantidad de elementos en el stack.
     */
    @Override
    public int size() {
        return list.size(); // Devuelve el tamaño de la lista.
    }

    /**
     * Verifica si el stack está vacío.
     * 
     * @return true si el stack no contiene elementos, false en caso contrario.
     * @post Devuelve true si el stack está vacío, false si no lo está.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty(); // Verifica si la lista está vacía.
    }

    /**
     * Devuelve un iterador para recorrer los elementos del stack.
     * 
     * @return Un iterador que permite recorrer los elementos del stack en orden.
     * @post Devuelve un iterador para recorrer el stack.
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator(); // Devuelve el iterador de la lista.
    }
}