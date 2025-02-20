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
 * Pruebas unitarias para la clase StackVector.
 */

package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.StackVector;

class StackVectorTest {

    /**
     * Prueba el método push() de StackVector.
     * Verifica que el tamaño del stack aumente y que el elemento se encuentre en la cima.
     */
    @Test
    void testPush() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    /**
     * Prueba el método pop() de StackVector.
     * Verifica que el elemento correcto sea removido y que el stack esté vacío después de la operación.
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
     * Prueba el método peek() de StackVector.
     * Verifica que el elemento en la cima del stack sea el esperado.
     */
    @Test
    void testPeek() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    /**
     * Prueba el método size() de StackVector.
     * Verifica que el tamaño del stack sea el correcto después de varias operaciones push().
     */
    @Test
    void testSize() {
        StackVector<Integer> stack = new StackVector<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    /**
     * Prueba el método isEmpty() de StackVector.
     * Verifica que el stack esté vacío inicialmente y no esté vacío después de una operación push().
     */
    @Test
    void testIsEmpty() {
        StackVector<Integer> stack = new StackVector<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
