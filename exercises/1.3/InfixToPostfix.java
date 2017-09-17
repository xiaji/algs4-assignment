/** 1.3.10
 * 算术表达式从inorder转为postorder
 * advance: the answer of website does not cover a situation, more than 2 operands in parentheses
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.HashMap;

public class InfixToPostfix {
  private Stack<String> ops;
  private Map<String, Integer> opsPrecedence;

  public InfixToPostfix() {
    ops = new Stack<String>();
    opsPrecedence = new HashMap<>();
    opsPrecedence.put("(", 0);
    opsPrecedence.put("+", 1);
    opsPrecedence.put("-", 1);
    opsPrecedence.put("*", 2);
    opsPrecedence.put("/", 2);
  }

  private void precedence(String stackChar, String readChar, StringBuilder s) {
    if (opsPrecedence.get(stackChar) >= opsPrecedence.get(readChar)) s.append(ops.pop());
    ops.push(readChar);
  }

  public String conversion (String s) {
    if (s == null || s.length() == 0) return "";
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*') {
        String temp = s.charAt(i) + "";
        if (ops.isEmpty()) ops.push(temp);
        else this.precedence(ops.peek(), temp, result);
      } else if (s.charAt(i) == '(') ops.push("(");
      else if (s.charAt(i) == ')') {
        if (ops.isEmpty()) throw new NoSuchElementException("The stack is empty!");
        while(!ops.isEmpty()) {
          String op = ops.pop();
          if (op != "(") result.append(op);
          else break;
        }
      } else result.append(s.charAt(i) + "");
    }
    while(!ops.isEmpty()) result.append(ops.pop());
    return result.toString();
  }

  public static void main (String[] args) {
    InfixToPostfix test = new InfixToPostfix();
    while(!StdIn.isEmpty()) {
      String s = StdIn.readLine();
      StdOut.println(test.conversion(s));
    }
  }
}
