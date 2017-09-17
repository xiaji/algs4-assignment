/** 1.3.11
 * evaluate postorder
 *  */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import java.util.NoSuchElementException;
/*import java.util.Map;
import java.util.HashMap;*/

public class EvaluatePostfix {
  private Stack<Double> vals;
  // private Map<String, Integer> opsPrecedence;

  public EvaluatePostfix() {
    vals = new Stack<Double>();
  }

  public double evaluate (String s) {
    if (s == null || s.length() == 0) return Double.NaN;
    // double result;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*') {
        if (vals.isEmpty()) throw new NoSuchElementException("No Vals in store");
        else {
          double temp = vals.pop();
          if (vals.isEmpty()) throw new NoSuchElementException("No val to cal");
          else {
            if (s.charAt(i) == '+') temp = vals.pop() + temp;
            if (s.charAt(i) == '-') temp = vals.pop() - temp;
            if (s.charAt(i) == '*') temp = vals.pop() * temp;
            if (s.charAt(i) == '/') temp = vals.pop() / temp;
          }
          vals.push(temp);
        }
      } else vals.push(Double.parseDouble(s.charAt(i) + ""));
    }
    return vals.pop();
  }

  public static void main (String[] args) {
    EvaluatePostfix test = new EvaluatePostfix();
    while(!StdIn.isEmpty()) {
      String s = StdIn.readLine();
      StdOut.println(test.evaluate(s));
    }
  }
}

