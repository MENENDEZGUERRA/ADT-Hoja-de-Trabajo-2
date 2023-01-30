import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class PostfixEvaluator {
    public static void main(String[] args) {
        // Leer el archivo de texto
        try (BufferedReader br = new BufferedReader(new FileReader("postfix.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Evaluar la expresión postfix
                System.out.println("Resultado: " + evaluatePostfix(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int evaluatePostfix(String exp) {
        // Instanciacion de pila, vector y clase que implementa la interfaz dada
        PostfixCalculator pfc = new PostfixCalculator();
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<String> operandos = pfc.getItems(exp);

        // se recorren los elementos del vector
        for (String st : operandos) {
            if (!pfc.isOperator(st)) { // si es operando se hace push a la pila
                stack.push(Integer.parseInt(st));
            } else { // si es operador, se hacen pop a las ultimos 2 operandos y se operan
                     // apropiadamente
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch (st) { // switch case para la operación apropiada
                    case "+":
                        stack.push(pfc.suma(val1, val2));
                        break;
                    case "-":
                        stack.push(pfc.resta(val1, val2));
                        break;
                    case "*":
                        stack.push(pfc.multiplicacion(val1, val2));
                        break;
                    case "/":
                        stack.push(pfc.division(val1, val2));
                        break;
                }
            }
        }
        // El resultado final estará en la cima de la pila
        return stack.pop();
    }
}
