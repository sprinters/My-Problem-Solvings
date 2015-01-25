package main.leetcode;

/**
 * * @author sandeepandey
 */
public class ReverseInteger {

    private static int toMultiply  = 1;
    private static int resultValue = 0;
    public static void main(String...s) {

        ReverseInteger reverseInteger   =   new ReverseInteger();
        int numberToBeReverse   =   1534236469;
        System.out.println(reverseInteger.reverse(numberToBeReverse));
    }

    public int reverse(int toConvert) {

        boolean isNegative  =   toConvert < 0;

        if(isNegative) {
            toConvert   =   toConvert * (-1);
        }
        performReverse(toConvert);

        if(!isNegative && resultValue <=0) {
            return 0;
        }
        return isNegative ? resultValue*-1 : resultValue;

    }

    public void performReverse(int toConvert) {

        if(toConvert > 0) {

            performReverse(toConvert/10) ;
            resultValue +=   (toConvert%10) * toMultiply;
            if(resultValue < Integer.MAX_VALUE && resultValue >=0) {

            }   else {
                return;
            }
            toMultiply = toMultiply * 10;

        }
    }
}
