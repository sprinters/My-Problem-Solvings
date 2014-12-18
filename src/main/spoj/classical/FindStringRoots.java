package main.spoj.classical;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;
import main.api.my.utils.number.MyIntegerUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindStringRoots {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String input    =   in.readString();

        int lenCount    =   input.length();

        int answer      =   1;

        StringHash hasher   =   new ConcreteHasher(input,false);
        List<Pair<Long,Integer>> divisors   =   MyIntegerUtils.factorize(lenCount);

        divisors.add(Pair.makePair(1l,1));
        //out.printLine(divisors);

        for(Pair<Long,Integer> pp : divisors) {

            long p  =   pp.getFirst();
            Set<Long> lookUp =   new HashSet<Long>();
            int from    =   0;
            int to      = (int) (p-1);
            for(int i   =   0;i < (lenCount/p); i++) {
                long foundHash  =   hasher.hash(from,to);
                lookUp.add(foundHash);

                from    =   to+1;
                to      =  (int) (from + p - 1);

            }

            if(lookUp.size() == 1) {

                answer  = (int) Math.max(answer,lenCount/p);
            }
        }


        out.printLine(answer);
    }
}