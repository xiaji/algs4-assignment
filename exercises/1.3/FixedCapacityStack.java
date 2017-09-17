public class FixedCapacityStack<Item> {
  private Item[] a;
  private int n = 0;

  // Set/LinkedList to primitive type Array
  // Set<Item> set = new HashSet<Item>();
  // Object[] obj = set.toArray();
  // int[] temp = new int[obj.length];
  // for(int i = 0; i < obj.length; i++) {
  // temp[i] = (int) obj[i];
  // }
  // Warning: the following when runing this code, it will throw ClassCastException(Unchecked Cast);
  // the above is a better way to avoid warning.
  public FixedCapacityStack(int s) {
    a = (Item[]) new Object[s];
  }

  public boolean isEmpty() {
    return a == null || n == 0;
  }

  public int size() {
    return n;
  }

  public void push(Item item) {
    if(a.length == n) {
      System.out.println("The Array is full!, you need pop one element first.");
    } else {
      a[n++] = item;
    }
  }

  public Item pop() {
    return a[--n];
  }
}
