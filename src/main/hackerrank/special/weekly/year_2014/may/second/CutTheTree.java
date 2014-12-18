package main.hackerrank.special.weekly.year_2014.may.second;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CutTheTree {


    private static ArrayList<Integer>[] graph    =   null;
    private  static     int[] valueAt   =   null;
    private static      long[] sumAt     =   null;
    boolean[] isVisited                  =  null;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int vertexCount =   in.readInt();
        valueAt   = IOUtils.readIntArray(in,vertexCount);
        long vertexSum  = ArrayUtils.sumArray(valueAt);
        long minTreeDiff    =   Integer.MAX_VALUE;
        graph   =   new ArrayList[vertexCount + 10];
        for(int i   =   0;i < vertexCount+10 ; i++) {
            graph[i]    =   new ArrayList<Integer>();
        }




        sumAt    =   new long[vertexCount+10];
        isVisited   =   new boolean[vertexCount + 10];


        Arrays.fill(isVisited,false);
        for(int i   =   0;i < vertexCount-1 ; i++) {

            int from    =   in.readInt();
            int to      =   in.readInt();

            graph[from].add(to);
            graph[to].add(from);
        }

        int root    =   0;
        for(int i   =   0;i < graph.length ; i++) {
            if(graph[i].size() > 0) {
                root =   i;
                break;
            }
        }

        int oldRoot =   root;
        performDFS(root);
        Queue<Long> bfsQueue =   new LinkedList<Long>();
        bfsQueue.add(Long.valueOf(oldRoot));
        isVisited[oldRoot]  =   true;
        Arrays.fill(isVisited,false);
        while(!bfsQueue.isEmpty()) {
            long previousRoot    =   bfsQueue.poll();
            for(int child : graph[((int) previousRoot)]) {

                if(!isVisited[child]) {
                    minTreeDiff =   Math.min(minTreeDiff,Math.abs(2 *sumAt[child]-vertexSum));
                   // out.printLine("minTreeDiff::"+minTreeDiff);
                    bfsQueue.add(Long.valueOf(child));
                    isVisited[child]    =   true;
                }
            }

        }

        out.printLine(minTreeDiff);


    }


    public long performDFS(int root) {

        if(graph[root]  ==  null ) {
            return 0;
        }
        long childSum   =   0;
        isVisited[root] =   true;
        for(int child : graph[root]) {

            if(!isVisited[child]) {
                childSum   +=   performDFS(child);

            }
        }

        sumAt[root] = childSum + valueAt[root-1];
        return sumAt[root];

    }

}
