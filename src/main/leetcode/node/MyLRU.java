package main.leetcode.node;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * * @author sandeepandey
 */
public class MyLRU<K,V> {

    //polymorphism is always recommended
    private Map<K,V> myCacheMap   =   null;

    //argument based constructor

    public MyLRU(int suppliedCacheSize) {

        // we are overriding LinkedHashMap functionality to make it as cache map.
        // every time when a entry will be pushed ..we can monitor the given fact
        // that whether we have to update the cache or not.(by removing some entry)
        // this functionality is invoked while some put operation.
        this.myCacheMap =   new LinkedHashMap<K,V>(suppliedCacheSize){

            public boolean removeOldestEntry(Map.Entry<K,V> oldest) {

                // when you are expected to overflow with cache size
                // just remove the oldest entry

                return size() > suppliedCacheSize;
            }
        } ;
    }

    public synchronized void put(K key, V elem) {
        myCacheMap.put(key, elem);
    }

    public synchronized V get(K key) {
        return myCacheMap.get(key);
    }
}
