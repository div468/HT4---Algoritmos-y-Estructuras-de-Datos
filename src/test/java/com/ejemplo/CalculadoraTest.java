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
 * Pruebas unitarias para la clase Calculadora.
 */

package test.java.com.ejemplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para Calculadora.
 */
public class CalculadoraTest {
    private Calculadora calculadora;

    /**
     * Configura la instancia de Calculadora antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        calculadora = Calculadora.getInstancia("ArrayList"); // Suponiendo que "ArrayList" es una opción válida
    }

    /**
     * Prueba el método pushElemento.
     */
    @Test
    public void testPushElemento() {
        calculadora.pushElemento(5);
        assertEquals(5, calculadora.popElemento());
    }

    /**
     * Prueba el método popElemento.
     */
    @Test
    public void testPopElemento() {
        calculadora.pushElemento(10);
        int result = calculadora.popElemento();
        assertEquals(10, result);
    }

    /**
     * Prueba el patrón Singleton de la clase Calculadora.
     */
    @Test
    public void testSingleton() {
        Calculadora anotherInstance = Calculadora.getInstancia("ArrayList");
        assertSame(calculadora, anotherInstance);
    }
}
