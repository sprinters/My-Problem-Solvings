package main.codechef.lunchtime.july14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AndOperation {

    private static long minAnd  =   0;
    private static int maxAt    =   0;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int count   =   in.readInt();
        int[] array = IOUtils.readIntArray(in,count);

        int minAnd  =   goForTrie(array);
        out.printLine(minAnd);
    }

    private int goForTrie(int...array) {


        int index       =   -1;
        TrieNode root   =   new TrieNode('R',index);
        char[] tmp      =   new char[32];
        Arrays.fill(tmp,'0');
        performInsertion(root,tmp,0,index);
        for(int i   =   0;i < array.length ; i++) {


            Arrays.fill(tmp,'0');
            char[] bitAt    = Integer.toBinaryString(array[i]).toCharArray();
            for(int p   =   tmp.length-1, q =   bitAt.length-1; q >=0 ; p--,q--) {

                tmp[p]  =   bitAt[q];
            }

            query(root,tmp,0);


            minAnd  =   Math.max(minAnd,array[i] & (maxAt != -1 ? array[maxAt] : 0));

            //System.out.println("minAt::"+maxAt);
            performInsertion(root,tmp,0,++index);
        }

       return (int) minAnd;

    }
//---------------------------------------------------------------------------------

    /**
     *
     * @param array
     * @param root
     * @param start
     * @param index
     */
    public void performInsertion(TrieNode root,char[] array,int start,Integer index) {

        if(start < 0 || start >= array.length) {
            return;
        }

        // if this is leaf store the index part
        Map<Character,TrieNode> childs  =   root.getChilds();

        /**
         * look whether this root have element
         */

        TrieNode childNode  =   null;
        if(childs != null && !childs.isEmpty() && childs.containsKey(array[start])) {
            childNode   =   childs.get(array[start]);
        } else {
            root.addChild(array[start],index);
            childNode  =   root.getChild(array[start]);
        }
        performInsertion(childNode,array,start+1,index);

    }


    public void query(TrieNode root,char[] bitAt,int start) {

        if(start   ==   bitAt.length-1) {

            if(root != null) {
                maxAt   =   root.index;
                return;
            }

            throw new RuntimeException();
        }


        TrieNode withOne    =   root.getChild('1');
        TrieNode withZero   =   root.getChild('0');
        TrieNode    unknown =   null;
        if(bitAt[start] ==  '1') {

            if(withOne  !=  null) {
                unknown =   withOne;
            } else {
                unknown =   withZero;
            }
        } else {

            if(withZero  !=  null) {
                unknown =   withZero;
            } else {
                unknown =   withOne;
            }
        }

        query(unknown,bitAt,start+1);
    }

    private static class TrieNode {

        private Character identity   =  null;
        private Integer index               =   0;

        private Map<Character,TrieNode> childMap    =   null;

        public TrieNode(Character identity,Integer index) {

            this.identity   =   identity;
            childMap        =   new HashMap<Character,TrieNode>();
            this.index      =   index;
        }

        public Character getIdentity() {
            return identity;
        }

        public Map<Character,TrieNode> getChilds() {
            return this.childMap;
        }


        public void addChild(Character identity,Integer index) {
            TrieNode freshNode   =   new TrieNode(identity,index);
            this.childMap.put(identity,freshNode);

        }

        public TrieNode getChild(Character identity) {
            return childMap.get(identity);
        }

        public Integer getIndex() {
            return index;
        }

        public String toString() {
            return "("+identity+", "+index+","+childMap+")" ;
        }

    }
}
