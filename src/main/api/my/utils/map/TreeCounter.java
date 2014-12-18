package main.api.my.utils.map;


import java.util.HashMap;

public class TreeCounter<K> extends HashMap<K,Long> {

    public TreeCounter() {
        super();
    }
    //--------------------------------------------------------
    /**
     *
     * @param key
     */
    public void add(K key) {
        super.put(key,get(key) + 1);
    }

    //--------------------------------------------------------
    /**
     *
     */
    public void add(K key,long delta) {
        super.put(key,get(key) + delta);
    }

    //--------------------------------------------------------

    /**
     *
     * @param key
     * @return
     */
    public long getKey(int key) {
        if(containsKey(key)) {
            return super.get(key);
        }
        return 0l;
    }
}

