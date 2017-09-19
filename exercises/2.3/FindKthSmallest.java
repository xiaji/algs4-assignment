// the partition method in quicksort,
// not only find the index of a partition element, 
// also find the j + 1 th smallest element in the array.
public class FindKthSmallest {
  // Median-of-3, find the partition element, return the index of the median element
  private static int median3(Comparable[] a, int i, int j, int k) {
    return (less(a[i], a[j]) ?
      (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
      (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    int mid = lo + (j - i) / 2;
    int vIndex = median3(a, lo, lo + mid, hi);
    exch(a, lo, vIndex);
    Compapable v = a[lo];
    while (true) {
      while (less(a[++i], v)) if (i == hi) break;
      while (less(v, a[--j])) if (j == lo) break;
      if (i >= j) break;
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }

  public static Comparable find(Comparable[] a, int lo, int hi, int kth) {
    // Mistake 1: IllegalArgumentException condition
    // how about a lot same elements, they have the same kth or not?
    if (kth <= 0 || kth > hi - lo + 1) throw new IllegalArgumentException("Index is out of boundary!!");
    int start = lo;
    while (lo < hi) {
      int temp = partition(a, lo, hi);
      if (kth > temp - start + 1) lo = temp + 1;
      else if (kth < temp - start + 1) hi = temp - 1;
      else return a[temp];
    }
    return a[lo];
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Object[] a, int i, int j) {
    Object temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

}
