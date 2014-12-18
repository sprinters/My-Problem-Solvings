package main.api.my.utils.mis.filter;

public interface Filter<T> {
    public boolean accept(T sample);
}
