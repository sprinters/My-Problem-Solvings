package main.api.my.collection;

/**
 * * @author sandeepandey
 */

public class MyLongArrayList extends MyIntBasedList {
    // array to be handled
    private long[] array =   null;
    private int size      = 0;


    /**
     * default constructor of this class.
     */
    public MyLongArrayList() {
        this(10);
    }

    /**
     * argument based constructor.
     * @param capacity
     */
    public MyLongArrayList(int capacity) {
        array   =   new long[capacity];
    }

    /**
     * This method will let you add new item at the end of this list.
     * @param toAdd
     */
    public void add(int toAdd) {
        ensureCapacity(size + 1);
        array[size++]   =   toAdd;
    }

    /**
     * This method will check whether we have to increase the size of array or not.
     * @param newCapacity
     */
    private void ensureCapacity(int newCapacity) {

        if(newCapacity > array.length) {
            long[] newArray  =   new long[Math.max(newCapacity,array.length << 1)];
            System.arraycopy(array,0,newArray,0,array.length);
            array   =   newArray;
        }

    }

    /**
     * This method will let you update list at particular location with supplied value.
     * @param index
     * @param value
     * @throws ArrayIndexOutOfBoundsException
     */
    @Override
    public void setAt(int index, int value) {
        if(index >= size) {
            throw  new  ArrayIndexOutOfBoundsException();

        }
        array[index]   =   value;
    }

    /**
     * This method will let you know whether this list is empty or not.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * This method will let you know value at supplied position.
     * @param index
     * @return
     */
    @Override
    public int valueAt(int index) {

        if(index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (int) array[index];

    }

    /**
     * This method will let you know size of this list.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This class will let you get array representation of this class.
     * @return
     */
    public int[] toArray() {
        int[] newArray =   new int[size];
        System.arraycopy(this.array,0,newArray,0,size);
        return newArray;
    }

    /**
     * This method let you check whether supplied element is present in this collection or not.
     * NOTE : if element is present then this method will return you first occurence.
     * @param toCheck
     * @return  if present then index of that element ..else -1
     */
    public int contains(int toCheck) {


        return -1;
    }

    /**
     * This method will add all element present in the supplied list to end of the source of the list.
     *
     * @param toAdd
     */
    public void addAll(MyIntBasedList toAdd) {

        if(toAdd == null || toAdd.isEmpty()) {
            return;
        }

        for(MyIntIterator itr = toAdd.getIntIterator() ; itr.isNextSafe() ; itr.moveNext()) {
            add(itr.getValue());
        }
    }

    /**
     * This method will erase element at supplied pos.This method will erase first entry
     * of the supplied element.
     *
     */
    public void removeAt(int posToDelete) {

        isValidPos(posToDelete);
        long[] newArray  =   new long[size()-1];


        int index       =   0;
        for(int i   =   0;i < posToDelete ; i++) {
            newArray[index++] =   valueAt(i);
        }


        for(int i  =    posToDelete + 1 ; i < size() ; i++) {
            newArray[index++]   =   valueAt(i);
        }
        array   =   newArray;
        size--;

        newArray    =   null;
    }

    //-------------------------------------------------------------------------------------

    /**
     * This method will check whether supplied element is exist or not.if supplied element is
     * exist then return the position of
     * @param toCheck
     * @return
     */
    public int indexOf(int toCheck) {

        int pos         =   0;
        for(MyIntIterator itr   =   getIntIterator() ; itr.isNextSafe();itr.moveNext()) {
            if(itr.getValue()   ==  toCheck) {
                return pos;
            }
            pos++;
        }

        return pos;
    }


    //------------------------------------------------------------------------------------
    /**
     *
     * @param posToValidate
     */
    public void isValidPos(int posToValidate) {

        if(posToValidate < 0 || posToValidate >= size()) {
            throw new ArrayIndexOutOfBoundsException("pos is not valid:"+posToValidate) ;
        }

    }



}

