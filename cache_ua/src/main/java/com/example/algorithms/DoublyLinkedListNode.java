package com.example.algorithms;

import lombok.Getter;

/**
 * Object which is inserted in the {@link DoublyLinkedList}.
 * A single node is expeted to be created for each element.
 * 
 * @param <E> Type of element to be inserted into the list.
 * 
 */

@Getter
public class DoublyLinkedListNode<E> {
    E element;
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

}
