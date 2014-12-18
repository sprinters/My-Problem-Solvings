package main.api.my.utils.map;

import main.api.my.collection.MyHashMap;

public class Indexer<K> extends MyHashMap<K,Integer> {

    private int index   =   0;

    //--------------------------------------------------

    /**
     *
     * @param key
     * @return
     */
    public Integer get(Object key) {
        if(!containsKey(key)) {
            super.put((K)key,index++);
        }

        return super.get(key);
    }

    //---------------------------------------------------

}
