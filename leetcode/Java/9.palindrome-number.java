/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (41.58%)
 * Total Accepted:    537.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * 
 * Input: 121
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 * 
 * 
 * Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 * 
 */
class Solution {
    /**
    * 判断是否为回文数字，不能转字符串，即从左到右和从右到左一样
    * 方案：
    * 1、不能用字符串转整形，则只能使用取整或取余计算
    * 2、既然从左到右和从右到左一样，那不断取余到数字就是第一位开始的，又可以组成原来的数
    */
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int palinX = 0, curX = x;
        while(curX != 0){
            int mode = curX % 10;
            curX /= 10;
            palinX = palinX * 10 + mode;
        }
        if(palinX == x){
            return true;
        }
        return false;
    }
}
