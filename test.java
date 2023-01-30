import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class test {

    // Test para pila

    @org.junit.Test
    public void push() { // test para push
        IStack<Integer> st = new IStack<Integer>();
        st.push(1);
        assertEquals(1, st.peek().intValue());
        st.push(2);
        assertEquals(2, st.peek().intValue());
    }

    @org.junit.Test
    public void isEmpty() { // test para isEmpty
        IStack<Integer> st = new IStack<Integer>();
        assertEquals(true, st.isEmpty());
        st.push(1);
        assertEquals(false, st.isEmpty());
    }

    @org.junit.Test
    public void pop() { // test para pop
        IStack<Integer> st = new IStack<Integer>();
        st.push(1);
        st.push(2);
        assertEquals(2, st.pop().intValue());
        assertEquals(1, st.peek().intValue());
    }

    // Test para calculadora

    @org.junit.Test
    public void PostfixCalculator() { // operaciones
        PostfixCalculator pfc = new PostfixCalculator();
        // SUMA
        assertEquals(5, pfc.suma(3, 2));
        assertEquals(-3, pfc.suma(-9, 6));
        // MULT
        assertEquals(15, pfc.multiplicacion(3, 5));
        assertEquals(-3, pfc.multiplicacion(3, -1));
        // RESTA (se opera como b - a)
        assertEquals(2, pfc.resta(3, 5));
        assertEquals(-4, pfc.resta(6, 2));
        // DIV (se opera como b / a)
        assertEquals(3, pfc.division(10, 30));
        assertEquals(4, pfc.division(3, 12));
    }

    @org.junit.Test
    public void getItems() { // getItems
        PostfixCalculator pfc = new PostfixCalculator();
        ArrayList<String> ar = pfc.getItems("ABC");
        assertEquals("A", ar.get(0));
        assertEquals("B", ar.get(1));
        assertEquals("C", ar.get(2));
    }

    @org.junit.Test
    public void isOneItem() { // isOneItem
        PostfixCalculator pfc = new PostfixCalculator();
        IStack<Integer> st = new IStack<Integer>();
        st.push(1);
        assertEquals(true, pfc.isOneItem(st));
        st.push(2);
        assertEquals(false, pfc.isOneItem(st));
    }

    @org.junit.Test
    public void isOperator() { // getItems
        PostfixCalculator pfc = new PostfixCalculator();
        assertEquals(true, pfc.isOperator("+"));
        assertEquals(true, pfc.isOperator("-"));
        assertEquals(false, pfc.isOperator("1"));
        assertEquals(false, pfc.isOperator("3"));
    }
}