/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (32.89%)
 * Total Accepted:    429.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    /**
    * 多个字符串的最长前缀
    * 方案：
    * 1、以第一个为预设公共前缀
    * 2、对预设前缀进行遍历，相同位数下对不同匹配串进行匹配，若不再匹配，则返回之前对公共子串
    */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String commStr = strs[0];
        for(int i = 0; i < commStr.length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() == i || commStr.charAt(i) != strs[j].charAt(i)){
                    commStr = commStr.substring(0, i);
                    return commStr;
                }
            }
        }
        return commStr;
    }
}
