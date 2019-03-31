/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (54.64%)
 * Total Accepted:    428.2K
 * Total Submissions: 769.9K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
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
    * 中序遍历输出（左、根、右），前序（根、左、右），后序（左、右、根） 
    * 思路：
    * 先遍历左子树，再访问根结点，再遍历右子树
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveTraversal(root, result);
        // iterateTraversal(root, result);
        return result;
    }

    public void recursiveTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        recursiveTraversal(root.left, result);
        result.add(root.val);
        recursiveTraversal(root.right, result);
    }

    public void iterateTraversal(TreeNode root, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
    }
}
