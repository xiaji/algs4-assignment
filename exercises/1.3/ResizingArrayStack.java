import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
  // avoid to consider a == null
  private Item[] a = (Item[]) new Obejct[1];
  // explicit initialize instance variables
  private int n = 0;

  public boolean isEmpty() {
    // a.length may not be == 0, we should use n,
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void resize(int size) {
    /*if (a == null || a.length == 0) a = (Item[]) new Object[size];
    else {
      Item[] b = a;
      a = (Item[]) new Object[size];
      for (int i = 0; i < b.length; i++) {
        if (b[i] != null) a[i] = b[i];
      }
    }*/
    Item[] temp = (Item[]) new Object[size];
    for(int i = 0; i < n; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item) {
    if (a.length == n) {
      resize(2*n);
      // a[n++] = item;
    }
    a[n++] = item;
  }

  public Item pop() {
    Item b;
    if (n == 0) {
      System.out.println("The stack is empty, pls push new element");
    } else {
      b = a[--n];
      // Mistake: --n is already the index you pop;
      // so we should set the index is null, not --n again!!!
      a[n] = null;
      // Trick!!!
      if (n == a.length / 4) resize(a.length / 2);
    }
    return b;
  }

  // java.lang.Iterable
  // public interface Iterable<Item> {
  // Iterator<Item> iterator();
  // }
  public Iterator<Item> iterator() {
    return new ArrayIterator();
  }

  //java.util.Iterator
  //public interface Iterator<Item> {
  //boolean hasNext();
  //Item next();
  //void remove();
  //Collection Type do iterate Template:
  //Iterator<Item> item = map.iterator();
  //while(item.hasNext()) item.next();
  private class ArrayIterator implements Iterator<Item>{
    private int i = n;
    public boolean hasNext() {
      // next will run --, it maybe negative #; so the condition is > 0
      return i > 0;
    }
    public Item next() {
      return a[--i];
    }
    public void remove() {
    }
  }
}
