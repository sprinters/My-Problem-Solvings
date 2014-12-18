package main.geeksforgeek.dp.matrixchainmultipication;;
public abstract class MatrixChainMultipicationSimulator {
	
	private MatrixChainMultipicationSolver solver	=	null;
	
	public void setSolver(MatrixChainMultipicationSolver solver) {
		this.solver	=	solver;
	}
	
	
	public MatrixChainMultipicationSolver getSolver() {
		return this.solver;
	}
	public int performOperation(int...array) {
		
		return getSolver().getMinCost(array);
	}
}
