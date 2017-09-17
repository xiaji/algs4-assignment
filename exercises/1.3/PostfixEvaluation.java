/*
 * Evaluate Postfix Expression
 */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.NoSuchElementException;

public class PostfixEvaluation {
  private Stack<Double> vals;

  public PostfixEvaluation() {
    vals = new Stack<>();
  }

  public double evaluate(String s) {
    if (s == null || s.length() == 0) return Double.NaN;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '+' || s.charAt(i) == '/' || s.charAt(i) == '*' || s.charAt(i) == '-') {
        if (vals.isEmpty()) throw new NoSuchElementException("Stack is empty!!!");
        double val = vals.pop();
        if (s.charAt(i) == '/') val = vals.pop() / val;
        if (s.charAt(i) == '*') val = vals.pop() * val;
        if (s.charAt(i) == '+') val = vals.pop() + val;
        if (s.charAt(i) == '-') val = vals.pop() - val;
        vals.push(val);
      } else if (s.charAt(i) == ' ') { }
      else vals.push(Double.parseDouble(s.charAt(i) + ""));
    }
    return vals.pop();
  }

  public static void main(String[] args) {
    PostfixEvaluation test = new PostfixEvaluation();
    while(!StdIn.isEmpty()) {
      String s = StdIn.readLine();
      StdOut.println(test.evaluate(s));
    }
  }
}

