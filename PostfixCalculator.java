import java.util.ArrayList;
import java.util.Stack;

public class PostfixCalculator implements IPostfixCalculator {

    @Override
    public int suma(int a, int b) {
        return a + b;
    }

    @Override
    public int resta(int a, int b) {
        return b - a;
    }

    @Override
    public int multiplicacion(int a, int b) {
        return a * b;
    }

    @Override
    public int division(int a, int b) {
        return b / a;
    }

    @Override
    public ArrayList<String> getItems(String _expresion) {
        ArrayList<String> ar = new ArrayList<String>();
        for (int i = 0; i < _expresion.length(); i++) {
            ar.add(_expresion.charAt(i) + "");
        }
        return ar;
    }

    @Override
    public boolean isOneItem(IStack operandos) {
        if (operandos.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isOperator(String item) {
        boolean b = true;
        try {
            Integer.parseInt(item);
            b = false;
        } catch (Exception e) {
        }
        return b;
    }

}
