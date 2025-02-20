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
 * Pruebas unitarias para la clase StackList.
 */

package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.StackList;

class StackListTest {

    /**
     * Prueba el método push() de StackList.
     * Verifica que el tamaño del stack aumente y que el elemento se encuentre en la cima.
     */
    @Test
    void testPush() {
        StackList<Integer> stack = new StackList<>("Simple");
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    /**
     * Prueba el método pop() de StackList.
     * Verifica que el elemento correcto sea removido y que el stack esté vacío después de la operación.
     */
    @Test
    void testPop() {
        StackList<Integer> stack = new StackList<>("Simple");
        stack.push(1);
        int value = stack.pop();
        assertEquals(1, value);
        assertTrue(stack.isEmpty());
    }

    /**
     * Prueba el método peek() de StackList.
     * Verifica que el elemento en la cima del stack sea el esperado.
     */
    @Test
    void testPeek() {
        StackList<Integer> stack = new StackList<>("Simple");
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    /**
     * Prueba el método size() de StackList.
     * Verifica que el tamaño del stack sea el correcto después de varias operaciones push().
     */
    @Test
    void testSize() {
        StackList<Integer> stack = new StackList<>("Simple");
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    /**
     * Prueba el método isEmpty() de StackList.
     * Verifica que el stack esté vacío inicialmente y no esté vacío después de una operación push().
     */
    @Test
    void testIsEmpty() {
        StackList<Integer> stack = new StackList<>("Simple");
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
