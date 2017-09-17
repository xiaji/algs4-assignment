/*
 * Make a Binary Tree from Given Inoder and Preorder Traversal
 * Objective: Given a inorder and preorder traversal, construct a binary tree from that
 * Input: Inorder and preorder traversals
 * int[] inOrder = {2, 5, 6, 10, 12, 14, 15}
 * int[] preOrder = {10, 5, 2, 6, 14, 12, 15}
 */

public class ConstructInPreOrder {
  private static int preIndex = 0;

  private class TreeNode {
    private int val;
    private TreeNode left, right;
    public TreeNode(int x) {
      val = x;
      left = right = null;
    }
  }

  private int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
    if (nums == null || nums.length == 0) return -1;
    int start = startIndex, end = endIndex, mid;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] > target) end = mid;
      else start = mid;
    }
    if (nums[start] == target) return start;
    else if (nums[end] == target) return end;
    return -1;
  }

  public TreeNode construct(int[] preOrder, int[] inOrder, int startIndex, int endIndex) {
    // the first element of preOrder is the root of a tree
    if (startIndex > endIndex) return null;
    TreeNode root = new TreeNode(preOrder[preIndex]);
    preIndex++;
    if (startIndex == endIndex) return root;
    int index = this.binarySearch(inOrder, startIndex, endIndex, root.val);
    root.left = construct(preOrder, inOrder, startIndex, index - 1);
    root.right = construct(preOrder, inOrder, index + 1, endIndex);
    return root;
  }

  public void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);
      System.out.println(root.val);
      inOrder(root.right);
    } else return;
  }

  public static void main(String[] args) {
    int[] inOrder = {2,5,6,10,12,14,15};
    int[] preOrder = {10,5,2,6,14,12,15};
    ConstructInPreOrder test = new ConstructInPreOrder();
    TreeNode root = test.construct(inOrder, preOrder, 0, inOrder.length-1);
    System.out.println("Constructed Tree : ");
    test.inOrder(root);
  }
}
