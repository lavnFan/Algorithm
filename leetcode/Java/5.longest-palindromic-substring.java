/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.34%)
 * Total Accepted:    481.5K
 * Total Submissions: 1.8M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {
    /**
    * 最长回文串
    * 方案：1、先判断是否为回文串，指定i到j，2、再判断长度
    * 方案二：回文串到特征：从中间向俩边伸展是一样的，所以只需以中心向俩边遍历即可，注意奇数和偶数
    * tips:注意一个字符也可以是回文串，注意初始值到问题
    */
    public String longestPalindrome(String s) {
        // char[] str = s.toCharArray();
        // String result = "";
        // for(int i = 0; i < str.length; i++){
        //     for(int j = i; j < str.length; j++){
        //         if(isPalindrome(str, i , j)){
        //             if(j - i >= result.length()){
        //                 result = s.substring(i,j+1);
        //             }
        //          }
        //     }
        // }
        // return result;
        return expandLongestPalindrome(s);
    }

    public boolean isPalindrome(char[] str, int i, int j){
        int m = (i + j)/2;
        for(int k = 0; k <= (j - i) / 2; k++){
            if(str[i + k] != str[j - k]){
                return false;
            }
        }
        return true;
    }

    public String expandLongestPalindrome(String s){
        if(s == null || s.equals("")){
            return s;
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(end - start < len){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
    * 从中心向俩边扩展，返回扩展的长度
    */
    public int expandAroundCenter(String s, int i, int j){
        int l = i, r = j;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l --;
            r ++;
        }
        return r - l - 1;
    }
}
