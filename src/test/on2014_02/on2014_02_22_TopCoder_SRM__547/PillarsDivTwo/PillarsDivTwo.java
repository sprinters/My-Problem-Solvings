package test.on2014_02.on2014_02_22_TopCoder_SRM__547.PillarsDivTwo;



public class PillarsDivTwo {

    public double maximalLength(int[] height, int w) {


        double[][] dp  =   new double[51][102];


        // so wht will be your dp state ?
        // suppose dp[i][j] is the max rope required to connect first i pillers where
        // ith pillar have jth height.


        // think about base case


        for(int i   =   0 ; i < 101 ; i++) {
            dp[0][i]    =   0.0;
        }

        // lets iterate all pillar
        // so how many pillar are there ?
        //
        for(int i   =   1;i < height.length ; i++ ){

            // lets fill details of ith pillar where height of
            // ith pillar may vary from 1...to height[i]
            // we will fill base answer for dp[][]


            for(int k   =   1 ; k <= height[i] ; k++) {
                //fill best for ith pillar having height k

                double dummy    =   0;
                // how you find the best.
                // we will iterate
                for(int p   =   1 ; p <= height[i-1] ; p++) {
                    dummy   =   Math.max(dummy,Math.sqrt(w * w + (p-k) * (p-k)) + dp[i-1][p]);
                }

                dp[i][k]    =   dummy;
            }
        }

        double answer =   Integer.MIN_VALUE;
        for(int i   =   1;i <= height[height.length-1] ; i++) {
            answer  =   Math.max(answer,dp[height.length-1][i]);
        }

        return answer;

    }
}
