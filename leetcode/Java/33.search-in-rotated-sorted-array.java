/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.57%)
 * Total Accepted:    374.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    /**
    * 一组俩部分增序的数组，寻找target的下标，时间是O(logn)
    * 方案：可采用二分法查询，后边半部分的数最大值一定小于首位
    * 1、先确定是前区间还是后区间，找出 pivot 基础值
    * 2、根据target在前区间还是后区间，再进行普通的二分查找
    */
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int low = 0, high = nums.length - 1, mid;
        while(low < high){
            mid = (low + high) / 2;
            if(nums[mid] > nums[high]){    //find the smallest value
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        int pivot = low;  //pivot, when low == high, then pivot will be the smallest
        int start = 0, end = nums.length - 1;
        if(target == nums[pivot]){
            return pivot;
        }else if(target <= nums[end]){
            start = pivot;
        }else {
            end = pivot - 1;
        }

        //normal binary search
        while(start <= end){
            mid = (start + end) / 2;
            if(target > nums[mid]){
                start = mid + 1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                return mid;
            }
        }
       
        return -1;
    }
}
