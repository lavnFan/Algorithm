/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (26.33%)
 * Total Accepted:    179.1K
 * Total Submissions: 674.9K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
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
    * 链表旋转，不断把尾节点放在头部 k 次，即把 l - l % n 的节点作为首节点
    * 方案：
    * 1、k大小不定，旋转 k 次和 k%n 次是一样效果
    * 2、获取首节点位置
    * 3、对末尾节点和原先的首节点进行链接
    * tips:代码第一步，还是判空。对题目对审题，可以先画图，标注一下
    */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode tail = dumy,newTail = dumy;
        int length = 0;
        while(tail.next != null){
            tail = tail.next;
            length ++;
        }
        int rk = length - k%length;
        for(int i = 0; i < rk; i++){
            newTail = newTail.next;
        }
        tail.next = dumy.next;
        dumy.next = newTail.next;
        newTail.next = null;
        return dumy.next;
    }
}
