/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (36.07%)
 * Total Accepted:    156.6K
 * Total Submissions: 427.7K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    * 对链表进行划分，保留原有链表顺序，最后俩段再链接一起
    * 方案：
    * 1、分别用俩个节点来表示俩段
    * 2、根据x来进行链接
    * 3、最后再链接俩段节点
    * tips:
    * 1、对next指向要明白，可能的循环要掐断
    */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode small = new ListNode(-1), big = new ListNode(-1), cur = head, smallCur = small, bigCur = big;
        while(cur != null){
            if(cur.val < x){
                smallCur.next = cur;
                smallCur = smallCur.next;
            }else{
                bigCur.next = cur;
                bigCur = bigCur.next;
            }
            cur = cur.next;
        }
        bigCur.next = null;  //断掉指向，避免循环
        smallCur.next = big.next;
        return small.next;
    }
}
