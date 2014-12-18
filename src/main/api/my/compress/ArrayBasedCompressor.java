package main.api.my.compress;

import main.api.my.pair.Pair;

import java.util.Arrays;

public class ArrayBasedCompressor implements Compressor{

    public long[] compress(long[] array) {
        return prepossessInput(array,0,array.length-1);

    }
    private long[] prepossessInput(long[] array,int start,int end) {

        Pair[] pairArray	=	new Pair[array.length];
        for(int index	=	0;index < array.length ; index++) {

            Pair newPair	=	Pair.makePair(array[index],index);
            pairArray[index]	=	newPair;

        }

        Arrays.sort(pairArray);
        return CompressHelper.helpMe(pairArray);
    }


}
