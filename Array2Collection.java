import java.util.*;

public class Array2Collection {
  public List<Integer> array2List(Integer[] nums) {
    List<Integer> list = Arrays.asList(nums);
    return list;
  }

  public Set<Integer> array2Set(int[] nums) {
    Integer[] temp = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      temp[i] = nums[i];
    }
    List<Integer> list = Arrays.asList(temp);
    Set<Integer> set = new HashSet<Integer>(list);
    return set;
  }
}
