package main.geeksforgeek.dp.matrixchainmultipication;;

public class SolveWithBruteForceWay extends MatrixChainMultipicationSolver {

	@Override
    public int getMinCost(int[] array, int from, int to) {
		if(from	>=	to) {
			return 0;
		}
		
		int minCost	=	Integer.MAX_VALUE;
		for(int i	=	from ; i < to ; i++) {
			int count	=	getMinCost(array,from,i) + getMinCost(array,i+1,to) + array[from-1] * array[i]*array[to];
			if(count < minCost) {
				minCost	=	count;
			}
		}
		return minCost;
	
	}

}
