package main.codeforces.practice.hashing;

import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;
import net.egork.chelper.util.InputReader;

public class TrainAndPeter {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        boolean a   =   false;
        boolean b   =   false;
        boolean c   =   false;
        boolean d   =   false;
        String input    =   in.readString();
        String firstSeq =   in.readString();
        String secondSeq    =   in.readString();

        int lenCount    =   input.length();
        int firstSeqCount   =   firstSeq.length();
        int secondSeqCount  =   secondSeq.length();

        StringHash mainHasher   =   new ConcreteHasher(input,true);
        StringHash firstHasher  =   new ConcreteHasher(firstSeq,true);
        StringHash secondHasher =   new ConcreteHasher(secondSeq,true);

        long firstFwdHash       =   firstHasher.hash(0,firstSeqCount-1);
        long secondFwdHash      =   secondHasher.hash(0,secondSeqCount-1);
        int firstFoundAt = Integer.MIN_VALUE,secondFoundAt= Integer.MIN_VALUE;

        long[] hashArray    =   mainHasher.getForwardKSizeHashes(firstSeqCount,lenCount);
        for(int i   =   0;i < hashArray.length ; i++) {
            if(hashArray[i]==firstFwdHash) {
                firstFoundAt    =   i+firstSeqCount-1;
                break;
            }
        }
        hashArray       =   mainHasher.getForwardKSizeHashes(secondSeqCount,lenCount);

        for(int i   =   0;i < hashArray.length ; i++) {
            if(hashArray[i]==secondFwdHash) {
                secondFoundAt    =   i;
            }
        }
        int firstFixAt  = Integer.MIN_VALUE,secondFixAt=Integer.MIN_VALUE;

        long[] revHashArray =   mainHasher.getReverseKSizeHashes(firstSeqCount,lenCount);
        for(int i   =   revHashArray.length-1;i>=0 ; i--) {
            if(revHashArray[i]==firstFwdHash) {
                firstFixAt    =   i-secondSeqCount+1;
                break;
            }
        }

        revHashArray    =   mainHasher.getReverseKSizeHashes(secondSeqCount,lenCount);
        for(int i   =   revHashArray.length-1;i >=0 ; i--) {
            if(revHashArray[i]==secondFwdHash) {
                secondFixAt    =   i;

            }
        }
       if( firstFoundAt == Integer.MIN_VALUE || secondFoundAt == Integer.MIN_VALUE || (firstFoundAt >= secondFoundAt)) {
            a = false;
        }   else if(secondFoundAt > firstFoundAt) {
            a = true;
        }

        if(firstFixAt   ==  Integer.MIN_VALUE || secondFixAt == Integer.MIN_VALUE || (secondFixAt>=firstFixAt)){
              b=false;
        }  else {
            b   =   true;
        }

        if(a && b) {
            out.printLine("both");
        } else if(a && !b) {
            out.printLine("forward");
        } else if(!a && b) {
            out.printLine("backward");
        }  else {
            out.printLine("fantasy");
        }

    }
}
