package main.geeksforgeek.dp.partition;

public class Main {
    public static void main(String[] args) {
        PartitionHelper helper  =   new DpTester(new int[]{3,1,1,2,2,1});
        if(helper.abstractSolver()) {
            System.out.println("Array can be build successfully");
        }
        else {
            System.out.println("Array can not be successfully");
        }
    }
}
