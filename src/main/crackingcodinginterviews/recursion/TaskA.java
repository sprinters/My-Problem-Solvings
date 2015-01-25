package main.crackingcodinginterviews.recursion;

/**
 * * @author sandeepandey
 */
public class TaskA {

    public static void main(String...s) {
        TaskA taskA =   new TaskA();
        System.out.println(taskA.makeChanges(100,25));
    }

    public int makeChanges(int amount ,int denomination) {
        int nextDenomination    =   0;
        switch(denomination) {
            case 25 :
                nextDenomination    =   10;
                break;
            case 10 :
                nextDenomination    =   5;
                break;
            case 5 :
                nextDenomination    =   1;
                break;
            case 1:
                return 1;
        }

        int ways    =   0;
        for(int j   =   0; j * denomination <= amount ; j++) {
            ways += makeChanges(amount - ( j * denomination ), nextDenomination);
        }
        return ways;
    }
}
