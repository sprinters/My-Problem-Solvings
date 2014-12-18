package main.geeksforgeek.bitmanipulaiton;

public class BitHelper {

	
	/**
	 * this algorithm goes through as many iteration as set bits are present in supplied number.
	 * 
	 * @param number
	 * @return setBits
	 */
	public static int getSetBitCount(int number) {
		
		int setBitCount	=	0;
		while(number > 0) {
			number	=	clearRightMostSetBit(number);
			setBitCount++;
		}
		return setBitCount;
	}
	
	//--------------------------------------------------------------------------------------------------+
	public static int getUnsetBitCount(int number) {
		 
		return (String.valueOf(number).length() - getSetBitCount(number) );
	}
	 
	//--------------------------------------------------------------------------------------------------+
	
	public static int setNthBit(int number,int shift) {
		
		int mask	=	1 << shift;
		number		=	number | mask;
		return number;
		
	}
	
	//--------------------------------------------------------------------------------------------------+
	
	public static int clearNthBit(int number,int shift) {
		
		int mask		=	~(1<< shift);
		number			=	number & mask;
		return number;
	}  
	
	//------------------------------------------------------------------------------------------------+
	
	public static int clearRightMostSetBit(int number) {
		
		return (number & (number-1));
		
	}
	
	//---------------------------------------------------------------------------------------------------+
	
	public static int isolateRightMostZerothBit(int i) {
		return (i & (-i));
	}
	
	//---------------------------------------------------------------------------------------------------+
	
	public static int setRightMostZerothBit(int i) {
		return (i | (i+1));
	}
	
	//---------------------------------------------------------------------------------------------------+
}
