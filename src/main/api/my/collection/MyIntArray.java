package main.api.my.collection;



public class MyIntArray extends MyIntBasedList {

    /**
     * final array..it can not be modified
     */
    private final int[] array;


    /**
     * you can create object of this class by passing known array.
     * @param array
     */
    public MyIntArray(int...array) {
        this.array  =   array;
    }


    /**
     * This method will let you know by passing MyIntBasedCollection.
     * @param myCollection
     */
    public MyIntArray(MyIntBasedCollection myCollection) {

        array   =   new int[myCollection.size()];
        int start   =   0;
        for(MyIntIterator itr   =   getIntIterator() ; itr.isNextSafe();itr.moveNext()) {
            array[start++]  =   itr.getValue();
        }
    }

    /**
     * This method will let you get value at supplied position.
     * @param index
     * @return
     */
    private int getAt(int index) {
        if(this.array == null || index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    /**
     * This method will let you modify value at supplied position with desired value.
     * @param index
     * @param value
     */
    public void setAt(int index,int value) {
        if(this.array == null || index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        array[index]    =   value;

    }

    /**
     * This method will let you access array rep of this class.
     * @return array
     */
    public int[] toArray() {
        return array;
    }

    /**
     * This method is not supported by this class.
     * @param toAdd
     */
    public void add(int toAdd) {
        throw new UnsupportedOperationException();
    }

    /**
     * This method will let you check whether array is empty or not.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }


    /**
     * This method is wrapper method of getAt method.
     * @param index
     * @return value
     */
    @Override
    public int valueAt(int index) {
        return getAt(index);
    }

    /**
     * This method will let you know the size of array.
     * @return
     */
    @Override
    public int size() {
        return array.length;
    }

    /**
     *
     */

    public void updateAt(int at ,int toUpdate) {

        if(isValid(at)) {
            setAt(at,toUpdate);
            return;
        }

        throw new RuntimeException("Supplied Index is not valid."+at) ;


    }

    public boolean isValid(int posToValidate) {
        if(this.array == null || posToValidate >= array.length || posToValidate < 0) {
            return false;

        }
        return true;

    }
}
