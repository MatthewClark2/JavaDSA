package prj.clark.cs.dsa.struct.table;

// Useful for immutable data due to quick searching algorithms. Frequent changes are very expensive due to the nature of
// arrays.
public class ArraySymbolTable<K extends Comparable<K>, V> implements SymbolTable<K, V> {
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
