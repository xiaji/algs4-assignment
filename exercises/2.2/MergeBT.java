/**
 * Mergesort from bottom to top
 */

public class MergeBT {
  // private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    for (int sz = 1; sz < a.length; sz = sz + sz) {
      for (int lo = 0; lo < a.length - sz; lo += sz + sz)
        merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
    }
  }

  public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    int i = lo, j = mid + 1;
    // Comparable[] aux = new Comparable[a.length];
    // Mistake 1: merge is generally happened, unneccessary happend for the whole array
    // so use lo and hi instead
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    for (int k = lo; k <= hi; k++) {
      if (i > mid) a[k] = aux[j++];
      else if (j > hi) a[k] = aux[i++];
      else if (less(aux[j], aux[i])) a[k] = aux[j++];
      else a[k] = aux[i++];
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
}


