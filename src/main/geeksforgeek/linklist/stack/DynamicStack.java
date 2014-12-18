package main.geeksforgeek.linklist.stack;

import java.util.Iterator;
import java.util.ListIterator;

public class DynamicStack<Item> implements Iterable<Item> {

    private int N   ; // overall size of stack till now
    private Node<Item> top  =   null; // top element of stack at any moment of operation

    @Override
    public Iterator<Item> iterator() {
        return null;
    }


    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }


    public DynamicStack() {
        top   =   null;
        N     =   0;
    }

    public boolean isEmpty() {
        return N    ==  0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {

        Node<Item> oldTop =   top;
        top               =   new Node<Item>();
        top.item          =   item;
        top.next          =   oldTop;
        N++;
    }

    public Item pop() {
        if(isEmpty()) {
            throw new RuntimeException()  ;
        }
        Item savedItem  =   top.item;
        top             =   top.next;
        N--;
        return savedItem;

    }








}
