/* Binary Tree Maximum Path Sum

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 */

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int dp;
    public int maxPathUtil(TreeNode root) {
        if(root==null) return 0;
        int leftSum = Math.max(0, maxPathUtil(root.left));
        int rightSum = Math.max(0, maxPathUtil(root.right));
        int maxChild = Math.max(leftSum, rightSum);
        dp = Math.max(dp, leftSum + rightSum + root.val);
        return maxChild + root.val;
    }
    public int maxPathSum(TreeNode root) {
        dp = Integer.MIN_VALUE;
        maxPathUtil(root);
        return dp;
    }
}

