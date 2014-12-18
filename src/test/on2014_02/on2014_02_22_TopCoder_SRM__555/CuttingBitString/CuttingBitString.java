package test.on2014_02.on2014_02_22_TopCoder_SRM__555.CuttingBitString;



import java.util.Arrays;

public class CuttingBitString {
    public int getmin(String S) {
    int[] dp    =   new int[S.length()+1];
    Arrays.fill(dp,-1);

    char[] input    =   S.toCharArray();
    // Wht is state here
    // dp[i] >> min num of cut required to form 5 power substring

    dp[0]   =  isPowerOfFive(input,0,1) ? 1 : -1;

    for(int i = 1 ;i < input.length ; i++) {

        // do all possible cut for len 0..i


        if(isPowerOfFive(input,0,i+1)) {
            dp[i]   =   1;
            continue;
        }
        // if this is power of 5 ..just add one to answer.
        // no need to make any cut.
        for(int cutAt   =   0 ; cutAt < i ; cutAt++) {

            if(dp[cutAt] != -1) {

                if(isPowerOfFive(input,cutAt+1,i+1)) {

                    if(dp[i]    == -1 || dp[i] > (dp[cutAt] + 1)) {
                        dp[i]   =   dp[cutAt] + 1;
                    }
                }
            }
        }

    }

    return dp[input.length-1];

}

    public static boolean isPowerOfFive(char[] input,int start,int end) {
        // check whether string have leading zero or not

        if(input    ==  null || input.length <= 0 ) {
            return false;
        }

        if(input[start] ==  '0') {
            return false;
        }

        long value  =   0;

        for(int i   =   start;i < end ; i++) {
            value = (value * 2) + (input[i]    == '1' ? 1 : 0);
        }

       // System.out.println("Value::"+value);
        while((value%5) == 0) {
            value = value/5;
        }

        return value    ==  1;
    }
}
