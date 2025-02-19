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
package com.ejemplo;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> extends AbstractList<E> {
    protected int count;
    protected DoublyLinkedNode<E> head;
    protected DoublyLinkedNode<E> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void addFirst(E value) {
        head = new DoublyLinkedNode<>(value, head, null);
        if (tail == null) tail = head;
        count++;
    }

    @Override
    public void addLast(E value) {
        tail = new DoublyLinkedNode<>(value, null, tail);
        if (head == null) head = tail;
        count++;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) throw new NoSuchElementException("La lista esta vacia");
        return head.data;
    }

    @Override
    public E getLast() {
        if (isEmpty()) throw new NoSuchElementException("La lista esta vacia");
        return tail.data;
    }

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

    @Override
    public void add(E value) {
        addLast(value);
    }

    @Override
    public E remove() {
        return removeLast();
    }

    @Override
    public E get() {
        return getLast();
    }

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

    @Override
    public E get(int i) {
        if (i < 0 || i >= count) throw new IndexOutOfBoundsException("No existe ese dato");
        DoublyLinkedNode<E> current = head;
        for (int j = 0; j < i; j++) {
            current = current.nextElement;
        }
        return current.data;
    }

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