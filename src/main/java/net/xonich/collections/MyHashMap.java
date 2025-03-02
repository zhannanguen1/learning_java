package net.xonich.collections;

public class MyHashMap<K, V> {

    private static class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private Node<K, V>[] hashTable = new Node[16];
    private float loadFactor = 0.75f;
 //toDO вычислять "на лету". Написать функцию для определения порога rehashIfNeeded

    private int rehashIfNeeded() {

        return (int) (loadFactor * hashTable.length);
    }

    private int bucket(K key) {

        return Math.abs(key.hashCode() % hashTable.length);
    }

    public V put(K key, V val) { //toDO долж возвр V (старое значение). Если значение заменяем, то возвр старое. Если уникальное, то null

        if (size >= rehashIfNeeded()) {
            reHash();
        }

        int bucket = bucket(key);

        if (hashTable[bucket] != null) {
            Node<K, V> curr = hashTable[bucket];
            while (curr != null) {
                if (curr.key.equals(key)) {
                    V oldVal = curr.value;
                    curr.value = val;
                    return oldVal;
                }
                curr = curr.next;
            }
        }

        Node<K, V> newNode = new Node<>(key, val);
        newNode.next = hashTable[bucket];
        hashTable[bucket] = newNode;
        size++;
        return null;
    }

    //toDo get() Если знач есть, то его. Иначе null

    public V get(K key) {
        int bucket = bucket(key);
        Node<K, V> curr = hashTable[bucket]; //
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    //toDO replace(). Не может созд нов пару. Всегда заменяет сущ-ю
    public V replace(K key, V val) {

        int bucket = bucket(key);

        Node<K, V> curr = hashTable[bucket];
        while (curr != null) {
            if (curr.key.equals(key)) {
                V oldValue = curr.value;
                curr.value = val;
                return oldValue;
            }
            curr = curr.next;
        }
        return null;
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

        hashTable = newTable;

        for (Node<K, V> curr : oldTable) {
            while (curr != null) {
                Node<K, V> next = curr.next;
                int newBucket = Math.abs(curr.key.hashCode() % newCapacity);
                curr.next = newTable[newBucket];
                newTable[newBucket] = curr;
                curr = next;
            }
        }
    }
}
