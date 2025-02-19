/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 18/02/2025
 * última modificación: 18/02/2025
 * File Name: SinglyLinkedList.java
 * Descripción: Lista simple encadenada
 */
package com.ejemplo;

import java.util.Iterator;

/**
 * Una implementación de una lista simplemente encadenada que implementa la interfaz {@link List}.
 * Esta clase extiende {@link AbstractList} y proporciona métodos para manipular una lista encadenada.
 *
 * @param <E> el tipo de elementos almacenados en la lista.
 */
public class SinglyLinkedList<E> extends AbstractList<E> {
    protected int count; // Número de elementos en la lista
    protected Node<E> head; // Referencia al primer nodo de la lista

    /**
     * Construye una lista enlazada simple vacía.
     */
    public SinglyLinkedList() {
        head = null;
        count = 0;
    }

    /**
     * Devuelve el número de elementos en la lista.
     *
     * @return el número de elementos en la lista.
     */
    public int size() {
        return count;
    }

    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    public void clear() {
        head = null;
        count = 0;
    }

    /**
     * Añade un elemento al principio de la lista.
     *
     * @param value el elemento a añadir.
     */
    public void addFirst(E value) {
        head = new Node<>(value, head);
        count++;
    }

    /**
     * Añade un elemento al final de la lista.
     *
     * @param value el elemento a añadir.
     */
    public void addLast(E value) {
        Node<E> temp = new Node<>(value, null);
        if (head != null) {
            Node<E> finger = head;
            while (finger.next() != null) {
                finger = finger.next();
            }
            finger.setNext(temp);
        } else {
            head = temp;
        }
        count++;
    }

    /**
     * Devuelve el primer elemento de la lista.
     *
     * @return el primer elemento de la lista.
     * @throws IllegalStateException si la lista está vacía.
     */
    public E getFirst() {
        if (head == null) throw new IllegalStateException("La lista esta vacia");
        return head.value();
    }

    /**
     * Devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista.
     * @throws IllegalStateException si la lista está vacía.
     */
    public E getLast() {
        if (head == null) throw new IllegalStateException("La lista esta vacia");
        Node<E> finger = head;
        while (finger.next() != null) {
            finger = finger.next();
        }
        return finger.value();
    }

    /**
     * Elimina y devuelve el primer elemento de la lista.
     *
     * @return el primer elemento de la lista.
     * @throws IllegalStateException si la lista está vacía.
     */
    public E removeFirst() {
        if (head == null) throw new IllegalStateException("La lista esta vacia");
        Node<E> temp = head;
        head = head.next();
        count--;
        return temp.value();
    }

    /**
     * Elimina y devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista.
     * @throws IllegalStateException si la lista está vacía.
     */
    public E removeLast() {
        if (head == null) throw new IllegalStateException("La lista esta vacia");
        if (head.next() == null) {
            E value = head.value();
            head = null;
            count--;
            return value;
        }
        Node<E> finger = head;
        while (finger.next().next() != null) {
            finger = finger.next();
        }
        E value = finger.next().value();
        finger.setNext(null);
        count--;
        return value;
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado en la lista.
     *
     * @param value el elemento a eliminar.
     * @return el elemento eliminado, o {@code null} si no se encontró.
     */
    public E remove(E value) {
        if (head == null) return null;
        if (head.value().equals(value)) {
            return removeFirst();
        }
        Node<E> finger = head;
        while (finger.next() != null && !finger.next().value().equals(value)) {
            finger = finger.next();
        }
        if (finger.next() == null) return null;
        Node<E> temp = finger.next();
        finger.setNext(temp.next());
        count--;
        return temp.value();
    }

    /**
     * Verifica si la lista contiene el elemento especificado.
     *
     * @param value el elemento a buscar.
     * @return {@code true} si la lista contiene el elemento, {@code false} en caso contrario.
     */
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    /**
     * Devuelve el índice de la primera ocurrencia del elemento especificado en la lista.
     *
     * @param value el elemento a buscar.
     * @return el índice del elemento, o {@code -1} si no se encontró.
     */
    public int indexOf(E value) {
        Node<E> finger = head;
        int index = 0;
        while (finger != null) {
            if (finger.value().equals(value)) return index;
            finger = finger.next();
            index++;
        }
        return -1;
    }

    /**
     * Devuelve el índice de la última ocurrencia del elemento especificado en la lista.
     *
     * @param value el elemento a buscar.
     * @return el índice del elemento, o {@code -1} si no se encontró.
     */
    public int lastIndexOf(E value) {
        Node<E> finger = head;
        int index = 0, lastIndex = -1;
        while (finger != null) {
            if (finger.value().equals(value)) lastIndex = index;
            finger = finger.next();
            index++;
        }
        return lastIndex;
    }

    /**
     * Devuelve el elemento en la posición especificada en la lista.
     *
     * @param i el índice del elemento a devolver.
     * @return el elemento en la posición especificada.
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    public E get(int i) {
        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException();
        Node<E> finger = head;
        for (int j = 0; j < i; j++) {
            finger = finger.next();
        }
        return finger.value();
    }

    /**
     * Inserta el elemento especificado en la posición indicada en la lista.
     *
     * @param i el índice en el que se insertará el elemento.
     * @param o el elemento a insertar.
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    public void add(int i, E o) {
        if (i < 0 || i > size()) throw new IndexOutOfBoundsException();
        if (i == 0) {
            addFirst(o);
            return;
        }
        Node<E> finger = head;
        for (int j = 0; j < i - 1; j++) {
            finger = finger.next();
        }
        finger.setNext(new Node<>(o, finger.next()));
        count++;
    }

    /**
     * Elimina y devuelve el elemento en la posición especificada en la lista.
     *
     * @param i el índice del elemento a eliminar.
     * @return el elemento eliminado.
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    public E remove(int i) {
        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException();
        if (i == 0) return removeFirst();
        Node<E> finger = head;
        for (int j = 0; j < i - 1; j++) {
            finger = finger.next();
        }
        Node<E> temp = finger.next();
        finger.setNext(temp.next());
        count--;
        return temp.value();
    }

    /**
     * Añade un elemento al final de la lista.
     *
     * @param value el elemento a añadir.
     */
    public void add(E value) {
        addLast(value);
    }

    /**
     * Devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista.
     */
    public E get() {
        return getLast();
    }

    /**
     * Elimina y devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista.
     */
    public E remove() {
        return removeLast();
    }

    /**
     * Devuelve un iterador sobre los elementos de la lista.
     *
     * @return un iterador sobre los elementos de la lista.
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            /**
             * Verifica si hay más elementos en la lista.
             *
             * @return {@code true} si hay más elementos, {@code false} en caso contrario.
             */
            public boolean hasNext() {
                return current != null;
            }

            /**
             * Devuelve el siguiente elemento en la lista.
             *
             * @return el siguiente elemento en la lista.
             * @throws IllegalStateException si no hay más elementos.
             */
            public E next() {
                if (!hasNext()) throw new IllegalStateException("No hay mas elementos");
                E value = current.value();
                current = current.next();
                return value;
            }
        };
    }

    /**
     * Reemplaza el elemento en la posición especificada con el elemento dado.
     *
     * @param i el índice del elemento a reemplazar.
     * @param o el nuevo elemento.
     * @return el elemento anterior en la posición especificada.
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    public E set(int i, E o) {
        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException();
        Node<E> finger = head;
        for (int j = 0; j < i; j++) {
            finger = finger.next();
        }
        E oldValue = finger.value();
        finger.setValue(o);
        return oldValue;
    }
}