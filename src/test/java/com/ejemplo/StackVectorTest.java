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
 * Pruebas unitarias para la clase StackVector.
 */

package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para StackVector.
 */
class StackVectorTest {

    /**
     * Prueba el método push.
     */
    @Test
    void testPush() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    /**
     * Prueba el método pop.
     */
    @Test
    void testPop() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        int value = stack.pop();
        assertEquals(1, value);
        assertTrue(stack.isEmpty());
    }

    /**
     * Prueba el método peek.
     */
    @Test
    void testPeek() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    /**
     * Prueba el método size.
     */
    @Test
    void testSize() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    /**
     * Prueba el método isEmpty.
     */
    @Test
    void testIsEmpty() {
        StackVector<Integer> stack = new StackVector<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
