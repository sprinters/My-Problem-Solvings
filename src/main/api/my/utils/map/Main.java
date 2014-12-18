package main.api.my.utils.map;

public class Main {


    public static void main(String...s) {
        Counter<String> myCounter   =   new Counter<String>();

        myCounter.add("sandeep");
        myCounter.add("sandeep");
        myCounter.add("abc");
        myCounter.add("xyz");

        System.out.println("sandeep has count::"+myCounter.get("sandeep"));

    }

}
