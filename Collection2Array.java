import java.util.HashSet;

public class Collection2Array {
  public int[] set2IntArray(HashSet<Item> set) {
    // Set<Item> set = new HashSet<Item>();
    Object[] obj = set.toArray();
    int[] temp = new int[obj.length];
    for(int i = 0; i < obj.length; i++) {
      temp[i] = (int) obj[i];
    }
    return temp;
  }

  public String[] set2StringArray(HashSet<Item> set) {
    String[] strArray = set.toArray(new String[set.size()]);
    return strArray;
  }
}
