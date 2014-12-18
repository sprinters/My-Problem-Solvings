package main.spoj.classical;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Roads {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int coinCount   =   in.readInt();
        int cityCount   =   in.readInt();
        int roadCount   =   in.readInt();


        // what here state represent
        // state[i][j]---> length of the shortest path from vertex i to N having only j coin
        int[][] state   =   new int[cityCount+1][coinCount+1];
        int[][] distance    =   new int[cityCount+1][cityCount+1];
        int[][] cost        =   new int[cityCount+1][cityCount+1];
        ArrayUtils.fill(state, Integer.MAX_VALUE);

        List<Integer>[] graph   =   new ArrayList[cityCount+1];

        for(int i   =   0;i <= cityCount ; i++) {
            graph[i]    =   new ArrayList<Integer>();
        }


        for(int i   =   0;i < roadCount ; i++) {

            int from    =   in.readInt();
            int to      =   in.readInt();
            int dist    =   in.readInt();
            int toll    =   in.readInt();

            graph[from].add(to);
            distance[from][to]  =   dist;
            cost[from][to]      =   toll;
        }



        int shortestPath    =   go(graph,distance,cost,1,cityCount,coinCount,0);
        out.printLine(shortestPath);





    }

    private int go(List<Integer>[] graph, int[][] distance, int[][] cost,
                   int source, int destination, int availableCoin,int currentDistance) {
        if(availableCoin < 0) {
            return Integer.MAX_VALUE;
        }

        if(availableCoin    ==  0) {
            if(destination  ==  cost.length-1) {
                return currentDistance;
            }

            return Integer.MAX_VALUE;
        }

        for(int v : graph[source]) {

            currentDistance =   Math.min(currentDistance,
                    go(graph, distance, cost, v, destination, availableCoin-cost[source][v],
                            currentDistance+distance[source][v]));
        }

        return currentDistance;

    }
}
