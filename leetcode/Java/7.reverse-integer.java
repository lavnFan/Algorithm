/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.07%)
 * Total Accepted:    594.9K
 * Total Submissions: 2.4M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * 
 */
class Solution {
    /**
     * 逆序输出整数
     * 方案一：先将整数转为String,再逆序遍历反转，再转化int
     * 方案二：进制转化算法：每次只对个位取余，取完后移位
     * tips：注意负号-，末尾为0的情况
     * tips1：注意转化过程中，StringBuilder 和 String 的区分
     * @param x
     * @return
     */
    public int reverse(int x) {
        long result = 0;
        int mute = 1;
        while(x != 0){
            result = result*mute + x%10;
            mute = 10;
            x = x/10;
        }
        result = (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : result;
        return (int)result;


        /*
        int result = 0;
        StringBuilder output = new StringBuilder();
        String input = String.valueOf(x);
        boolean isNegative = false;
        boolean isZero = true;
        for(int i = input.length() - 1;i >= 0; i--){
            char inputChar = input.charAt(i);
            if(isZero && inputChar == '0'){
                continue;
            }
            isZero = false;
            if(inputChar == '-'){
                isNegative = true;
                continue;
            }
            output.append(inputChar);
        }
        if(output.toString().equals("")){
            output.append("0");
        }
        try {
            result = Integer.parseInt(output.toString());
            if(isNegative){
                result = -result;
            }
        } catch (Exception e) {
            result = 0;
        }
        return result;
        */
    }
}
