/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (45.47%)
 * Total Accepted:    499.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
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
     * 对俩有序链表，合并返回新的有序链表
     * 方案一：依次遍历俩个链表
     * 方案二：递归调用，返回的总是下一个合并的子链表
     * 
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      /*   ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, merge = result;
        while(p != null && q != null){
            ListNode cur = new ListNode(0);
            if(p.val <= q.val){
                cur.val = p.val;
                p = p.next;
            }else{
                cur.val = q.val;
                q = q.next;
            }
            merge.next = cur;
            merge = merge.next;
        }
        while(p != null){
            ListNode cur = new ListNode(p.val);
            merge.next = cur;
            merge = merge.next;
            p = p.next;
        }
        while(q != null){
            ListNode cur = new ListNode(q.val);
            merge.next = cur;
            merge = merge.next;
            q = q.next;
        }
        return result.next; */

        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
