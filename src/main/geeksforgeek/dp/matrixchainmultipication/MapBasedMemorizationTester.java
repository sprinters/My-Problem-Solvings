package main.geeksforgeek.dp.matrixchainmultipication;;

public class MapBasedMemorizationTester extends MatrixChainMultipicationSimulator{
	
	public MapBasedMemorizationTester() {
		abstractSolver();
	}

	private void abstractSolver() {
	    MatrixChainMultipicationSolver solver	=	new MapBasedMemorization();
	    setSolver(solver);
		
    }
}
