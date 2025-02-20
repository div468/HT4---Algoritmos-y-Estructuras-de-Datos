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
 * 
 */

package test.java.com.ejemplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ejemplo.Calculadora;


public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = Calculadora.getInstancia("ArrayList"); // Suponiendo que "ArrayList" es una opción válida
    }

    @Test
    public void testSingleton() {
        Calculadora anotherInstance = Calculadora.getInstancia("ArrayList");
        assertSame(calculadora, anotherInstance);
    }

    @Test
    public void testInfixAPostfix() {
        String infix = "3 + 4 * 2 / ( 1 - 5 )";
        String expectedPostfix = "3 4 2 * 1 5 - / +";
        assertEquals(expectedPostfix, calculadora.infixAPostfix(infix));
    }

    @Test
    public void testEvaluarPostfix() {
        String postfix = "3 4 2 * 1 5 - / +";
        int expectedResult = 1;
        assertEquals(expectedResult, calculadora.evaluarPostfix(postfix));
    }

    @Test
    public void testInfixAPostfixAndEvaluarPostfix() {
        String infix = "10 + 2 * 6";
        String postfix = calculadora.infixAPostfix(infix);
        int result = calculadora.evaluarPostfix(postfix);
        assertEquals(22, result);
    }

    @Test
    public void testInfixAPostfixWithParentheses() {
        String infix = "( 10 + 2 ) * 6";
        String expectedPostfix = "10 2 + 6 *";
        assertEquals(expectedPostfix, calculadora.infixAPostfix(infix));
    }

    @Test
    public void testEvaluarPostfixWithParentheses() {
        String postfix = "10 2 + 6 *";
        int expectedResult = 72;
        assertEquals(expectedResult, calculadora.evaluarPostfix(postfix));
    }
}
