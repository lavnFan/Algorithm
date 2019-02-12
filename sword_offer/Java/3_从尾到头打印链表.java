/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 解决方案：
 * 1、使用栈，后入先出，再放到list中
 * 2、递归调用，最后一层先输出
 */

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
   // ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = listNode;
        while(p != null){
            stack.push(p.val);
            p = p.next;
        };
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
       /*
        if(listNode != null){
            printListFromTailToHead(listNode.next);
            result.add(listNode.val);
        }
         */
        return result;
    }
}