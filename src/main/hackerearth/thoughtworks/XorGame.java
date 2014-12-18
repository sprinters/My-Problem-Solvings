package main.hackerearth.thoughtworks;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class XorGame {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int[] array = IOUtils.readIntArray(in,n);

        int qtyCount    =   in.readInt();
        int[] from      =   new int[qtyCount];
        int[] to        =   new int[qtyCount];
        int[] with      =   new int[qtyCount];

        for(int i   =   0;i < qtyCount ; i++) {
            from[i] =   in.readInt()-1;
            to[i]   =   in.readInt()-1;
            with[i] =   in.readInt();
        }


        //MiscUtils.decreaseByOne(from,to);

        for(int i   =   0;i < qtyCount ; i++) {


            long count   =   1;
            long minXOR  =   array[from[i]] ^ with[i];
            long Z       =  array[from[i]];
            for(int start   =   from[i] + 1 ; start <= to[i] ; start++) {

                try {
                //out.printLine("start::"+start);
                    long tmpXOR  =   with[i] ^ array[start];

                if(tmpXOR < minXOR) {
                    minXOR  =   tmpXOR;
                    Z       =   array[start];
                    count=  1;
                } else if (tmpXOR   ==  minXOR) {
                    count++ ;
                    //Z   =   tmpXOR;
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            out.printLine(Z+" "+count);
        }


    }
}
