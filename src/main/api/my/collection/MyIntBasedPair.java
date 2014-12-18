package main.api.my.collection;

/**
 * * @author sandeepandey
 */
public class MyIntBasedPair implements Comparable<MyIntBasedPair> {

    private int first   ;
    private int second  ;

    public MyIntBasedPair(int first,int second) {
        this.first  =   first;
        this.second =   second;
    }

    public boolean equals(Object o) {
        if(this     ==  o) {
            return  true;
        }


        if(!(o instanceof MyIntBasedPair)) {
            return false;
        }

        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }

        MyIntBasedPair myIntBasedPair   =   (MyIntBasedPair)o;

        return this.getFirst()  ==  myIntBasedPair.getFirst()
                && this.getSecond() ==  myIntBasedPair.getSecond();
    }

    public int hashCode() {
        int result  =   first;
        result  =   31 * result ^ second;
        return result;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }




    @Override
    public int compareTo(MyIntBasedPair toCompare) {
        // add some default implementation
        if (first < toCompare.first)
            return -1;
        if (first > toCompare.first)
            return 1;
        if (second < toCompare.second)
            return -1;
        if (second > toCompare.second)
            return 1;
        return 0;
    }
}
