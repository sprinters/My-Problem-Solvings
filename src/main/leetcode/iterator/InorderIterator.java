package main.leetcode.iterator;

import java.util.Stack;

/**
 * * @author sandeepandey
 */
public class InorderIterator<K> extends BinaryTreeIterator<K> {

    private Stack<BinaryTreeIterator<K>> stack  =   null;

    public InorderIterator(BinaryTreeIterator<K> root) {

        stack   =   new Stack<BinaryTreeIterator<K>>();
        pushLeftMostNode(root);

    }

    private void pushLeftMostNode(BinaryTreeIterator<K> root) {
        BinaryTreeIterator<K> current   =   root;
        stack.push(current);

        while(current != null) {

        }

    }


    @Override
    public boolean isNextSafe() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void moveNext() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int valueAt() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
