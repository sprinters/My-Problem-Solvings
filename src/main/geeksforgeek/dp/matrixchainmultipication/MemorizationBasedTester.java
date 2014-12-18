package main.geeksforgeek.dp.matrixchainmultipication;;

public class MemorizationBasedTester extends MatrixChainMultipicationSimulator {
	
	public MemorizationBasedTester() {
		abstractSolver();
	}

	private void abstractSolver() {
	    MatrixChainMultipicationSolver solver	=	new SolveWithMemorization();
	    setSolver(solver);
		
    }
}
