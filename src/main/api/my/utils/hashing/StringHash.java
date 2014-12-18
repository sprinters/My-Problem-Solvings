package main.api.my.utils.hashing;



public interface  StringHash {
    /**
     * This interface is the base interface of all the actvities involve in String matching via roll hashing
     * programmer are advise to use this interface as the base interface of all other concrete subclasses.
     */
    public long hash(int from, int to);
    public long reverseHash(int from, int to);
    public long[] getForwardKSizeHashes(int windowSize, int length);
    public long[] getReverseKSizeHashes(int windowSize, int length);
    public int length();
    public long[] getPrefixHashes();
    public long[] getSuffixHashes();
    public long[] getBaseArray();
}
