/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 18/02/2025
 * última modificación: 18/02/2025
 * File Name: ListFactory.java
 * Descripción: Lista doblemente encadenada
 */

/**
 * Implementación de una lista doblemente enlazada en Java.
 * Este código fue generado por DeepSeek (https://www.deepseek.com) y adaptado para su uso en este proyecto.
 * Modificaciones realizadas por Julián Divas el 20/02/2025
 */

package com.ejemplo;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Una implementación de una lista doblemente enlazada que permite almacenar elementos de tipo genérico E.
 *
 * @param <E> el tipo de elementos almacenados en la lista
 */
public class DoublyLinkedList<E> extends AbstractList<E> {
    protected int count;
    protected DoublyLinkedNode<E> head;
    protected DoublyLinkedNode<E> tail;

    /**
     * Constructor que inicializa una lista doblemente enlazada vacía.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Devuelve el número de elementos en la lista.
     *
     * @return el número de elementos en la lista
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Elimina todos los elementos de la lista, dejándola vacía.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Agrega un elemento al principio de la lista.
     *
     * @param value el elemento a agregar
     */
    @Override
    public void addFirst(E value) {
        head = new DoublyLinkedNode<>(value, head, null);
        if (tail == null) tail = head;
        count++;
    }

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param value el elemento a agregar
     */
    @Override
    public void addLast(E value) {
        tail = new DoublyLinkedNode<>(value, null, tail);
        if (head == null) head = tail;
        count++;
    }

    /**
     * Devuelve el primer elemento de la lista.
     *
     * @return el primer elemento de la lista
     * @throws NoSuchElementException si la lista está vacía
     */
    @Override
    public E getFirst() {
        if (isEmpty()) throw new NoSuchElementException("La lista esta vacia");
        return head.data;
    }

    /**
     * Devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista
     * @throws NoSuchElementException si la lista está vacía
     */
    @Override
    public E getLast() {
        if (isEmpty()) throw new NoSuchElementException("La lista esta vacia");
        return tail.data;
    }

    /**
     * Elimina y devuelve el primer elemento de la lista.
     *
     * @return el primer elemento de la lista
     * @throws NoSuchElementException si la lista está vacía
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("La lista esta vacia");
        E value = head.data;
        head = head.nextElement;
        if (head == null) tail = null;
        else head.previousElement = null;
        count--;
        return value;
    }

    /**
     * Elimina y devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista
     * @throws NoSuchElementException si la lista está vacía
     */
    @Override
    public E removeLast() {
        if (isEmpty()) throw new NoSuchElementException("La lista esta vacia");
        E value = tail.data;
        tail = tail.previousElement;
        if (tail == null) head = null;
        else tail.nextElement = null;
        count--;
        return value;
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado en la lista.
     *
     * @param value el elemento a eliminar
     * @return el elemento eliminado, o null si no se encontró
     */
    @Override
    public E remove(E value) {
        DoublyLinkedNode<E> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                if (current.previousElement != null) {
                    current.previousElement.nextElement = current.nextElement;
                } else {
                    head = current.nextElement;
                }
                if (current.nextElement != null) {
                    current.nextElement.previousElement = current.previousElement;
                } else {
                    tail = current.previousElement;
                }
                count--;
                return current.data;
            }
            current = current.nextElement;
        }
        return null;
    }

    /**
     * Agrega un elemento al final de la lista.
     *
     * @param value el elemento a agregar
     */
    @Override
    public void add(E value) {
        addLast(value);
    }

    /**
     * Elimina y devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista
     */
    @Override
    public E remove() {
        return removeLast();
    }

    /**
     * Devuelve el último elemento de la lista.
     *
     * @return el último elemento de la lista
     */
    @Override
    public E get() {
        return getLast();
    }

    /**
     * Devuelve el índice de la primera ocurrencia del elemento especificado en la lista.
     *
     * @param value el elemento a buscar
     * @return el índice del elemento, o -1 si no se encontró
     */
    @Override
    public int indexOf(E value) {
        DoublyLinkedNode<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.nextElement;
            index++;
        }
        return -1;
    }

    /**
     * Devuelve el índice de la última ocurrencia del elemento especificado en la lista.
     *
     * @param value el elemento a buscar
     * @return el índice del elemento, o -1 si no se encontró
     */
    @Override
    public int lastIndexOf(E value) {
        DoublyLinkedNode<E> current = tail;
        int index = count - 1;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.previousElement;
            index--;
        }
        return -1;
    }

    /**
     * Devuelve el elemento en la posición especificada en la lista.
     *
     * @param i el índice del elemento a devolver
     * @return el elemento en la posición especificada
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista
     */
    @Override
    public E get(int i) {
        if (i < 0 || i >= count) throw new IndexOutOfBoundsException("No existe ese dato");
        DoublyLinkedNode<E> current = head;
        for (int j = 0; j < i; j++) {
            current = current.nextElement;
        }
        return current.data;
    }

    /**
     * Reemplaza el elemento en la posición especificada en la lista con el elemento dado.
     *
     * @param i el índice del elemento a reemplazar
     * @param o el elemento a almacenar en la posición especificada
     * @return el elemento previamente almacenado en la posición especificada
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista
     */
    @Override
    public E set(int i, E o) {
        if (i < 0 || i >= count) throw new IndexOutOfBoundsException("No existe ese dato");
        DoublyLinkedNode<E> current = head;
        for (int j = 0; j < i; j++) {
            current = current.nextElement;
        }
        E oldValue = current.data;
        current.data = o;
        return oldValue;
    }

    /**
     * Inserta el elemento especificado en la posición indicada en la lista.
     *
     * @param i el índice en el que se insertará el elemento
     * @param o el elemento a insertar
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista
     */
    @Override
    public void add(int i, E o) {
        if (i < 0 || i > count) throw new IndexOutOfBoundsException("No existe ese dato");
        if (i == 0) {
            addFirst(o);
        } else if (i == count) {
            addLast(o);
        } else {
            DoublyLinkedNode<E> current = head;
            for (int j = 0; j < i; j++) {
                current = current.nextElement;
            }
            new DoublyLinkedNode<>(o, current, current.previousElement);
            count++;
        }
    }

    /**
     * Elimina y devuelve el elemento en la posición especificada en la lista.
     *
     * @param i el índice del elemento a eliminar
     * @return el elemento eliminado
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista
     */
    @Override
    public E remove(int i) {
        if (i < 0 || i >= count) throw new IndexOutOfBoundsException("No existe ese dato");
        if (i == 0) {
            return removeFirst();
        } else if (i == count - 1) {
            return removeLast();
        } else {
            DoublyLinkedNode<E> current = head;
            for (int j = 0; j < i; j++) {
                current = current.nextElement;
            }
            current.previousElement.nextElement = current.nextElement;
            current.nextElement.previousElement = current.previousElement;
            count--;
            return current.data;
        }
    }

    /**
     * Devuelve un iterador sobre los elementos de la lista.
     *
     * @return un iterador sobre los elementos de la lista
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private DoublyLinkedNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E value = current.data;
                current = current.nextElement;
                return value;
            }
        };
    }
}