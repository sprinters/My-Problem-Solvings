package main.hackerearth.adobe;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class MindPalaces {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int m   =   in.readInt();

        long[][] table   = IOUtils.readLongTable(in,(int)n,(int)m) ;

        int qCOunt  =   in.readInt();
        for(int i   =   0;i < qCOunt ; i++) {
            long x   =   in.readInt();
            searchMatrix(table,x,out);

        }

    }

    public void searchMatrix1(long[][] matrix, long target,OutputWriter out) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)  {
            out.printLine("-1 -1");
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        long start = 0;
        long end = m*n-1;

        while(start<=end){
            long mid=(start+end)/2;
            long midX=mid/n;
            long midY=mid%n;

            if(matrix[(int)midX][(int)midY]==target)     {
                out.printLine(midX+" " + midY);
                return;
            }

            if(matrix[(int)midX][(int)midY]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        out.printLine("-1 -1");
        return;
    }

    public boolean searchMatrix(long[][] matrix, long target,OutputWriter out) {
        int rows = matrix.length, cols=matrix[0].length;
        if(matrix.length == 0){
            out.printLine("-1 -1");
            return false;
        }
        int i=0, j=matrix[0].length-1;

        while(i>=0 && i<rows && j>=0 && j<cols){
            if(matrix[i][j] == target){
                out.printLine(i+" "+j);
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }

        out.printLine("-1 -1");
        return false;
    }

}
