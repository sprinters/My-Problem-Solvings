package main;

import main.api.my.utils.array.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class WordParts {
    public int partCount(String original, String compound) {

        char[] originalAt   =   original.toCharArray();
        char[] compoundAt    =   compound.toCharArray();


        if(compound ==  null || compound.length()    ==  0 ) {
            return 0;
        }
        /**
         * first lets create dictionary of all prefix and suffix of the original string.
         */

        Set<String> dict    =   new HashSet<String>();

        for(int j   = 0 ; j < original.length() ; j++)
            dict.add(getSubstring(0,j,originalAt));

        for(int i = original.length()-1 ; i >=0 ; i--)
            dict.add(getSubstring(i,original.length()-1,originalAt));

        /**
         * f(i,j) > minimum number of N required to make the compound[i..j]
         */


        int[][] f   =   new int[compound.length() + 1][compound.length() + 1];
        ArrayUtils.fill(f,-1);

        /**
         * fill the base cases
         */
        for(int j   =   0;j < compoundAt.length ; j++) {

            String toCheck  = getSubstring(j,j,compoundAt);
            if(dict.contains(toCheck)) {
                f[j][j] =   1;
            } else {

                f[j][j] =   -1;
            }
        }


        for(int len =   2;len <= compoundAt.length ; len++) {

            for(int j   =   0;j < (compoundAt.length-len + 1) ; j++) {

                int startAt =   j ;
                int endAt   =   j+len-1;


                if(len==2) {

                    String toLook   =   getSubstring(startAt,endAt,compoundAt);

                    if(dict.contains(toLook)) {
                        f[startAt][endAt]   =   1;
                    } else if(dict.contains(getSubstring(startAt,startAt,compoundAt))
                            && dict.contains(getSubstring(endAt,endAt,compoundAt))) {
                         f[startAt][endAt]  =   2;
                    }  else {
                        f[startAt][endAt]   =   -1;
                    }

                    continue;

                }
                Integer minN    =   Integer.MAX_VALUE;

                if(dict.contains(getSubstring(startAt,endAt,compoundAt))) {
                    minN    =   Math.min(minN,1);
                } else {
                    for(int k   =   startAt ; k < endAt ; k++) {
                        if(f[startAt][k] != -1 && f[k+1][endAt] != -1) {
                            minN    =   Math.min(minN,f[startAt][k] + f[k+1][endAt]);
                        }
                    }
                }

                f[startAt][endAt]   =   (minN == Integer.MAX_VALUE) ? -1 : minN;
            }

        }
        return f[0][compoundAt.length-1]    ==  Integer.MAX_VALUE ? -1 : f[0][compoundAt.length-1] ;


    }


    public String getSubstring(int start,int end,char...array) {

        if(start < 0 || end >= array.length) {
            throw new RuntimeException();
        }

        String tmp  =   "";
        for(int from    =   start;from<=end ; from++) {
            tmp += array[from];
        }

        return tmp;
    }
}
