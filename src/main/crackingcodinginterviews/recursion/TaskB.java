package main.crackingcodinginterviews.recursion;

/**
 * * @author sandeepandey
 */
public class TaskB {

    int[] columnForRow  =   new int[8];
    public static void main(String...s) {

        TaskB tasB   =   new TaskB();
        tasB.performPlaceQueenOperation(0);
    }

    private void performPlaceQueenOperation(int forRow) {

        if(forRow   ==  8) {
            showConfiguration();
            return;
        }

        for(int i   =   0;i < 8 ; i++) {
            columnForRow[forRow]    =   i;
            if(isConfigurationOkay(forRow)) {
                performPlaceQueenOperation(forRow + 1);
            }
        }
    }

    private boolean isConfigurationOkay(int rowAt) {

        for(int i   =   0;i < rowAt ; i++) {

            int difference  =   Math.abs(columnForRow[i]-columnForRow[rowAt]);

            if(difference   ==  0 || difference ==  rowAt-i) {
                return false;
            }

        }

        return true;
    }

    private void showConfiguration() {


    }


}
