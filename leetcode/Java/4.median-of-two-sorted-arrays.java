/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (25.32%)
 * Total Accepted:    385.3K
 * Total Submissions: 1.5M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    /**
    * 俩个有序数组的中间数，若为奇数，则直接是第 (m+n)/2 + 1个有序的数，若为偶数，则是第 (m+n)/2 和 第(m+n)/2+1 的俩个数平均值
    * 方案：先判奇偶，再遍历到 (m+n)/2 个有序数，再求平均值
    * tips:越界，俩个数组遍历时，注意到一个数组到尾部
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        boolean isOdd = (m+n)%2 != 0;
        int end = isOdd ?  (m+n)/2 + 1: ((m+n)/2 + 1);
        int im = 0, in = 0;
        double current = 0, preCurrent = 0;
        for(int i = 0; i < end; i++){
            if(im < m && in < n && nums1[im] <= nums2[in] || in >= n){
                preCurrent = current;
                current = nums1[im];
                im++;
            }else{
                preCurrent = current;
                current = nums2[in];
                in++;
            }
        }
        if(isOdd){
            return current;
        }else{
            return (current + preCurrent) / 2;
        }
    }
}
