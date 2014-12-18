package main.api.my.utils.map;

import main.api.my.collection.MyHashMap;
import main.api.my.utils.mis.factory.Factory;

public class MyFactoryBasedHashMap<K,V> extends MyHashMap<K,V> {

    private Factory<V> defaultValueFactory  =   null;

    //----------------------------------------------------------------

    /**
     *
     * @param defaultValueFactory
     */
    public MyFactoryBasedHashMap(Factory<V> defaultValueFactory) {
        this.defaultValueFactory    =   defaultValueFactory;
    }

    //---------------------------------------------------------------

    /**
     *
     * @param key
     * @return
     */
    public V get(Object key) {

        if(containsKey(key)) {
            super.get(key);
        }

        V value =   defaultValueFactory.create();

        try {
            super.put((K)key,value);
            return value;
        } catch(ClassCastException cce) {
            cce.printStackTrace();;
            return value;
        }
    }

    //---------------------------------------------------------
}
