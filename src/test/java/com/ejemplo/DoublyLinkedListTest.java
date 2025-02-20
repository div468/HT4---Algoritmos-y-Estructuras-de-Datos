package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.DoublyLinkedList;


class DoublyLinkedListTest {

    @Test
    void testAddFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        assertEquals(1, list.getFirst());
    }

    @Test
    void testAddLast() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        assertEquals(1, list.getLast());
    }

    @Test
    void testRemoveFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        int value = list.removeFirst();
        assertEquals(1, value);
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveLast() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        int value = list.removeLast();
        assertEquals(1, value);
        assertTrue(list.isEmpty());
    }

    @Test
    void testSize() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        assertEquals(2, list.size());
    }

    @Test
    void testIsEmpty() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }
}
