/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (29.98%)
 * Total Accepted:    333.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    /**
    * 判断一个字符串是否为回文串
    * 方案：
    * 1、首尾比较字符
    * 2、去除杂七杂八的干扰，对符合条件的才对比
    */
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int left = 0, right = s.length() - 1;
        while(left <= right){
            while(left <= right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left <= right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left <= right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
