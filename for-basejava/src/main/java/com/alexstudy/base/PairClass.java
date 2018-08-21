package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName PairUtil
 * @Description TODO()
 * @date 2018/7/27 16:17:32
 */
public class PairClass<K, V> {
    private K key;
    private V value;

    public PairClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}
