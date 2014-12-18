package main.api.my.sort;


public interface Sorter<T extends Comparable<T>> {

    public Comparable<T>[] sort(Comparable<T>[] input);


}
