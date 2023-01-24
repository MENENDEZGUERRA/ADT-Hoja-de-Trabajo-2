import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        // Crear una pila para almacenar los valores
        Stack<Integer> stack = new Stack<>();

        // Recorrer cada caracter en la expresión
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // Si el caracter es un número, agregarlo a la pila
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                // Si el caracter es un operador, obtener los dos últimos valores de la pila
                int val1 = stack.pop();
                int val2 = stack.pop();

                // Realizar la operación y agregar el resultado a la pila
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }

        // El resultado final estará en la cima de la pila
        return stack.pop();
    }
}
