package com.alexstudy.base;

/**
 * @author AlexTong
 * @ClassName OrderedPair
 * @Description TODO()
 * @date 2018/7/26 18:03:13
 */
public class OrderedPair<K,V> implements Pair<K,V> {
        private K key;
        private V value;

        public OrderedPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey()	{ return key; }
        public V getValue() { return value; }
}
