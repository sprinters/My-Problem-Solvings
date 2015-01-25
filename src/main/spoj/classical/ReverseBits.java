package main.spoj.classical;

/**
 * * @author sandeepandey
 */
public class ReverseBits {

    public static void main(String...s) {
        ReverseBits reverseBits =   new ReverseBits();
        reverseBits.doSolve(10);
    }

    /**
     *
     * @param number
     */
    private void doSolve(int number) {
        String asBits = Integer.toBinaryString(number);
        for(int i = 0 ; i < asBits.length()/2 ; i++) {
            performSwapUsingXOR(asBits,i,asBits.length()-1-i,number);
        }

    }

    /**
     *
     * @param asBits
     * @param from
     * @param to
     */
    private void performSwapUsingXOR(String asBits, int from, int to,int number) {

        int mappedMaskForFirst  = 1 << from;
        int mappedMaskForSecond = 1 << to;





    }
}
