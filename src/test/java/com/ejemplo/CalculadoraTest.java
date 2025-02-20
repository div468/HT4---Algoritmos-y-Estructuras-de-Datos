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

public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = Calculadora.getInstancia("ArrayList"); // Suponiendo que "ArrayList" es una opción válida
    }

    @Test
    public void testPushElemento() {
        calculadora.pushElemento(5);
        assertEquals(5, calculadora.popElemento());
    }

    @Test
    public void testPopElemento() {
        calculadora.pushElemento(10);
        int result = calculadora.popElemento();
        assertEquals(10, result);
    }

    @Test
    public void testSingleton() {
        Calculadora anotherInstance = Calculadora.getInstancia("ArrayList");
        assertSame(calculadora, anotherInstance);
    }
}
