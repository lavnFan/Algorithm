/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (49.99%)
 * Total Accepted:    316.8K
 * Total Submissions: 625.4K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
    * 前序遍历，先根节点，再左右
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // recursiveTraversal(root, result);
        iterateTraversal(root, result);
        return result;
    }

    public void recursiveTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        recursiveTraversal(root.left, result);
        recursiveTraversal(root.right, result);
    }

    public void iterateTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(root);
        while(!stack.isEmpty()){
            cur = stack.pop();
            result.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }
}
