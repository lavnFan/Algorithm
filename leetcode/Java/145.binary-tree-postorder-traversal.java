/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (46.51%)
 * Total Accepted:    244.6K
 * Total Submissions: 515.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
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
    * 后序遍历，先左、右，再根节点
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // recursiveTraversal(root, result);
        iterateTraversal(root, result);
        return result;
    }

    public void recursiveTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        recursiveTraversal(root.left, result);
        recursiveTraversal(root.right, result);
        result.add(root.val);
    }

    /**
    * 后序跟前序可以相反
    */
    public void iterateTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.pop();
            result.add(0, cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }
}
