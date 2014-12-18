package main.geeksforgeek.linklist.singlelinklist;


public class SingleLinkList {


    private int value;
    private SingleLinkList next =   null;

    public SingleLinkList(int value) {
        this.next   =   null;
        this.value  =   value;

    }


    public String toString() {
        String output   =   "";
        SingleLinkList current  =   this;
        while(current != null) {
            output = output + ""+current.getValue()+">";
            current =   current.getNext();
        }
        output+="TAIL" ;
        return output;
    }

    public SingleLinkList getNext() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }

    public void setNext(SingleLinkList next) {
        this.next   =   next;
    }


}
