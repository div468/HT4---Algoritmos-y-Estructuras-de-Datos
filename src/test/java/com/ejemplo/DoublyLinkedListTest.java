/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de datos
 * Ing. Douglas Barrios
 * Colaboradores: 
 * Marcelo Detlefsen - 24554
 * Julián Divas - 24687
 * Alejandro Jeréz - 24678
 * Fecha: 18/02/2025
 * 
 * Descripción: 
 * Pruebas unitarias para la clase DoublyLinkedList.
 */

package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.DoublyLinkedList;


class DoublyLinkedListTest {

    /**
     * Prueba el método addFirst() de DoublyLinkedList.
     * Verifica que el primer elemento de la lista sea el esperado después de la operación.
     */
    @Test
    void testAddFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        assertEquals(1, list.getFirst());
    }

    /**
     * Prueba el método addLast() de DoublyLinkedList.
     * Verifica que el último elemento de la lista sea el esperado después de la operación.
     */
    @Test
    void testAddLast() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        assertEquals(1, list.getLast());
    }

    /**
     * Prueba el método removeFirst() de DoublyLinkedList.
     * Verifica que el primer elemento sea removido correctamente y que la lista esté vacía después de la operación.
     */
    @Test
    void testRemoveFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        int value = list.removeFirst();
        assertEquals(1, value);
        assertTrue(list.isEmpty());
    }

    /**
     * Prueba el método removeLast() de DoublyLinkedList.
     * Verifica que el último elemento sea removido correctamente y que la lista esté vacía después de la operación.
     */
    @Test
    void testRemoveLast() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        int value = list.removeLast();
        assertEquals(1, value);
        assertTrue(list.isEmpty());
    }

    /**
     * Prueba el método size() de DoublyLinkedList.
     * Verifica que el tamaño de la lista sea el correcto después de varias operaciones de adición.
     */
    @Test
    void testSize() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        assertEquals(2, list.size());
    }

    /**
     * Prueba el método isEmpty() de DoublyLinkedList.
     * Verifica que la lista esté vacía inicialmente y no esté vacía después de una operación de adición.
     */
    @Test
    void testIsEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }
}
