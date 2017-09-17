/*
 * Given Inorder and Preorder traversals of a binary tree, print Postorder traversal.
 * Input:
 * Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
 * Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}
 * Output:
 * Postorder traversal is {4, 5, 2, 6, 3, 1}
 * if give InOrder and PostOrder to get pre, just like prefix, we should start from right to left 
 * of post[] and result order is right left root(stack), so need reverse the result string.
 * StringBuilder.append instead of println
 * pIndex = post.length - 1,
 */
import java.util.Stack;

public class PostFromInPreOrder {
  private static int pIndex = 0;
  private Stack<Integer> mids = new Stack<>();

  public void postConstruct(int[] preOrder, int[] inOrder, int startIndex, int endIndex) {
    // System.out.println("End Index: " + endIndex);
    if (startIndex > endIndex) {
      // System.out.println("Index(greater): " + startIndex);
      return;
    }
    if (startIndex == endIndex) {
      // System.out.println("Index: " + startIndex);
      System.out.println(inOrder[startIndex]);
      pIndex++;
      return;
    }
    mids.push(preOrder[pIndex]);
    int index = this.findIndex(inOrder, startIndex, endIndex, preOrder[pIndex]);
    pIndex++;
    // left subtree of inOrder
    postConstruct(preOrder, inOrder, startIndex, index - 1);
    // right subtree of inOrder
    postConstruct(preOrder, inOrder, index + 1, endIndex);
    System.out.println(mids.pop());
  }

  private int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
    if (nums == null || nums.length == 0) return -1;
    int start = startIndex, end = endIndex, mid;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (nums[mid] == target) return mid;
      if (nums[mid] > target) return end = mid;
      if (nums[mid] < target) return start = mid;
    }
    if (nums[start] == target) return start;
    else if (nums[end] == target) return end;
    return -1;
  }

  private int findIndex(int[] nums, int startIndex, int endIndex, int target) {
    if (nums == null || nums.length == 0) return -1;
    int start = startIndex, end = endIndex;
    for (int i = start; i <= endIndex; i++) {
      if (nums[i] == target) return i;
    }
    return -1;
  }

  public static void main (String[] args) {
    int[] in = {8, 2, 9, 4, 7, 3, 6, 5};
    int[] pre = {3, 4, 2, 8, 9, 7, 5, 6};
    PostFromInPreOrder test = new PostFromInPreOrder();
    test.postConstruct(pre, in, 0, in.length - 1);
  }
}
