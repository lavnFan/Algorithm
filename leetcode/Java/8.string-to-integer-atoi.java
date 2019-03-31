/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * algorithms
 * Medium (14.44%)
 * Total Accepted:    340.5K
 * Total Submissions: 2.3M
 * Testcase Example:  '"42"'
 *
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of
 * this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty
 * or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * 
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical
 * value is out of the range of representable values, INT_MAX (231 − 1) or
 * INT_MIN (−231) is returned.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "42"
 * Output: 42
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus
 * sign.
 * Then take as many numerical digits as possible, which gets 42.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a
 * numerical digit.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a
 * numerical 
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * 
 * Example 5:
 * 
 * 
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit
 * signed integer.
 * Thefore INT_MIN (−231) is returned.
 * 
 */
class Solution {
    /**
    * String 转 int，遇到第一个非空格的数字/正负号开始，到最后一个连续数字，注意转化后到越界
    * 方案：
    * 1、依此遍历此字符串，先去掉无用的空串
    * 2、再判断是否有加减号
    * 3、再进行数字转化，注意越界问题
    * tips:
    * 1、java 中的 max：Integer.MAX_VALUE，min：Integer.MIN_VALUE
    * 2、对题目，要分步骤，明确各个思路，不能一步而就
    * 3、尤其注意越界问题，知道当前 index 到哪一步了
    */
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int index = 0, signal = 1;
        while(index < str.length() && str.charAt(index) == ' '){
            index++;
        }
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
            signal = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        int result = 0;
        for(int i = index; i < str.length(); i++){
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit > 9){
                break;
            }
            if(result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10){
                result = signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                return result;
            }
            result = result * 10 + digit;
        }
        return result * signal;
    }
}
