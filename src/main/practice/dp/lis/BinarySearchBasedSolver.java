package main.practice.dp.lis;


import main.api.my.comparators.IntComparator;

abstract class BinarySearchBasedSolver extends LisSolver{

    private int[] lisArray	=	null;
    private int[] lisHelperArray	=	null;
    private IntComparator comparator	=	null;

    public int solveLIS(int[] inputArray) {

        lisArray	=	new int[inputArray.length];
        lisHelperArray	=	new int[inputArray.length];
        comparator	=	getComparator();
        return solveLIS(inputArray,lisArray,lisHelperArray,comparator);



    }

    private int solveLIS(int[] inputArray,int[] lisArray, int[] lisHelperArray,
                         IntComparator comparator) {

        //very first element is contribute
        lisArray[0]	=	1;

        // current single length lis is ending with inputArray[0]
        lisHelperArray[0]	=	inputArray[0];
        int index			=	0;


        /**
         * so wht is invariant here ?
         * we will try to make the invariant like this
         * we will try to maintain the smallest end of lis of particular length.
         *
         */
            for(int j=1 ; j < inputArray.length ; j++) {

                /**
                 * if current element is less than end of the current unit length lis
                 * then just update it.
                 */
                if(comparator.compare(inputArray[j], lisHelperArray[0]) < 0) {

                    lisHelperArray[0]	=	inputArray[j];
                    lisArray[j]			=	1;
                } else if(comparator.compare(inputArray[j], lisHelperArray[index])
                        > 0){

                    index	=	index+1;
                    lisHelperArray[index]	=	inputArray[j];
                    lisArray[j]	=	index+1;
                } else {
                    int bestIndex	= binarySearch(lisHelperArray,0,index,
                            inputArray[j]);
                    lisHelperArray[bestIndex + 1]	=	Math.min(lisHelperArray[bestIndex + 1],inputArray[j]);
                    lisArray[j]	=	(bestIndex >= 0 ?lisArray[bestIndex]: 0) + 1;
                }

            }
        return getMax(lisArray);

    }

    private int binarySearch(int[] array, int from, int to,int requiredValue) {

        int low	=	from;
        int high	=	to;

        while(low <= high && low >= 0 && high >=0) {
            int mid	=	(low + high) >> 1;
            if(comparator.compare(array[mid],requiredValue) < 0 &&
                    comparator.compare(array[mid + 1],requiredValue) >= 0) {
                return mid;
            } else if(comparator.compare(array[mid ],requiredValue) >= 0) {
                high	=	mid-1;
            } else {
                low		=	mid + 1;
            }
        }
        return -1;
    }
}


