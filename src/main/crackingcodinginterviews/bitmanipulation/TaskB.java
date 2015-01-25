package main.crackingcodinginterviews.bitmanipulation;

/**
 * * @author sandeepandey
 */
public class TaskB {
    public TaskB() {

    }

    public static void main(String...s) {


    }


    public static boolean getBit(int number,int at) {
        return ( number & (1<<at) ) > 0;
    }

    public static int  setBit(int number,int at,boolean flag) {

        if(flag) {
            return  number | (1 << at);
        }
        int mask    =   ~(1 << at);
        return number & mask;


    }

    public int  getNextHighest(int x) {

        // first we need to skip all zeros while traversing right to left
        int index = 0;
        int count   =   0;
        while(!getBit(x,index)) index++;

        // now index will be pointing to first one while traversing from right to left

        while(getBit(x,index))  {
            index++;
            count++;
        }

        // now index will be pointing to the zero to be flipped
        // just flip it

        x = setBit(x,index,true);
        index--;
        x = setBit(x,index,false);
        count--;
        // now try to make number as small as possible

        for(int i   =   index-1;i >= count ; i--) {
            x = setBit(x,i,false);
        }

        for(int i   =   count-1;i>=0;i--) {
            x = setBit(x,i,true);
        }

        return x;


    }

    public int getJustLowest(int x) {

        int index   =   0;
        int count   =   0;
        while(getBit(x,index)) index++;

        while(!getBit(x,index)) {
            index++;
            count++;
        }

        x = setBit(x,index,false);

        index --;
        x = setBit(x,index,true);

        count--;

        for(int i   =   index-1;i >= count ; i--) {
            x = setBit(x,i,true);
        }

        for(int i   =   count-1;i >=0 ; i--) {
            x = setBit(x,i,false);
        }

        return x;
    }
}
