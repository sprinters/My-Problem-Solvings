package main.api.my.utils.hashing;


public abstract class AbstractStringHash implements StringHash {

    protected final long DEFAULT_MAULTIPLIER ;

    //--------------------------------------------------------------------------------------

    /**
     *
     */
    public AbstractStringHash() {
//        Random randomBehaviour  =   new Random(547315431513L + System.currentTimeMillis()) ;
//        int randomNumber        =   randomBehaviour.nextInt(Integer.MAX_VALUE);
//        randomNumber            = (int) MyIntegerUtils.nextPrime(randomNumber);

        DEFAULT_MAULTIPLIER     =   31  ;
    }

    //--------------------------------------------------------------------------------------

    /**
     *
     * @param from
     * @return
     */
    public long hash(int from) {
        return hash(from,length());
    }
}

