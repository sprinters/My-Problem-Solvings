package main.leetcode.iterator;

/**
 * * @author sandeepandey
 */
public interface Interator<K> {

    public boolean isNextSafe();

    public void moveNext();

    public int valueAt();

}
