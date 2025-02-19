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
 * Clase abstracta que define la estructura básica de una pila (Stack).
 * Implementa la interfaz Stack y proporciona una implementación predeterminada
 * para el método isEmpty().
 * 
 * @param <E> El tipo de elementos que contendrá la pila.
 */
package com.ejemplo;

public abstract class StackAbstract<E> implements Stack<E> 
{
    /**
     * Constructor por defecto de la clase StackAbstract.
     * No realiza ninguna acción específica.
     * 
     * @post No se realizan operaciones adicionales.
     */
    public StackAbstract()
    {
        // No se requiere inicialización adicional.
    }

    /**
     * Verifica si la pila está vacía.
     * 
     * @return true si la pila no contiene elementos, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}