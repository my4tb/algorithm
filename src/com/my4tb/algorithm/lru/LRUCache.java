package com.my4tb.algorithm.lru;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * least recently used
 * 采用双链表
 * 最常用到的数据放在链表尾端，最常不使用的数据放在链表头部
 *
 * 当set一个值和get一个值时，都要将这个元素移动到链表尾部
 *
 * 实现不对，暂时没改
 */
public class LRUCache<K, V> {

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    private static class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> pre;
        private Node<K, V> next;

        Node() {}

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private int capacity;

    private Map<K, Node<K, V>> cached;

    private Node<K, V> head = new Node<>();

    private Node<K, V> tail = new Node<>();

    public LRUCache(int capacity) {
        if (capacity <= 0)
            throw new RuntimeException("capacity can not less than 1");
        this.capacity = capacity;
        cached = new ConcurrentHashMap<>();
        head.next = tail;
        tail.pre = head;
    }

    public void put(K key, V value) {
        if (cached.containsKey(key))
            cached.get(key).value = value;
        else {
            /*
                容量已满，删除头部节点，然后再添加新节点
             */
            if (cached.size() == capacity) {
                cached.remove(head.next.key);
                head.next.next.pre = head;
                head.next = head.next.next;
            }
            Node<K, V> newNode = new Node<>(key, value);
            newNode.pre = tail.pre;
            newNode.next = tail;
            tail.pre.next = newNode;
            tail.pre = newNode;
            cached.put(key, newNode);
        }
    }

    public V get(K key) {
        return cached.containsKey(key) ? cached.get(key).value : null;
    }


}
