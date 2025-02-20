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
 * Pruebas unitarias para la clase StackArrayList.
 */

package test.java.com.ejemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.StackArrayList;

class StackArrayListTest {

    /**
     * Prueba el método push() de StackArrayList.
     * Verifica que el tamaño del stack aumente y que el elemento se encuentre en la cima.
     */
    @Test
    void testPush() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    /**
     * Prueba el método pop() de StackArrayList.
     * Verifica que el elemento correcto sea removido y que el stack esté vacío después de la operación.
     */
    @Test
    void testPop() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        int value = stack.pop();
        assertEquals(1, value);
        assertTrue(stack.isEmpty());
    }

    /**
     * Prueba el método peek() de StackArrayList.
     * Verifica que el elemento en la cima del stack sea el esperado.
     */
    @Test
    void testPeek() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    /**
     * Prueba el método size() de StackArrayList.
     * Verifica que el tamaño del stack sea el correcto después de varias operaciones push().
     */
    @Test
    void testSize() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    /**
     * Prueba el método isEmpty() de StackArrayList.
     * Verifica que el stack esté vacío inicialmente y no esté vacío después de una operación push().
     */
    @Test
    void testIsEmpty() {
        StackArrayList<Integer> stack = new StackArrayList<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
