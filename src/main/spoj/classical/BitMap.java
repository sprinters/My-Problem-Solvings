package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class BitMap {
    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {


        int rowCount    =   in.readInt();
        int colCount    =   in.readInt();


        char[][] table  =   IOUtils.readCharTable(in, rowCount, colCount);
        boolean[][] visitedStatus   =   new boolean[200][200];
        int[][] answer  =   new int[200][200];

        ArrayUtils.fill(visitedStatus, false);
//
//
//
//        Queue<MatrixNode<Integer,Integer,Integer>> myQueue  =
//                new LinkedList<MatrixNode<Integer,Integer,Integer>>();
//
//        //prepare queue for BFS traversal
//
//        for(int i   =   0;i < rowCount ; i++) {
//            for(int j   =   0; j < colCount ; j++) {
//
//                if(table[i][j]  ==  '1') {
//                    myQueue.add(MatrixNode.makeMatrixNode(i,j,0));
//                    visitedStatus[i][j] =   true;
//                    answer[i][j]    =   0;
//                }
//            }
//        }


        // doBFs now

//      //  int[][] array    =   doBFS(myQueue,table,visitedStatus,answer);
//
//
//        for(int i   =   0;i < rowCount ; i++) {
//            for(int j   =   0;j < colCount ; j++) {
//                out.print(array[i][j]+" ");
//            }
//
//            out.printLine();
//        }
    }


//    //--------------------------------------------------------------------------------------
//
//    /**
//     *
//     * @param queue
//     * @param inputTable
//     * @param visited
//     * @param answer
//     * @return
//     */
//    public int[][] doBFS(Queue<MatrixNode<Integer,Integer,Integer>> queue,char[][] inputTable,
//                         boolean[][] visited,int[][] answer) {
//
//        int[] dX    =   {-1,1,0,0};
//        int[] dY    =   {0,0,-1,1};
//        int rowCount    =   inputTable.length;
//        int colCount    =   inputTable[0].length;
//        while(!queue.isEmpty()) {
//
//            MatrixNode<Integer,Integer,Integer> currentNode =   queue.poll();
//
//            // traverse all possible neighbour of this node
//
//            for(int i   =   0; i < 4 ; i++) {
//
//                int row =   currentNode.getX() + dX[i];
//                int col =   currentNode.getY() + dY[i];
//
//                if(row >= 0 && row < rowCount && col>=0 && col<colCount && !visited[row][col]) {
//                    queue.add(MatrixNode.makeMatrixNode(row,col,currentNode.getD() + 1));
//                    visited[row][col]   =   true;
//                    answer[row][col]    =   currentNode.getD() + 1;
//                }
//            }
//
//        }
//        return answer;
//
//    }





}
