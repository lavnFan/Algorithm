/*
2. Add Two Numbers
给定俩个链表，倒序表示俩个数，求俩个数之和

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //输入和输出，都是倒序，俩个链表相加，即相同位数的节点相加，可能携带进位的1，O(T) = O(max(m,n))， O(S) = O(max(m,n) + 1)
        //tips1:链表题，对于传入的结构，尽量不要改变指向，使用临时指针进行计算
        //tips2:一般给个特殊的首节点，就不需要考虑首次赋值的情况，最后返回时，直接返回下一个即可
        ListNode result = new ListNode(0);   
        ListNode p = l1, q = l2, cur = result;
        int carray = 0;  //进位的可能是0， 可能是1
        while(p != null || q != null){
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int curVal = x + y + carray;
            carray = curVal / 10;
            ListNode curValNode = new ListNode(curVal % 10);
            cur.next = curValNode;
            cur = cur.next;
            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
        }

        //最后根据 carry 是否新增节点
        if(carray > 0){
            ListNode moreNode = new ListNode(carray);
            cur.next = moreNode;
        }
        return result.next;
    }
}