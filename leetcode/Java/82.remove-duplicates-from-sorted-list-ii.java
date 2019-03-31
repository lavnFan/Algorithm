/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (32.02%)
 * Total Accepted:    172.8K
 * Total Submissions: 532.9K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    * 删除重复的所有节点，一个不保留，相比保留的节点，需要用一个辅助前节点来删除可能的首节点
    * 方案：
    * 1、用一个辅助节点开头
    * 2、依次遍历链表中的节点，相同节点要先遍历完再进行删除操作
    * tips;
    * 1、若想把值想相同的节点都删掉，可以把值取出来，让链表直接链接过去
    */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode cur = head, pre = dumy;
        while(cur != null){
            if(cur.next == null || cur.val != cur.next.val){
                pre = cur;
                cur = cur.next;
                continue;
            }
            int val = cur.val;   //把这个值取出来，在把相同的节点都遍历过去
            while(cur != null && cur.val == val){
                cur = cur.next;
            }
            pre.next = cur;
        }
        return dumy.next;
    }
}
