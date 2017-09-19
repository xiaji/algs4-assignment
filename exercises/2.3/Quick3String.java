// practice how to compare strings
// Mistake 1: less
// assert substrings before d-index of strings are euqal, for loop, 
// and when the length of two string is not equal, the shorter one is less than the longer one
// Mistake 2: partition
// we should use charAt to get the value of string at d-index, then compare them to decide partition index
// Mistake 3: sort for d-index+1 of strings, which are equals at d-index
public class Quick3String {
  // cutoff to insertion sort
  private static final int CUTOFF = 15;
  // return dth character of String
  private static int charAt(String v, int d) {
    if (d >= 0 && d <= v.length() - 1) return v.charAt(d);
    return -1;
  }
  
  public static void sort(String[] a, int d) {
    // StdRandom.shuffle(a)
    // use median-of-3
    sort(a, 0, a.length - 1, d);
  }

  private static void sort(String[] a, int lo, int hi, int d) {
    if (hi - lo < CUTOFF) {
      insertion(a, lo, hi, d);
      return;
    }
    int mid = (hi - lo + 1) / 2;
    int vIndex = median3(a, lo, lo+mid, hi, d);
    exch(a, lo, vIndex);
    int lt = lo, gt = hi, i = lo + 1;
    // Mistake 2: not v = a[lo]
    // we cal at the d index of string to compare
    int v = charAt(a[lo], d);
    while (i <= gt) {
      // Mistake 2: use charAt instead of compareTo
      // int result = a[i].compareTo(v);
      int result = charAt(a[i], d);
      if (result > v) exch(a, i, gt--);
      else if (result < v) exch(a, i++, lt++);
      else i++;
    }
    sort(a, lo, lt-1, d);
    // Mistake 4:
    // when d-index of strings are equal, we should consider the next index of these strings to compare!!!
    if (v >= 0) sort(a, lt, gt, d+1);
    sort(a, gt+1, hi, d);
  }

  private static int median3(String[] a, int i, int j, int k, int d) {
    return (less(a[i], a[j], d) ?
        (less(a[j], a[k], d) ? j : less(a[i], a[k], d) ? k : i) :
        (less(a[k], a[j], d) ? j : less(a[k], a[i], d) ? k : i));
  }

  private static void insertion(String[] a, int lo, int hi, int d) {
    // int lo = 0, hi = a.length - 1;
    for (int i = lo; i <= hi; i++) {
      for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
        exch(a, j, j-1);
    }
  }

  private static void exch(String[] a, int i, int j) {
    String temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  // start at d-index to compare two strings
  private static boolean less(String v, String w, int d) {
    assert v.substring(0, d).equals(w.substring(0, d));
    for (int i = d; i < Math.min(v.length(), w.length()); i++) {
      // if v.charAt == w.charAt, will do loop, until the difference
      if (v.charAt(i) > w.charAt(i)) return false;
      if (v.charAt(i) < w.charAt(i)) return true;
    }
    // a longer string is greater than the short one.
    // 0 < some int value of longer one
    return v.length() < w.length();
  }
}
