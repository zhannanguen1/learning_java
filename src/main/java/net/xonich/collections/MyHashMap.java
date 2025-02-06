package net.xonich.collections;

public class MyHashMap<K, V> {

    public static class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private final Node<K, V>[] hashTable = new Node[16];
    private float loadFactor = 0.75f;
    private int threshold = (int) (loadFactor * hashTable.length);

    private int bucket(K key) {

        return (key.hashCode() & 0x7FFFFFFF) % hashTable.length;
    }

    public void put(K key, V val) {

        if (size >= threshold) {
            reHash();
        }

        int bucket = bucket(key);
        Node<K, V> newNode = new Node<>(key, val);

        if (hashTable[bucket] != null) {
            Node<K, V> curr = hashTable[bucket];
            while (curr != null) {
                if (curr.key.equals(key)) {
                    curr.value = val;
                    return;
                }
                curr = curr.next;
            }
            newNode.next = hashTable[bucket];
        }
        hashTable[bucket] = newNode;
        size++;
    }

    public boolean contains(K key) {

        int bucket = bucket(key);

        Node<K, V> curr = hashTable[bucket];
        while (curr != null) {
            if (curr.key.equals(key)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public int size() {

        return size;
    }

    private void reHash() {

        int newCapacity = hashTable.length * 2;
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCapacity];

        Node<K, V>[] oldTable = hashTable;
        threshold = (int) (newCapacity * loadFactor);

        for (Node<K, V> head : oldTable) {
            while (head != null) {
                Node<K, V> next = head.next;
                int newBucket = bucket(head.key);
                head.next = newTable[newBucket];
                newTable[newBucket] = head;
                head = next;
            }
        }
    }
}
