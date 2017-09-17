/**
 * Evaluate algorithm is from textbook
 * 计算算术表达式，输入为中序inorder
 */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
  public static void main(String[] args) {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("(")) {  }
      else if (s.equals("+")) ops.push(s);
      else if (s.equals("-")) ops.push(s);
      else if (s.equals("*")) ops.push(s);
      else if (s.equals("/")) ops.push(s);
      else if (s.equals(")")) {
        double current = vals.pop();
        double temp = 0.0;
        String op = ops.pop();
        if (op.equals("+")) temp = vals.pop() + current;
        else if (op.equals("-")) temp = vals.pop() - current;
        else if (op.equals("*")) temp = vals.pop() * current;
        else if (op.equals("/")) temp = vals.pop() / current;
        vals.push(temp);
      } else {
        vals.push(Double.parseDouble(s));
      }
    }
    System.out.println(vals.pop());
  }
}
