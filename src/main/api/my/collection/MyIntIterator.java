package main.api.my.collection;

public interface MyIntIterator {

    public boolean isNextSafe();
    public void moveNext();
    public int getValue();

}
