//package ru.itis.collections.list;
import java.util.Iterator;

public class CoolArrayList<T> implements CoolList<T>, Iterable<T> {
    private Object[] array = new Object[2];
    private int count = 0;

    @Override
    public void add(T x) {
        array[count] = x;
        count++;
        if (count == array.length) {
            grow();
        }
    }

    @Override
    public void add(T x, int index) {
        System.out.println("ДОБАВЛЕНИЕ НОВОГО ЭЛЕМЕНТА В МАССИВ ПУТЕМ ПЕРЕСТАНОВКИ");
        T p = (T) array[index];
        array[index] = x;
        Object[] oldArray = array;
        array = new Object[oldArray.length + 1];
        //        int p = oldArray[index];
        //        oldArray[index] = x;
        for (int i = 0; i <= index; i++) {
            array[i] = oldArray[i];
        }
        array[index + 1] = p;
        for (int i = index + 1; i < oldArray.length; i++) {
            array[i + 1] = oldArray[i];
        }
        count++;
    }

    @Override
    public void set(T x, int index) {
        array[index] = x;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        cut();
    }

    @Override
    public void clear() {
        Object[] oldArray = array;
        array = new Object[oldArray.length];
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    private void grow() {
        System.out.println("ПЕРЕСОЗДАНИЕ МАССИВА");
        Object[] oldArray = array;
        array = new Object[oldArray.length * 2];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }

    private void cut() {
        System.out.println("УМЕНЬШЕНИЕ МАССИВА");
        Object[] oldArray = array;
        array = new Object[oldArray.length - 1];
        for (int i = 0; i < oldArray.length - 1; i++) {
            array[i] = oldArray[i];
        }
    }

    public Iterator<T> iterator() {
        return new CoolArrayIterator<T>();
//                                    (this)
    }

    class CoolArrayIterator<T> implements Iterator<T> {
        T current;
        int index = 0;
//        CoolArrayList<T> obj;

        CoolArrayIterator() {
            current = (T) array[0];
        }

        public boolean hasNext() {

            return current != null;
        }

        public T next() {
            T d = current;
            index++;
            current = (T) array[index];
            return d;
        }
    }
}
