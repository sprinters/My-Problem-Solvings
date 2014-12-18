
package main.geeksforgeek.dp.matrixchainmultipication;

import java.util.Map;
import java.util.HashMap;
import java.util.Map;

public class MapBasedMemorization extends MatrixChainMultipicationSolver {

	@Override
    public int getMinCost(int[] array, int from, int to) {
	 
		Map<Pair<Integer,Integer>,Integer> memoMap	=	new HashMap<Pair<Integer,Integer>,Integer>();
		return getMinCost(array,from,to,memoMap);
		
    }

	private int getMinCost(int[] array, int from, int to,
            Map<Pair<Integer, Integer>, Integer> memoMap) {
	    
		Pair<Integer,Integer> entry	=	Pair.makePair(from, to);
		if(memoMap.containsKey(entry)) {
			return memoMap.get(entry);
		}
		
		if(from >= to) {
			return 0;
		}
		
		for(int k	= from; k < to ; k++) {
			
			int value	=	getMinCost(array,from,k,memoMap) +
							getMinCost(array,k+1,to,memoMap) +
							array[from-1] * array[k] * array[to];
			
			
			Pair<Integer,Integer> item	=	Pair.makePair(from, to);
			if(memoMap.containsKey(item)) {
				memoMap.put(item, Math.min(memoMap.get(item), value));
			} else {
				memoMap.put(item, value);
			}
		}
		return memoMap.get(Pair.makePair(from, to));
	}

}
