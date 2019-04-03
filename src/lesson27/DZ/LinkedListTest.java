package lesson27.DZ;

import java.util.Collection;
import java.util.LinkedList;

public class LinkedListTest<E> {
    public void useList() {
        LinkedList<Order> linkedList = new LinkedList<>();
        Order order = new Order(154235,123,"Dollar","Bridge","OP");
        linkedList.add(order);
        linkedList.add(0,order);
        linkedList.remove(0);
        linkedList.remove(order);
        linkedList.subList(0,1);
        linkedList.set(0,order);
        linkedList.contains(order);
        linkedList.toArray();
        linkedList.clear();

    }

    private void add(E e) {
        LinkedList<E> linkedList = new LinkedList<>();
        linkedList.add(e);
    }

    private void add(int index, E element) {
        LinkedList<E> linkedList = new LinkedList<>();
        linkedList.add(index, element);
    }

    private void remove(int index) {
        LinkedList<E> linkedList = new LinkedList<>();
        linkedList.remove(index);
    }

    private void remove(Object o) {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.remove(o);
    }

    private void addAll(Collection c) {
        LinkedList<Collection> linkedList = new LinkedList<>();
        linkedList.addAll(c);
    }

    private void subList(int fromIndex, int toIndex) {
        LinkedList<E> linkedList = new LinkedList<>();
        linkedList.subList(fromIndex, toIndex);
    }

    private void set(int index,E element) {
        LinkedList<E> linkedList = new LinkedList<>();
        linkedList.set(index, element);
    }

    private boolean contains(Object o) {
        LinkedList<Object> linkedList = new LinkedList<>();
        return linkedList.contains(o);
    }

    private Object[] toArray() {
        LinkedList<E> linkedList = new LinkedList<>();
        return linkedList.toArray();
    }

    private void clear() {
        LinkedList<E> linkedList = new LinkedList<>();
        linkedList.clear();
    }
}
