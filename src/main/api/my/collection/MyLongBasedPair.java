package main.api.my.collection;


/**
 * * @author sandeepandey
 */
public class MyLongBasedPair implements Comparable<MyLongBasedPair> {

    private long first   ;
    private long second  ;

    public MyLongBasedPair(int first,int second) {
        this.first  =   first;
        this.second =   second;
    }

    public boolean equals(Object o) {
        if(this     ==  o) {
            return  true;
        }


        if(!(o instanceof MyLongBasedPair)) {
            return false;
        }

        if(o == null || this.getClass() != o.getClass()) {
            return false;
        }

        MyLongBasedPair myLongBasedPair   =   (MyLongBasedPair)o;

        return this.getFirst()  ==  myLongBasedPair.getFirst()
                && this.getSecond() ==  myLongBasedPair.getSecond();
    }

    public int hashCode() {
        long result  =   first;
        result  =   31 * result ^ second;
        return (int) result;
    }

    public long getFirst() {
        return first;
    }

    public long getSecond() {
        return second;
    }




    @Override
    public int compareTo(MyLongBasedPair toCompare) {
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
