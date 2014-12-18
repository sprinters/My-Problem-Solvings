package main.api.my.utils.hashing;

public  abstract class SimpleStringHash extends AbstractStringHash {

    private long[] hashArray =   null;
    private  long[] baseArray =   null;
    private  long[] reverseHashArray  =   null;
    private  int length;

    //-----------------------------------------------------------------------

    /**
     *
     * @param input
     * @param isReverseRequired
     */
    public SimpleStringHash(CharSequence input,boolean isReverseRequired) {
        super();
        length                      =   input.length();
        hashArray                   =   new long[length + 1];

        baseArray                   =   new long[length + 1];
        long tmpHash                =   0;
        long tmpMul                 =   1;

        for(int i   =   0; i < length ; i++) {
            baseArray[i]            =   tmpMul;
            tmpMul                  =   tmpMul * DEFAULT_MAULTIPLIER;
        }

        for(int i   =   0; i < length ; i++) {
            tmpHash                 =   hashFunction(tmpHash,input.charAt(i),48,DEFAULT_MAULTIPLIER);
            hashArray[i]            =   tmpHash;
        }
        if(isReverseRequired) {
            reverseHashArray            =   new long[length + 1];

            tmpHash =   0;
            for(int i   =   length-1 ; i >=0 ; i--) {
                tmpHash     =   hashFunction(tmpHash,input.charAt(i),48,DEFAULT_MAULTIPLIER);
                reverseHashArray[i]    =   tmpHash;
            }
        }

    }

    //-----------------------------------------------------------------------------------------

    /**
     *
     * @param previousHash
     * @param currentChar
     * @param subtractor
     * @param multiplier
     * @return
     */
    public abstract long hashFunction(long previousHash,char currentChar,
                                      int subtractor, long multiplier);

    //-----------------------------------------------------------------------------------------

    /**
     *
     * @param from
     * @param to
     * @return
     */
    @Override
    public long hash(int from, int to) {

        int windowSize              =   to-from + 1;
        if(from < 0 || to < 0) {
            throw new RuntimeException("Array Index is not valid:"+"("+from+","+to+")");
        }

        if(to > length || from > length()) {

            throw new RuntimeException("Array Index is not valid:"+"("+from+","+to+")");
        }


        long collectedHash  = (hashArray[to]-((from <=0) ? 0 :
                hashArray[from-1] * baseArray[windowSize]));
        return collectedHash;
    }


    //--------------------------------------------------------------------------------------------

    /**
     *
     * @param from
     * @param to
     * @return
     */
    @Override
    public long reverseHash(int from, int to) {

        int windowSize              =   from-to + 1;
        if(windowSize <= 0) {
            return 0;
        }
        long hashToReturn   =   reverseHashArray[to]- ((from == length-1) ? 0 :
                reverseHashArray[from+1] * baseArray[windowSize]);
        return hashToReturn;
    }

    //------------------------------------------------------------------------------------------

    /**
     *
     * @return
     */
    @Override
    public int length() {
        return length;
    }

    //-----------------------------------------------------------------------------------------

    /**
     *
     * @return
     */
    public long[] getPrefixHashes() {
        return hashArray;
    }

    //-----------------------------------------------------------------------------------------

    /**
     *
     * @return
     */
    public long[] getSuffixHashes() {
        return reverseHashArray;
    }

    //------------------------------------------------------------------------------------------

    /**
     *
     * @return
     */
    public long[] getBaseArray() {
        return baseArray;
    }

    //-----------------------------------------------------------------------------------------

}
