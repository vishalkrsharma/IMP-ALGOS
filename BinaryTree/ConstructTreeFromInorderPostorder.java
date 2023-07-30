import java.util.HashMap;
import java.util.Map;

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length)
      return null;

    Map<Integer, Integer> inMap = new HashMap<>();

    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }

    TreeNode root = build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);

    return root;
  }

  private TreeNode build(int inorder[], int inStart, int inEnd, int postorder[], int postStart, int postEnd,
      Map<Integer, Integer> inMap) {
    if (postStart > postEnd || inStart > inEnd)
      return null;

    TreeNode root = new TreeNode(postorder[postEnd]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;

    root.left = build(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, inMap);

    root.right = build(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, inMap);

    return root;
  }
}