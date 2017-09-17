/**
 * practise how to construct an expression tree
 * node has val and left, right node
 */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ExpressionTree {
  private class Node {
    char value;
    Node left, right;

    public Node(char item) {
      value = item;
      left = right = null;
    }
  }

  private boolean isOperator(char c) {
    if (c == '+' || c == '-' || c == '*' || c == '/') return true;
    return false;
  }

  private void inorder(Node t) {
    if (t != null) {
      inorder(t.left);
      StdOut.println(" " + t.value + " ");
      inorder(t.right);
    }
  }

  // Return root of constructed tree for given postfix expression
  // postfix root is the last char
  // prefix root is the first char
  public Node construcedTree(String s) {
    Stack<Node> sTree = new Stack<>();
    Node t, t1, t2;
    if (s == null || s.length() == 0) return new Node(Character.MIN_VALUE);
    for (int i = 0; i < s.length(); i++) {
      if (!isOperator(s.charAt(i))) {
        t = new Node(s.charAt(i));
        sTree.push(t);
      } else {
        t = new Node(s.charAt(i));
        t1 = sTree.pop();
        t2 = sTree.pop();
        t.right = t1;
        t.left = t2;
        sTree.push(t);
      }
    }
    t = sTree.peek();
    sTree.pop();
    return t;
  }

  public static void main (String[] args) {
    ExpressionTree test = new ExpressionTree();
    while (!StdIn.isEmpty()) {
      String s = StdIn.readLine();
      // String.toCharArray();
      StdOut.println(test.constructedTree(s));
      StdOut.println("Infix expression is ");
      test.inorder(test.constructedTree(s));
    }
  }
}
