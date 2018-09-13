package prj.clark.cs.dsa.struct.table;

public interface SymbolTable<K extends Comparable<K>, V> {
    void put(K key, V value);
    V get(K key);
    boolean contains(K key);
    void delete(K key);
    void clear();
    int getSize();
    boolean isEmpty();
}
