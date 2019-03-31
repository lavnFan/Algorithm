/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * algorithms
 * Easy (39.37%)
 * Total Accepted:    515.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 * Example 2:
 * 
 * 
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * 
 * 
 * Clarification:
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means
 * modification to the input array will be known to the caller as well.
 * 
 * Internally you can think of this:
 * 
 * 
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * 
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len
 * elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 */
class Solution {
    /**
    * 获取不重复的元素长度，空间为O(1)，数组有序，前n个必须是不重复的
    * 思路：若对空间没要求，直接使用hash；这里规定空间限制，但可改变数组内容，是否可用数组作为hash
    * 方案：根据数组有序，不重复元素标记移位，重复元素记过滤
    */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int noDupCur = 0;
        int maxNoDupLength = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[noDupCur] == nums[i]){
                continue;
            }else {
                noDupCur ++;
                nums[noDupCur] = nums[i];
                maxNoDupLength ++;
            }
        }
        return maxNoDupLength;
    }
}
