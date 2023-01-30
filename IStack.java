import java.util.Vector;

public class IStack<E> {

    private Vector<E> VECTOR = new Vector<E>();

    public IStack() {
    }

    public int size() {
        return VECTOR.size();
    }

    public void push(E item) {
        VECTOR.addElement(item);
    }

    public E pop() {
        E tem;
        int size = VECTOR.size();
        tem = peek();
        VECTOR.removeElementAt(size - 1);
        return tem;
    }

    public E peek() {
        int size = VECTOR.size();
        return VECTOR.elementAt(size - 1);
    }

    public boolean isEmpty() {
        int size = VECTOR.size();
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}
