/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de datos
 * Ing. Douglas Barrios
 * Colaboradores: 
 * Marcelo Detlefsen - 24554
 * Julián Divas - 24687
 * Alejandro Jeréz - 24678
 * Fecha: 19/02/2025
 * 
 * Descripción: 
 * Pruebas unitarias para la clase SinglyLinkedList.
 */

package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para SinglyLinkedList.
 */
class SinglyLinkedListTest {

    /**
     * Prueba el método addFirst.
     */
    @Test
    void testAddFirst() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        assertEquals(1, list.getFirst());
    }

    /**
     * Prueba el método addLast.
     */
    @Test
    void testAddLast() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        assertEquals(1, list.getLast());
    }

    /**
     * Prueba el método removeFirst.
     */
    @Test
    void testRemoveFirst() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        int value = list.removeFirst();
        assertEquals(1, value);
        assertTrue(list.isEmpty());
    }

    /**
     * Prueba el método removeLast.
     */
    @Test
    void testRemoveLast() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        int value = list.removeLast();
        assertEquals(1, value);
        assertTrue(list.isEmpty());
    }

    /**
     * Prueba el método size.
     */
    @Test
    void testSize() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        assertEquals(2, list.size());
    }

    /**
     * Prueba el método isEmpty.
     */
    @Test
    void testIsEmpty() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        assertTrue(list.isEmpty());
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }
}
