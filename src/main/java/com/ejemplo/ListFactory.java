/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 18/02/2025
 * última modificación: 18/02/2025
 * File Name: ListFactory.java
 * Descripción: Factory para la elección de la lista a instanciar en base a la elección del usuario
 */

package com.ejemplo;

public class ListFactory<E> {
    public List<E> geList(String listasolicitada){
        if(listasolicitada.equals("Simple")){
            return new SinglyLinkedList<E>();
        }
        else if (listasolicitada.equals("Doble")){
            return new DoublyLinkedList<E>();
        }
        else {
            throw new IllegalArgumentException("Este tipo de lista no existe: " + listasolicitada);
        }
    }
}