package main.leetcode;

public class MergeSortedArray {

    public static void main(String...s) {
        MergeSortedArray sortedArray    =   new MergeSortedArray();

        int[][] array   =   new int[10][10];
        sortedArray.solve(array);

    }

    private void solve(int[][] array) {
        setZeroes(array);
    }

    /**
     * complexity of this algorithm is O(1) and running time is O(m*n)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {


        /**
         * Whats is the algorithm ?
         * we will try to save the information of first row and first column in just two variable.
         *
         *
         */


        // declare two variable which will record the status of 0th row and 0th col.

        boolean rowStatus    =   false;
        boolean colStatus   =   false;


        // record the 0th row status
        for (int i  =   0;i < matrix[0].length ; i++) {
             if(matrix[0][i] == 0) {
                 rowStatus   =   true;
                 break;
             }
        }




        // record the 0th col status
        for (int i  =   0;i < matrix.length ; i++) {
            if(matrix[i][0] == 0) {
                colStatus   =   true;
                break;
            }
        }

        /**
         * so for we have updated 0th row and 0th col.
         * record the 0th pos and update status at 0th col and 0th row.
         */

        for(int i   =   1;i < matrix.length ; i++) {

            for(int j   =   1 ; j < matrix[0].length ; j++) {
                // if you found some pos having 0 as value.
                if(matrix[i][j] ==  0) {
                    matrix[i][0]    =   0;
                    matrix[0][j]    =   0;
                }

            }
        }


        /**
         * So for we have recorded all 0's of submatrix of size [M-1,N-1].
         * now lets update the rows and columns.
         */

        for(int i   =   1;i < matrix.length ; i++) {
            for(int j   =   1;j < matrix[0].length ; j++) {

                if(matrix[i][0] ==  0 || matrix[0][j]   ==   0) {
                    matrix[i][j]    =   0;
                }
            }
        }

        /**
         * now we are pending to update first row and first col.
         * so lest update 0th row and 0th col by using two variable ...rowStatus and colStatus.
         */

        if(rowStatus) {
            for(int i   =   0;i < matrix[0].length ; i++) {
                matrix[0][i]    =   0;
            }
        }

        if(colStatus) {
            for(int i   =   0;i < matrix.length ; i++) {
                matrix[i][0]    =   0;
            }
        }
    }
}
