package main;

import main.api.my.pair.Pair;

import java.util.*;

public class MoneyExchange {
    public double bestRate(String[] rates, String type1, String type2) {


        if(rates == null || rates.length == 0) {
            return Double.valueOf(-1);
        }


        String[] from   =   new String[rates.length];
        String[] to     =   new String[rates.length];
        Double[] cost   =   new Double[rates.length];

        int initial     =   -1;

        for(int i   =   0;i < rates.length ; i++) {

            String[] array  =    rates[i].split(" ");
            from[i]         =   array[0];
            to[i]           =   array[2];
            cost[i]         =   Double.valueOf(Double.valueOf(array[3])/Double.valueOf(array[1]));
        }


        Map<String,Integer> nameIdMap   =   new HashMap<>();

        for(int i   =   0;i < rates.length ; i++) {

            if(!nameIdMap.containsKey(from[i])) {
                initial++;
                nameIdMap.put(from[i],initial);
            }

            if(!nameIdMap.containsKey(to[i])) {
                initial++;
                nameIdMap.put(to[i],initial);
            }
        }


        if(!nameIdMap.containsKey(type1)) {
            initial++;
            nameIdMap.put(type1,initial);
        }




        if(!nameIdMap.containsKey(type2)) {
            initial++;
            nameIdMap.put(type2,initial);
        }
        // now try to build graph

        ArrayList<Integer>[] graph  =   new ArrayList[nameIdMap.size() + 1];

        for(int j   =   0;j < graph.length ; j++) {
            graph[j]    =   new ArrayList<Integer>();
        }



        // add childs

        for(int j   =   0;j < rates.length; j++) {

            int u   =   nameIdMap.get(from[j]);
            int v   =   nameIdMap.get(to[j]);
            graph[u].add(v);

        }


        Map<Pair<Integer,Integer>,Double> costMap  =   new HashMap();

        for(int i   =   0;i < from.length ; i++) {

            Pair<Integer,Integer> workingPair   =   Pair.makePair(nameIdMap.get(from[i]),nameIdMap.get(to[i]));
            costMap.put(workingPair,cost[i]);
        }


        Queue<Integer> bfsQueue =   new LinkedList<>();



        double[] distance  =   new double[nameIdMap.size()];
        boolean[] visited   =   new boolean[nameIdMap.size()];


        Arrays.fill(distance,Integer.MIN_VALUE);
        Arrays.fill(visited,false);

        int source   =   nameIdMap.get(type1);
        int destination  =   nameIdMap.get(type2);


        distance[source]    =   1;
        bfsQueue.add(source);

        while(!bfsQueue.isEmpty())  {

            int parent   =   bfsQueue.poll();

            if(visited[parent]) {
                continue;
            }
            for(int child : graph[parent]) {
                Pair<Integer,Integer> localPair =   Pair.makePair(parent,child);

                distance[child]  =   Math.max(distance[child],distance[parent] * costMap.get(localPair));
                bfsQueue.add(child);
            }
            visited[parent]  =   true;

        }


        if(distance[destination]    < 0) {
            return Double.valueOf(-1.0);
        }

        return distance[destination];
    }
}
