/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (33.92%)
 * Total Accepted:    348.2K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
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
     * 移除链表中第n个节点
     * 方案：一前一后俩个指针，相差n，则当第一个指针到尾节点时，第二个指针就到了要删除到那个节点
     * 代码优化：先让一个指针走 n，再同时走，相比一步到位思维会清晰一点
     * tips：注意删除的是首节点，所以多添加一个节点作为首节点较好
     * tips：注意要删除的节点，获取被删除的前一个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode tail = dumpy, removeBefore = dumpy;
        int i = 0;
        while(tail.next != null){
            i++;
            tail = tail.next;
            if(i >= n + 1){  //移除节点，倒数第n个，获取倒数第 n+1 个节点
                removeBefore = removeBefore.next;
            }
        }
        removeBefore.next = removeBefore.next.next;
        return dumpy.next;
    }
}
