package main.api.my.tree.prefixtree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * * @author sandeepandey
 */
public class BitBasedPrefixTree {


    public static TrieNode buildTree(int[] array) {

        TrieNode root   =   new TrieNode(' ',0);
        char[] tmpArray    =   new char[33];
        int index       =   0;
        for(Integer i : array) {
            Arrays.fill(tmpArray, '0');

            String bits =   Integer.toBinaryString(i);

            for(int j       =   bits.length()-1,k = tmpArray.length-1 ; j >=0 ; j--,k--) {
                tmpArray[k] =   bits.charAt(j);
            }
            performInsertion(tmpArray, root, 0, index);
            index++;
        }

        return root;

    }


    public static void performInsertion(char[] array,TrieNode root,int start,Integer index) {

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
        performInsertion(array,childNode,start+1,index);

    }


    //-------------------------------------------------------------------------

    /**
     *
     * @param bitAt
     * @param root
     * @param start
     * @return
     */
    private void processQuery(char[] bitAt, TrieNode root,int start) {

        if(start    ==  (bitAt.length-1)) {

            if(root != null) {
     //           maxAt   =   root.getIndex();
                return;

            }
            throw new RuntimeException();
        }

        TrieNode nodeWithOne    =   root.getChild('1');
        TrieNode nodeWithZero   =   root.getChild('0');


        if(bitAt[start] ==  '1') {

            if(nodeWithZero != null) {
                processQuery(bitAt, nodeWithZero, start+1);
            } else if(nodeWithOne != null) {
                processQuery(bitAt, nodeWithOne, start + 1);
            }
        } else {

            if(nodeWithOne != null) {
                processQuery(bitAt, nodeWithOne, start+1);
            } else if(nodeWithZero != null) {
                processQuery(bitAt, nodeWithZero, start + 1);
            }

        }
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
