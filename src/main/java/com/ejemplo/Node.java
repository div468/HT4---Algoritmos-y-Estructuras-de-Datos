/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * @author: Julián Divas
 * Creación: 18/02/2025
 * última modificación: 18/02/2025
 * File Name: Node.java
 * Descripción: Nodo de la lista encadenada simple
 */
package com.ejemplo;
/**
 * Una implementación necesaria para una lista simplemente encadenada.
 * @param <E> el tipo de elementos almacenados en la lista.
 */
public class Node<E>
{
   protected E data; // Valor guardado en el elemento
   protected Node<E> nextElement; // Referencia al siguiente elemento

   /**
    * @param v El valor a guardar en la lista
    * @param next La feretencia al siguiente elemento en la lista
    */
   public Node(E v, Node<E> next)
   {
      //Se constrye un nuevo nodo en la lista
       data = v;
       nextElement = next;
   }

   /**
    * @param v el valor a añadir en el nodo de la lista
    */
   public Node(E v)
   {
      //Se construye el nodo de la cola de la lista
      this(v,null);
   }

   /**
   * @return la referencia al siguiente elemento de la lista
   */
   public Node<E> next()
   {
      return nextElement;
   }

   /**
    * @param next la referencia nueva al siguiente nuevo valor
    */
   public void setNext(Node<E> next)
   {
      //Asigna la referencia al siguiente valor
      nextElement = next;
   }

   /**
    * @return el valor asociado al nodo
    */
   public E value()
   {
      //Devuelve el valor correspondiente
      return data;
   }

   /**
    * @param value el valor a asociar al nodo
    */
   public void setValue(E value)
   {
      //Se asigna el valor al nodo
      data = value;
   }
}