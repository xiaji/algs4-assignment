// import java.lang.String;

public class StringOps {
  public static boolean isPalindrome(String s) {
    if (s.length() == 0 || s == null) return false;
    int len = s.length();
    for(int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length()-i-1)) return false;
    }
    return true;
  }

  public static String[] fileInfo(String args) {
    int dot = args.indexOf(".");
    String[] result = new String[2];
    result[0] = args.substring(0, dot);
    result[1] = args.substring(dot + 1, args.length());
    return result;
  }

  public static boolean isSorted(String[] a) {
    if (a == null || a.length == 0) return false;
    for (int i = 0; i < a.length; i++) {
      if (a[i-1].compareTo(a[i]) > 0) return false;
    }
    return true;
  }
}
