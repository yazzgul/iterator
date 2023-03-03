//package ru.itis.collections.list;
import java.util.Iterator;

public class CoolLinkedList<T> implements CoolList<T>, Iterable<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int count = 0;
    public Node<T> getFirst() {
        return first;
    }

    @Override
    public void add(T x) {
        if(last == null) {
            first = new Node<>(x);
            last = first;
            count++;
            return;
        }
        Node<T> node = new Node<>(x);
        last.next = node;
        last = node;
        count++;
    }

    @Override
    public void add(T x, int index) {
        if ((index == count) && (count != 0)) {
            Node<T> node = new Node<>(x);
            last.next = node;
            last = node;
        }
        if (index == 0) {
            first = new Node<>(x);
            last = first;
        }
        if ((index != 0) && (index!= count)) {
            Node<T> node = first;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            Node<T> nodeNew = new Node<>(x);
            Node<T> nodeOld = node.next;
//            nodeOld = index + 2
            nodeNew.next = nodeOld;
            node.next = nodeNew;
        }
        count++;
    }

    @Override
    public void set(T x, int index) {
        Node<T> node = first;
        for (int i = 0; i < index - 1 ; i++) {
            node = node.next;
        }
        Node<T> nodeNew = new Node<>(x);
        node.next = nodeNew;
    }

    @Override
    public T get(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public void remove(int index) {
        Node<T> node = first;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        Node<T> nodeRem = node.next;
        Node<T> nodeRemNext = nodeRem.next;
        node.next = nodeRemNext;
        nodeRem = null;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new CoolLinkedIterator<T> (this);
    }
    class CoolLinkedIterator<T> implements Iterator<T> {
        Node<T> current;
    CoolLinkedIterator(CoolLinkedList<T> obj) {
        current = obj.getFirst();
//        obj.getFirst()
//        cursor
    }
    public boolean hasNext() {
        return current != null;
    }
   public T next() {
        T d = current.value;
        current = current.next;
        return d;
    }

}
//class CoolLinkedIterator<T> implements Iterator<T> {
//    Node<T> current;
//    CoolLinkedIterator(CoolLinkedList<T> obj) {
//        current = obj.getFirst();
////        cursor
//    }
//    public boolean hasNext() {
//        return current != null;
//    }
//   public T next() {
//        T d = current.get();
//        current = current.next;
//        return d;
//    }
}