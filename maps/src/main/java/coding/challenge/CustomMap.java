package coding.challenge;

import java.util.*;

/*
 *  Write a basic implementation of a map data structure that allows you to put,get,
 *  and remove values.You should have one method named put(K k,V v),one method
 *  named get(K k),and one method named remove(K k).
 * */
public final class CustomMap<K, V> {

    /*
     *  Create a class that wraps the key-value pair in a
     *  generic approach
     *  No Map with materializing an entry!
     *
     * */
    private final class CustomEntry<K, V> {
        private final K key;
        private V value;

        private CustomEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "CustomEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    @SuppressWarnings("unchecked")
    private CustomEntry<K, V>[] entries = new CustomEntry[DEFAULT_CAPACITY];

    public void put(K key, V value) {

        boolean success = true;

        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                entries[i].setValue(value);
                success = false;
            }
        }

        if (success) {
            checkCapacity();
            // add new map entry
            entries[size++] = new CustomEntry<>(key, value);
        }
    }

    /*
    *  Getting a value is done by key, if a value is found null is return
    * */
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null) {
                if (entries[i].getKey().equals(key)) {
                    return entries[i].getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        for(int i = 0; i < size; i++){
            if(entries[i].getKey().equals(key)){
                entries[i] = null;
                // reduce size by 1
                size--;
                condenseArray(i);
            }
        }
    }

    public Set<K> keySet(){
        Set<K> set = new HashSet<>();
        for(int i = 0; i < size; i++){
            set.add(entries[i].getKey());
        }
        return set;
    }

    public Collection<V> values(){
        // we use list because it allows duplicate
        List<V> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(entries[i].getValue());
        }
        return list;
    }

    private void condenseArray(int start){
        int i;
        for(i = start; i < size; i++){
            // shift remaining key-value
            entries[i] = entries[i + 1];
        }
        // last k-v to null;
        entries[i] = null;
    }

    private void checkCapacity() {
        if (size == entries.length) {
            int newSize = entries.length * 2;
            entries = Arrays.copyOf(entries, newSize);
        }
    }

}
