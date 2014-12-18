package main.geeksforgeek.dp.matrixchainmultipication;;



public abstract class MatrixChainMultipicationSolver {
	
	public int getMinCost(int...array) {
		return getMinCost(array,1,array.length-1);
	}
	
	public abstract int getMinCost(int[] array,int from,int to);

}
