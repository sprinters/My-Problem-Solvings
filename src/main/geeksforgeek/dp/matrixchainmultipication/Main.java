package main.geeksforgeek.dp.matrixchainmultipication;;

public class Main {
	
	public static void main(String...s) {
//		MatrixChainMultipicationSimulator	bruteTester	=	new BruteForceTester();
//		int value	=	bruteTester.performOperation(new int[] {10, 20, 30} );
//		
//		MatrixChainMultipicationSimulator   memoTester	=	new MemorizationBasedTester();
//		
//		int costFromMemo	=	memoTester.performOperation(new int[] {10,20,30});
//		
		MatrixChainMultipicationSimulator mapBasedMemoTester	=	new MapBasedMemorizationTester();	
		
		int costFromMapBasedMemo	=	mapBasedMemoTester.performOperation(new int[]{40, 20, 30, 10, 30} );
		System.out.println(costFromMapBasedMemo);
		
		
		
	}
}
