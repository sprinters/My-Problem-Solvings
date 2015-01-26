package main.api.my.compress;


import main.api.my.pair.Pair;

public class CompressHelper {

    private static int currentCompressedValue	;
    private static long previousValue	=	Long.MIN_VALUE;
    public static long[] helpMe(Pair[] pairArray) {
        currentCompressedValue	=	-1;
        long[] newArray	=	new long[pairArray.length];

        for(Pair newPair : pairArray) {

            long value	=	(Long) newPair.getFirst();
            int index	=	(Integer) newPair.getSecond();

            if(value	==	previousValue) {
                newArray[index]	=	currentCompressedValue;

            } else {

                int newValue	=	currentCompressedValue + 1;
                newArray[index]	=	newValue;
                previousValue	=	value;
                currentCompressedValue++;
            }
        }
        return newArray;

    }

}
