package prj.clark.cs.dsa.struct.table;

/**
 * Allows 1 to 2 keys per node. Each node may have either 1 key and 2 kids, or 2 keys and 3 kids.
 * Single keys work as you would expect, while double keys have one child smaller than the smaller key, one child
 * greater than the greater key, and one child in between the values of the two keys.
 * @param <K>
 * @param <V>
 */
public class TwoThreeSymbolTable<K extends Comparable<K>, V> implements SymbolTable<K, V> {

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
