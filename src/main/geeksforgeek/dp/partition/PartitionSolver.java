package main.geeksforgeek.dp.partition;


public abstract class  PartitionSolver {
    
    public boolean isPartionable(int...array) {
        return isPartionable(array,0,array.length-1);
    }

    protected abstract boolean isPartionable(int[] array, int from, int to);
}
