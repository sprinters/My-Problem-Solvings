package main.hackerearth.adobe;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Commander {
    private static int MAX_VERTEX   =   110000;
    private static List<Integer>[] graph       =   new ArrayList[MAX_VERTEX];
    private long[] heightAt =   new long[MAX_VERTEX];
    static  {
        for(int i   =   0;i < MAX_VERTEX ; i++){
             graph[i]   =   new ArrayList<Integer>();
        }
    }
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        for(List<Integer> l :graph) {
            l.clear();
        }

        Arrays.fill(heightAt,-1);
        int soldierCount    =   in.readInt();
        int[] parents       = IOUtils.readIntArray(in,soldierCount);
        int qtyCount        =   in.readInt();
        int[] from  =       new int[qtyCount];
        int[] to            =   new int[qtyCount];

        for(int i   =   0;i < qtyCount ; i++) {
            from[i] =   in.readInt();
            to[i]   =   in.readInt();

        }

        for(int i   =   0;i < parents.length ; i++) {
            graph[parents[i]].add(i+1);
        }

        performDFS(0,0);

        for(int i   =   0;i < qtyCount ; i++) {

            if(from[i]  ==  to[i]) {
                out.printLine(-1);
                continue;
            }

            if(isParent(from[i],to[i],parents)) {


                out.printLine(Math.abs(heightAt[from[i]]-heightAt[to[i]]) -1);
            }  else {
                out.printLine(-1);
            }
        }

    }

    private void performDFS(int start,int currentHeight) {

        if(start < 0) {
            return;
        }
        Iterator<Integer> it=graph[start].iterator();
        heightAt[start] =   currentHeight;

        while(it.hasNext()) {
            performDFS(it.next(), currentHeight + 1);
        }
        return;

    }


    private boolean isParent(int x,int targetParent,int[] parents) {

        if( (heightAt[x]-heightAt[targetParent]) == targetParent) {
            return true;
        }
        return false;

    }
}
