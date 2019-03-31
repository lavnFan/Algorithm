/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (41.77%)
 * Total Accepted:    310.6K
 * Total Submissions: 737.5K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->1->2
 * Output: 1->2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
    * 有序链表，删除重复元素
    * 方案：
    * 1、依次遍历，用一个前指针来辅助判断是否相同，若不同，则向前，否则删除当前节点
    */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode preNode = head, curNode = head.next;
        while(curNode != null){
            if(curNode.val == preNode.val){
                preNode.next = curNode.next;
                curNode = curNode.next;
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return head;
    }
}
