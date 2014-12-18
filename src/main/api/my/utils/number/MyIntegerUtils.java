package main.api.my.utils.number;

import main.api.my.collection.MyIntArrayList;
import main.api.my.pair.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyIntegerUtils {


    //-------------------------------------------------------

    /**
     *
     * @param first
     * @param second
     * @return
     */
    public static long gcd(long first,long second) {
        if(second   ==  0) {
            return first;
        }
        return gcd(second,first%second);
    }

    //-------------------------------------------------------

    /**
     *
     * @param first
     * @param second
     * @return
     */
    public static int gcd(int first,int second) {
        if(second   ==  0) {
            return first;
        }
        return gcd(second,first%second);
    }

    //--------------------------------------------------------

    /**
     *
     * @param upTo
     * @return
     */
    public static int[] generatePrimes(int upTo) {
        boolean[] isPrime   =   generatePrimalityTable(upTo);
        MyIntArrayList primeList   =   new MyIntArrayList();

        for(int i   =   0;i < upTo ; i++) {
            if(isPrime[i])
                primeList.add(i);
        }
        return primeList.toArray();
    }

    //---------------------------------------------------------

    /**
     *
     * @param upTo
     * @return
     */
    public static boolean[] generatePrimalityTable(int upTo) {
        boolean[] isPrime   =   new boolean[upTo];
        Arrays.fill(isPrime,true);

        isPrime[0]  =   isPrime[1]  =   false;

        for(int j   =   2; j * j <= upTo ;j++) {
            if(isPrime[j]) {
                for(int i   =   j * j ; i < upTo ; i+=j) {
                    isPrime[i]  =   false;
                }
            }
        }
        return isPrime;
    }

    //------------------------------------------------------------
    /**
     * This method will compute the prime number under supplied limit.
     * @param upTo
     * @return
     */
    public static Integer[] performSuperFastSieve(int upTo){
        char[] mark=new char[upTo/2/8+1];
        ArrayList<Integer> primes   =   new ArrayList<Integer>();
        for (int i = 3; i*i <=upTo; i += 2)
            if ( (mark[i>>4] & (1<<((i>>1)&7))) == 0 )
                for (int j = i*i; j <=upTo; j += i<<1) mark[j>>4] |= (1<<((j>>1)&7));
        primes.add(2);
        for (int i = 3; i <=upTo; i += 2)
            if ( (mark[i>>4]&(1<<((i>>1)&7))) == 0) {
                primes.add(i);
            }
        return primes.toArray(new Integer[primes.size()]);
    }

    //------------------------------------------------------------
    /**
     *
     */
    public static int[] generateDivisorTable(int upTo) {
        int[] divisor   =   new int[upTo];

        for(int i   =   1;i < upTo ; i++) {
            divisor[i]  =   i;
        }

        for(int i   =   2;i * i < upTo ; i++) {
            if(divisor[i]   ==  i)  {
                for(int j   =   i * i ; j < upTo ; j+=i) {
                     divisor[j] =  i;
                }
            }
        }
        return divisor;
    }


    //-----------------------------------------------------------
    /**
     *
     */

    public static List<Pair<Long,Integer>> factorize(long number) {

        List<Pair<Long,Integer>> result =   new ArrayList<Pair<Long,Integer>>();

        for(long i   =   2 ; i * i <= number ; i++) {
            if(number % i ==    0) {
                int power   =   0;
                do{
                    power++;
                    number/=i;

                } while(number%i == 0);
                result.add(Pair.makePair(i,power));
            }
        }

        if(number != 1) {
            result.add(Pair.makePair(number,1));
        }
        return result;
    }

    //--------------------------------------------------------------------------
    /**
     *
     */
    public static boolean isPrime(long toTest) {

        if(toTest < 2) {
            return false;
        }

        for(int i   =   2;i * i <= toTest ; i++) {
            if(toTest % i ==    0) {
                return false;
            }
        }
        return true;
    }

    //--------------------------------------------------------------------------
    /**
     *
     */

    public static long nextPrime(long from) {
        if(from<=2) {
            return 2;
        }

        from = from + 1-(from & 1);
        while(!isPrime(from)) {
            from = from + 2;
        }

        return from;
    }

    //---------------------------------------------------------------------------

    /**
     *
     * @return
     */
    public static List<Long> getDivisors(long number) {
        List<Pair<Long,Integer>>  primeDivisors =   factorize(number);
        return getDivisorsImpl(primeDivisors,0,1,new ArrayList<Long>());
    }

    //--------------------------------------------------------------------------
    /**
     *
     */
    public static List<Long> getDivisorsImpl(List<Pair<Long,Integer>>
              primeDivisors,int index,long current,ArrayList<Long> result) {
        if (index == primeDivisors.size()) {
            result.add(current);
            return result;
        }
        long p = primeDivisors.get(index).first;
        int power = primeDivisors.get(index).second;
        for (int i = 0; i <= power; i++) {
            getDivisorsImpl(primeDivisors, index + 1, current, result);
            current *= p;
        }
        return result;
    }

    //----------------------------------------------------------------

    /**
     *
     * @param n
     * @return
     */
    public static long[][] generateBinomialCoefficients(int n) {

        long[][] result =   new long[n+1][n+1];

        for(int i   =   0;i <= n ; i++) {
            result[i][0]    =   1;
            for(int j   =   1;j <= i ; j++) {
                result[i][j]    =   result[i-1][j-1] + result[i-1][j];
            }
        }
        return result;

    }
    public static double[][] generateBinomialCoefficientsWithDouble(int n) {
        double[][] result = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            result[i][0] = 1.0;
            for (int j = 1; j <= i; j++)
                result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
        }
        return result;
    }

    //-----------------------------------------------------------------

    /**
     *
     * @param n
     * @return
     */
    public static long[][] generateBinomialCoefficients(int n,long mod) {

        long[][] result =   new long[n+1][n+1];

        if(mod == 1) {
            return result;
        }

        for(int i   =   0;i <= n ; i++) {
            result[i][0]    =   1;
            for(int j   =   1;j <= i ; j++) {
                result[i][j]    =   result[i-1][j-1] + result[i-1][j];

                if(result[i][j] >= mod) {
                    result[i][j]    -= mod;
                }
            }
        }
        return result;

    }

    //---------------------------------------------------------------------
    /**
     *
     */
    public static int[] spaceOptimizedSieve(int upTo) {

            char mark[]=new char[upTo/2/8+1];
            MyIntArrayList primes   =   new MyIntArrayList();
            int i,j;
            for (i = 3; i*i <=upTo; i += 2)
                if ( (mark[i>>4] & (1<<((i>>1)&7))) == 0 )
                    for (j = i*i; j <=upTo; j += i<<1) mark[j>>4] |= (1<<((j>>1)&7));
            primes.add(2);
            for (i = 3; i <=upTo; i += 2) {
                if ( (mark[i>>4]&(1<<((i>>1)&7))) == 0) {
                    primes.add(i);
                }
            }
            return primes.toArray();

    }

    //-----------------------------------------------------------------

    /**
     *
     * @param base
     * @param power
     * @param mod
     * @return
     */
    public static long doMod(long base,long power,long mod) {

        long x =1,y=base;
        while(power > 1) {

            if(power % 2 == 1) {
                x =  (x * y) % mod;
            }

            y  =  ( y * y ) % mod;

            power = power >> 1;
        }
        return x;
    }

    //------------------------------------------------------------------

    /**
     *
     * @param base
     * @param exponent
     * @param mod
     * @return
     */
    public static long power(long base, long exponent, long mod) {
        if (base >= mod)
            base %= mod;
        if (exponent == 0)
            return 1 % mod;
        long result = power(base, exponent >> 1, mod);
        result = result * result % mod;
        if ((exponent & 1) != 0)
            result = result * base % mod;
        return result;
    }

    public static long power(long base, long exponent) {
        if (exponent == 0)
            return 1;
        long result = power(base, exponent >> 1);
        result = result * result;
        if ((exponent & 1) != 0)
            result = result * base;
        return result;
    }

    public static double powerWithNegativeExponent(double base, long exponent) {
        if(exponent == 0)
            return 1;
        else{
            double r = powerWithNegativeExponent(base, exponent/2);
            if(exponent % 2 < 0)
                return r * r / base;
            else if(exponent % 2 > 0)
                return r * r * base;
            else
                return r * r;
        }
    }


}
