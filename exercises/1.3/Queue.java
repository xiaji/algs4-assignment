import java.util.Iterator;
import java.util.NoSuchElementException;

// Mistake: 1. enqueue, we should consider, there is no element in queue, then the first and last node refer to the same;
// 2. dequeue, we should consider when delete the last element in queue, the last node should be equal to null( or the first)

public class Queue<Item> implements Iterable<Item> {
  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  private Node<Item> first, last;
  private int n;

  public Queue() {
    first = last = null;
    // last = first;
    // first.next = last;
    n = 0;
  }

  public boolean isEmpty() {
    return n == 0 || first == null;
  }

  public int size() {
    return n;
  }

  public void enqueue(Item item) {
    Node<Item> oldLast = last;
    Node<Item> last = new Node<Item>();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
      // first.next = last;
    } else {
      oldLast.next = last;
      // last = temp;
    }
    n++;
  }

  public Item dequeue() {
    if (isEmpty()) throw new NoSuchElementException("The queue is empty now!");
    Item item = first.item;
    first = first.next;
    n--;
    // to avoid loitering
    if (isEmpty()) last = null;
    return item;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(Item item: this) {
      sb.append(item + "  ");
    }
    return sb.toString();
  }

  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException("The queue is empty now!");
    return first.item;
  }

  public Iterator<Item> iterator() {
    return new QueueList<Item>(first);
  }

  private class QueueList<Item> implements Iterator<Item> {
    private Node<Item> current;
    public QueueList(Node<Item> first) {
      current = first;
    }
    public boolean hasNext() { return current != null; }
    public Item next() {
      if (!hasNext()) throw new NoSuchElementException("No items!!!");
      Item item = current.item;
      current = current.next;
      return item;
    }
    public void remove() { throw new UnsupportedOperationException(); }
  }
  
}
