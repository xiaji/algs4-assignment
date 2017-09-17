/* * 1.3.4
 * check the Parentheses, [{}[][][][()]] is true; [{] is false
 */
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;

public class ParenthesesMatch {
  public static void main(String[] args) {
    // int n = 1;
    Stack<String> temp = new Stack<String>();
    Map<String, String> match = new HashMap<String, String>();
    match.put("(", ")");
    match.put("{", "}");
    match.put("[", "]");
    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("(") || s.equals("[") || s.equals("{")) temp.push(s);
      // spaces
      else if (s.equals("\\s+")) { }
      else {
        // Mistake: need decide whether stack is empty
        String last = temp.peek();
        // Mistake: add contains key method
        String matchPar = match.get(last);
        if (s.equals(matchPar)) temp.pop();
        else temp.push(s);
      }
    }
    System.out.println(temp.isEmpty());
  }
}
