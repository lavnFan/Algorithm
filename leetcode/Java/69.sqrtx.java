/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (30.48%)
 * Total Accepted:    323.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '4'
 *
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * Example 1:
 * 
 * 
 * Input: 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
 * the decimal part is truncated, 2 is returned.
 * 
 * 
 */
class Solution {
    /**
     * 实现求开放根：i*i<=x && (i+1)*(i+1)>x
     * 方案一：朴素匹配，o(T)=O(sqrt(x)),依次遍历到 x/i，判断条件时为避免越界，把平方到判断改为 i + 1< x/（i+1）
     * 方案二：二分查找，缩短查找周期，O(T)=O(lgx)
     * tips： 注意俩数相乘，int 类型平方后会越界，传入到数在 i*i = x 不越界，但(i+1)*(i+1)越界了
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
     /*    for(int i = 1; i<= x/i; i++){
            if(i <= x/i && (i+1) > x/(i+1)){
                return i;
            }
        }
        return -1; */
        int left = 1, right = x, mid = (left+right)/2;
        while(left <= right){
            if(mid <= x/mid && (mid + 1) > x/(mid + 1)){
                break;
            }
            if(mid < x / mid){
                left = mid + 1;
            }
            if(mid > x / mid){
                right = mid;
            }
            mid = (left + right)/2;
        }
        return mid;
    }
}
