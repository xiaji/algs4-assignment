public class FixedCapacityStackOfStrings {
  private String[] a;
  private int n;

  public FixedCapacityStackOfStrings(int size) {
    a = new String[size];
  }

  public boolean isEmpty() {
    return (a == null || n == 0);
  }

  public boolean isFull() {
    return a.length == n;
  }

  public int size() {
    return n;
  }

  public void push(String s) {
    if(!isFull()) a[n++] = s;
    else System.out.println("The array is full.");
  }

  public String pop() {
    String result;
    if (!isEmpty()) {
      result = a[--n];
      a[--n] = null;
    } else {
      result = "The array is empty";
    }
    return result;
  }
}
