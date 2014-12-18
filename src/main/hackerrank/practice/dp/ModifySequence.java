package main.hackerrank.practice.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.practice.dp.lis.LISHelper;
import main.practice.dp.lis.SolveWithBinarySearch;

import java.util.Arrays;

public class ModifySequence {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         =   new int[elementCount + 1];
        int[] newArray      =   new int[elementCount];
        for(int i   =   0 ; i < elementCount ; i++) {
            array[i]    =   in.readInt();
        }
        int count   =   0;
        for(int i   =   0 ; i < elementCount ; i++) {
            if(array[i] -i >= 0) {
                newArray[count++]   =   array[i]-i;
            }
        }

        LISHelper lisHelper =   new SolveWithBinarySearch();
        //int[] lis     = lis(Arrays.copyOf(newArray,count));
                //lisHelper.performOperation(Arrays.copyOf(newArray,count));

        out.printLine(elementCount- lisHelper.performOperation(Arrays.copyOf(newArray,count)));


    }


    public static int[] lis(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        int[] len = new int[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // invariant: b[j] is the smallest number that ends a strictly-increasing subsequence of a[0..i-1] of length j+1
            // len[j] = length of LIS ending at a[j] for all j=0..i-1
            int j = lower_bound(b, cnt, a[i]);
            if (j == cnt) ++cnt;
            b[j] = a[i];
            len[i] = j + 1;
        }

        // reconstruct some LIS
        int[] res = new int[cnt];
        for (int i = n - 1; i >= 0; i--)
            if (len[i] == cnt && (cnt == res.length || a[i] < res[cnt]))
                res[--cnt] = a[i];
        return res;
    }


    private static int lower_bound(int[] a, int len, int key) {
        int lo = -1;
        int hi = len;
        while (hi - lo > 1) {
            int mid = (lo + hi) / 2;
            int midVal = a[mid];
            if (midVal < key) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}
