public class ArrayOperate {
  public double findMax(double[] nums) {
    double max = nums[0];
    for(int i = 0; i < nums.length; i++) {
      if (max < nums[i]) max = nums[i];
    }
    return max;
  }

  public double average(double[] nums) {
    double sum = 0.0, result = 0.0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    result = sum / nums.length;
    return result;
  }

  public double[] copy(double[] nums) {
    double[] copyArr = new double[nums.length];
    for(int i = 0; i < nums.length; i++) {
      copyArr[i] = nums[i];
    }
    return copyArr;
  }

  public void reverse(double[] nums) {
    int len = nums.length;
    for(int i = 0; i < len / 2; i++) {
      double temp = nums[i];
      nums[i] = nums[len - 1 - i];
      nums[len - 1 - i] = temp;
    }
  }
}
