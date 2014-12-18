package main.api.my.utils.hashing;


public class ConcreteHasher extends SimpleStringHash {

    public ConcreteHasher(String input,boolean isReverseRequired) {
       super(input,isReverseRequired);
    }
    @Override
    public long hashFunction(long previousHash, char currentChar, int subtractor, long multiplier) {
        return (previousHash * multiplier + currentChar-subtractor);
    }
    @Override
    public long[] getForwardKSizeHashes(int windowSize,int length) {

        int hashCount   =   length-windowSize+1;
        long[] hashes   =   new long[hashCount];
        for(int i   =   0;i <( hashCount ); i++) {
            hashes[i]   =   hash(i,i+windowSize-1);
        }
        return hashes;
    }
    @Override
    public long[] getReverseKSizeHashes(int windowSize,int length) {
        int hashCount   =   length-windowSize+1;
        long[] hashes   =   new long[hashCount];
        for(int i   =   0;i <( hashCount ); i++) {
            hashes[hashCount-i-1]   =   reverseHash(length-i-1,length-i-windowSize);
        }
        return hashes;

    }

}
