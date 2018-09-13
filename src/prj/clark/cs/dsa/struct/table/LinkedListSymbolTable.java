package prj.clark.cs.dsa.struct.table;

public class LinkedListSymbolTable<K extends Comparable<K>, V> implements SymbolTable<K, V> {
    private class LinkedListSymbolTableNode {
        private K key;
        private V value;
        LinkedListSymbolTableNode next;
    }

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
