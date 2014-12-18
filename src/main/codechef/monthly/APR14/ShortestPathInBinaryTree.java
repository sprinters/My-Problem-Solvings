package main.codechef.monthly.APR14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class ShortestPathInBinaryTree {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int queryCount  =   in.readInt();

        for(int i=  0;i < queryCount ; i++) {
            int first       =   in.readInt();
            int second      =   in.readInt();

            int firstFromRoot     =   0;
            int secondFromRoot    =   0;
            int lcaFromRoot       =   0;
            int lcaAt               =   0;

            firstFromRoot         =   distanceFromRoot(first);
            secondFromRoot        =   distanceFromRoot(second);
            lcaAt                 =   getLCA(first,second);
            lcaFromRoot           =   distanceFromRoot(lcaAt);

            out.printLine(firstFromRoot+secondFromRoot-2*lcaFromRoot);
        }





    }


    public int distanceFromRoot(int tmpNode) {

        int count   =   0;
        while(tmpNode != 1) {
            count++;
            tmpNode=tmpNode>>1;
        }
        return count;

    }

    public int getLCA(int firstAt,int secondAt) {

        if(firstAt  ==  secondAt) {
            return firstAt;
        }

        if(firstAt > secondAt) {
            return getLCA(firstAt >> 1, secondAt);
        } else {
            return getLCA(firstAt, secondAt >> 1);
        }


    }
}
