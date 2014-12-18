package main.geeksforgeek.dp.matrixchainmultipication;;

public class SolveWithDpWay extends MatrixChainMultipicationSolver {

	@Override
    public int getMinCost(int[] array, int from, int to) {
		
		int[][] dp	=	new int[array.length + 1][array.length + 1];
		
		return from + to;
		
    }

}
