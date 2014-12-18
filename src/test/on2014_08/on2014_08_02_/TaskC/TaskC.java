package test.on2014_08.on2014_08_02_.TaskC;



import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;

import java.util.*;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int personCount =   in.readInt();
        int coupleCount =   in.readInt();


        List<Integer>[] graph   =   new ArrayList[personCount];


        for(int j   =   0;j < graph.length ; j++) {
            graph[j]    =   new ArrayList<Integer>() ;
        }

        int[] from  =   new int[coupleCount];
        int[] to    =   new int[coupleCount];

        for(int j   =   0; j < coupleCount ; j++) {
            from[j] =   in.readInt();
            to[j]   =   in.readInt();
        }



        for(int i   =   0;i < coupleCount ; i++) {
            graph[from[i]].add(to[i]);
            graph[to[i]].add(from[i]);
        }

        Pair<Integer,Integer>[] array =   new Pair[personCount];

        for(int i   =   0;i < personCount ; i++) {
            if(i == 0) {
                array[i]    =   Pair.makePair(i,0);
                continue;
            }

            array[i]        =   Pair.makePair(i,Integer.MAX_VALUE);
        }


        Queue<Pair<Integer,Integer>> bfsQueue =   new LinkedList<Pair<Integer,Integer>>();

        boolean[] visited   =   new boolean[personCount];
        Arrays.fill(visited,false);

        bfsQueue.add(array[0]);

        while(!bfsQueue.isEmpty())  {


            Pair<Integer,Integer> parent    =   bfsQueue.poll();
            int vertexAt    =   parent.getFirst();
            if(!visited[vertexAt]) {
                for(Integer child : graph[vertexAt])  {

                    int best   =   Math.min(array[child].second,parent.getSecond() + 1);
                    Pair<Integer,Integer> bestPair  =   Pair.makePair(child,best);
                    bfsQueue.add(bestPair) ;
                    array[child]    =   bestPair;
                }
            }
            visited[vertexAt]   =   true;
        }

        String output   =   "";
        for(int i   =   1; i < array.length ; i++) {
            out.printLine(array[i].getSecond());
        }






    }
}
