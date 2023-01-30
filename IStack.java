import java.util.Vector;

public class IStack<E> {

    private Vector<E> VECTOR = new Vector<E>();

    public IStack() { // constructor
    }

    public int size() { // devuelve el tamaño del vector
        return VECTOR.size();
    }

    public void push(E item) { // agrega elemento al vector
        VECTOR.addElement(item);
    }

    public E pop() { // devuelve el ultimo valor agregado y lo elimina de la pila
        E tem;
        int size = VECTOR.size();
        tem = peek();
        VECTOR.removeElementAt(size - 1);
        return tem;
    }

    public E peek() { // devuelve el ultimo valor agregado
        int size = VECTOR.size();
        return VECTOR.elementAt(size - 1);
    }

    public boolean isEmpty() { // dice si esta vacio o no
        int size = VECTOR.size();
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}
