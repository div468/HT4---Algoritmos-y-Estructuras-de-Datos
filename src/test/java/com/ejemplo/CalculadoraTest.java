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
 * Pruebas unitarias para la clase Calculadora.
 */

package test.java.com.ejemplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.Calculadora;


public class CalculadoraTest {
    private Calculadora calculadora;

    /**
     * Configura la instancia de la calculadora antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        calculadora = Calculadora.getInstancia("ArrayList"); // Suponiendo que "ArrayList" es una opción válida
    }

    /**
     * Prueba el patrón Singleton de la clase Calculadora.
     * Verifica que dos instancias obtenidas sean la misma.
     */
    @Test
    public void testSingleton() {
        Calculadora anotherInstance = Calculadora.getInstancia("ArrayList");
        assertSame(calculadora, anotherInstance);
    }

    /**
     * Prueba el método infixAPostfix() de Calculadora.
     * Verifica que la conversión de una expresión infix a postfix sea correcta.
     */
    @Test
    public void testInfixAPostfix() {
        String infix = "3 + 4 * 2 / ( 1 - 5 )";
        String expectedPostfix = "3 4 2 * 1 5 - / +";
        assertEquals(expectedPostfix, calculadora.infixAPostfix(infix));
    }

    /**
     * Prueba el método evaluarPostfix() de Calculadora.
     * Verifica que la evaluación de una expresión postfix sea correcta.
     */
    @Test
    public void testEvaluarPostfix() {
        String postfix = "3 4 2 * 1 5 - / +";
        int expectedResult = 1;
        assertEquals(expectedResult, calculadora.evaluarPostfix(postfix));
    }

    /**
     * Prueba la conversión de infix a postfix y la evaluación de la expresión postfix.
     * Verifica que el resultado final sea correcto.
     */
    @Test
    public void testInfixAPostfixAndEvaluarPostfix() {
        String infix = "10 + 2 * 6";
        String postfix = calculadora.infixAPostfix(infix);
        int result = calculadora.evaluarPostfix(postfix);
        assertEquals(22, result);
    }

    /**
     * Prueba el método infixAPostfix() con paréntesis en la expresión.
     * Verifica que la conversión de una expresión infix a postfix sea correcta.
     */
    @Test
    public void testInfixAPostfixWithParentheses() {
        String infix = "( 10 + 2 ) * 6";
        String expectedPostfix = "10 2 + 6 *";
        assertEquals(expectedPostfix, calculadora.infixAPostfix(infix));
    }

    /**
     * Prueba el método evaluarPostfix() con una expresión que contiene paréntesis.
     * Verifica que la evaluación de una expresión postfix sea correcta.
     */
    @Test
    public void testEvaluarPostfixWithParentheses() {
        String postfix = "10 2 + 6 *";
        int expectedResult = 72;
        assertEquals(expectedResult, calculadora.evaluarPostfix(postfix));
    }
}
