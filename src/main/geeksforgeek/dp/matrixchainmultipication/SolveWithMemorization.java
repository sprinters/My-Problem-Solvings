package main.geeksforgeek.dp.matrixchainmultipication;

import main.api.my.utils.array.ArrayUtils;



public class SolveWithMemorization extends MatrixChainMultipicationSolver {

	@Override
    public int getMinCost(int[] array, int from, int to) {
		
		int[][] memo	=	new int[array.length + 1][array.length + 1];
		ArrayUtils.fill(memo, 0);
		
		return getMinCost(array,from,to,memo);
	    
    }

	private int getMinCost(int[] array, int from, int to, int[][] memo) {
	    
		if(from	>= to) {
			return 0;
		}
		
		
		if(memo[from][to] < Integer.MAX_VALUE) {
			return memo[from][to];
		}
		
		
		for(int k	= from ; k < to ; k++) {
			
			int value	=	getMinCost(array,from,k,memo) +
							getMinCost(array, k+1, to,memo) +
							array[from-1]*array[k]*array[to];
			
			if(memo[from][to] > value) {
				memo[from][to]	=	value;
			}
		}
		
		return memo[from][to];
	}

}
