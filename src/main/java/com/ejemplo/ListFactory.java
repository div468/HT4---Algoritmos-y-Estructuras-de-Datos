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