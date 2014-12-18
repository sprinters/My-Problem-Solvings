package main.geeksforgeek.dp.matrixchainmultipication;;

public class BruteForceTester extends MatrixChainMultipicationSimulator{

	public BruteForceTester() {
		abstractSolver();
	}

	private void abstractSolver() {
	    
		MatrixChainMultipicationSolver solver	=	 new SolveWithBruteForceWay();
		setSolver(solver);
		
    }

}
