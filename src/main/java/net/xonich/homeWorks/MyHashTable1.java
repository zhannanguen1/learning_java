package net.xonich.homeWorks;

// Реализуйте простую хэш-таблицу, которая поддерживает методы put, get
public class MyHashTable1<K, V> {

    // Создать класс для связанного списка
    public class Node<K, V> {

        private K key;
        private V val;
        Node next;

        public Node(K key, V val) {

            this.key = key;
            this.val = val;
        }
    }

    // Переменные для хэш таблицы
    private Node[] table;
    private int capacity;

    public MyHashTable1(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
    }

    // метод добавления
    public void put(K key, V val) {

        int index = bucket(key);
        Node newNode = new Node<>(key, val);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node curr = table[index];
            while (curr.next != null && !curr.key.equals(key)) {
                curr = curr.next;
            }
            if (curr.key.equals(key)) {
                curr.val = val;
            } else {
                curr.next = newNode;
            }
        }
    }

    // метод получения
    public V get(K key) {
        int index = bucket(key);
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return (V) current.val;
            }
            current = current.next;
        }
        return null;
    }

    private int bucket (K key) {

        return Math.abs(key.hashCode() % table.length);
    }
}
