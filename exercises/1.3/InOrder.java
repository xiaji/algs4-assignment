/** 1.3.9
 *  缺少左括号，补全左括号后打印中序表达式
 *  中序表达式 同Tree的中序遍历
 * */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
//import edu.princeton.cs.algs4.Queue;
import java.util.NoSuchElementException;
// import java.lang.String;

public class InOrder {
  private Stack<String> ops;
  private Stack<String> vals;

  public InOrder() {
    ops = new Stack<String>();
    vals = new Stack<String>();
  }

  public String inOrderString(String s) {
    // String result = "";
    // Stack<String> temp = new Stack<String>();
    if (s == null || s.length() == 0) return "";
    for(int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' )
          ops.push(s.charAt(i) + "");
        else if (s.charAt(i) == ' ') { }
        else if (s.charAt(i) == ')') {
          if (ops.isEmpty() && vals.isEmpty()) throw new NoSuchElementException("No Element in stacks!!!");
          else {
            String lastOperator = ops.pop();
            String lastVal = vals.pop();
            String newLast = "(" + vals.pop() + lastOperator + lastVal + ")";
            // StdOut.println(newLast);
            vals.push(newLast);
          }
        } else {
          //String temp = s.charAt(i) + "";
          //StdOut.println(temp);
          vals.push(s.charAt(i) + "");
        }
    }
    return vals.pop();
  }

  public static void main (String[] args) {
    InOrder test = new InOrder();
    while(!StdIn.isEmpty()) {
      String s = StdIn.readLine();
      //StdOut.println(s.charAt(0));
      StdOut.println(test.inOrderString(s));
    }
  }
}

