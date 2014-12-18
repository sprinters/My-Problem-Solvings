package main.leetcode.node;

/**
 * * @author sandeepandey
 */
public class Node<K> {

    private K value;
    private Node<K> left;
    private Node<K> right;

    public Node(K val) {
        this.value  =   val;
        this.left   =   null;
        this.right  =   null;
    }
}
