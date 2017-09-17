public class ShellSort {
  public static void sort(Comparable[] a) {
    int n = a.length;
    int h = 1;
    // divide the array into three pieces
    while (h < n/3) h = h * 3 + 1;
    while (h >= 1) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
           exch(a, j, j-h);
        }
      }
      h = h / 3;
    }
  }

  public static boolean less(Comparable w, Comparable v) {
    return w.compareTo(v) < 0;
  }

  public static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i-1])) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String[] a = In.readStrings();
    sort(a);
    assert(isSorted(a));
    show(a);
  }
}

