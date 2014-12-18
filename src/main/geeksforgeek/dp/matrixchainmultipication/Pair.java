package main.geeksforgeek.dp.matrixchainmultipication;;

public class Pair<U,V> implements Comparable<Pair<U,V>>{
	
	private U first	=	null;
	private V second	=	null;
	
	
	public Pair(U first, V second) {
		this.first	=	first;
		this.second	=	second;
	
	}


	public  static <U,V> Pair<U,V> makePair(U first,V second) {
		return new Pair<U,V>(first,second);
		
	}
	
	public boolean equals(Object o) {
		
		if(this ==	o) {
			return true;
		} 
		if(o	==	null || getClass() != o.getClass()) {
			return false;
		}
		if(!(o instanceof Pair<?,?>)) {
			return false;
		}
		
		Pair<?,?> newPair	=	(Pair<?,?>)o;
		
        return !(first != null ? !first.equals(newPair.first) :
        	newPair.first != null) 
        		&& !(second != null ? !second.equals(newPair.second) : 
        			newPair.second != null);
	}
	
	public int hashCode() {
		
		int result	=	first != null ? first.hashCode() : 0;
		result	=	31 * result + (second != null ? second.hashCode(): 0);
		return result;
		
	}

	@Override
    public int compareTo(Pair<U, V> o) {
	    // TODO Auto-generated method stub
	    return 0;
    }
	
	

}
