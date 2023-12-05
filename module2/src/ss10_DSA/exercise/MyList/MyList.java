package ss10_DSA.exercise.MyList;

public class MyList<E> {
    static final int DEFAULT_CAPACITY = 10;
    protected int size = 0;
    protected Object[] element;

    MyList() {
        this.size = 0;
        element = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > element.length)
            element = new Object[capacity];
    }

    void add(int index, E e) {
        if (size == element.length) {
            Object[] newArray = new Object[element.length * 2];
            for (int i = 0; i < element.length; i++) {
                newArray[i] = element[i];
            }
            element = newArray;
        }

        for (int i = size - 1; i >= index; i--) {
            element[i + 1] = element[i];
        }
        element[index] = e;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        E removedElement = (E) element[index];

        for (int i = index; i < size - 1; i++) {
            element[i] = element[i + 1];
        }

        element[size - 1] = null;
        size--;

        return removedElement;
    }

    public int size() {
        return size;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (element[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (element[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        add(size, e);
        return element[size - 1].equals(e);
    }

    public E get(int i) {
        return (E) element[i];
    }

    public void clear() {
        element = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
