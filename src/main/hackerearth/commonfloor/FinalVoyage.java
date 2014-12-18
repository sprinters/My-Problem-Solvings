package main.hackerearth.commonfloor;


import main.api.my.io.OutputWriter;
import net.egork.chelper.util.InputReader;

public class FinalVoyage {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int N   =   in.readInt();
        int W   =   in.readInt();
       // int[] weights   = IOUtils.readIntArray(in, N);
       // int[] other     =   IOUtils.readIntArray(in,N);

      //  long result =   knapSack(W,weights,other,N) ;
       // out.printLine(result);
    }


    public int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int[][] K = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }
}


