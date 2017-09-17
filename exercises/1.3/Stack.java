import java.util.Iterator;
import java.util.NoSuchElementException;

// Compated to src's Stack.java, missing: constructor method, toString()
// but closed to src's LinkedStack.java, except without considering underflow and assert check()

public class Stack<Item> implements Iterable<Item> {
  private class Node {
    private Item item;
    private Node next;
  }

  private Node first = new Node();
  private int n = 0;

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void push(Item item) {
    Node OldFirst = first;
    first = new Node();
    first.item = item;
    first.next = OldFirst;
    n++;
  }

  public Item pop() {
    // forgot the underflow!!!
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    Item item = first.item;
    first = first.next;
    n--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new StackItems();
  }

  private class StackItems implements Iterator<Item> {
    private Node temp = first;
    public boolean hasNext() { return temp != null; }
    public Item next() {
      // forgot underflow
      if (!hasNext()) throw new NoSuchElementException("No Items!!!");
      Item result = temp.item;
      temp = temp.next;
      return result;
    }
    public void remove() {
    }
  }

}
