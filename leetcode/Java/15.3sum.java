/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.16%)
 * Total Accepted:    508K
 * Total Submissions: 2.1M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    /**
    * 求三数之和为0的集合
    * 通用方法：
    * 1、先排序，保证有序
    * 2、再左右夹逼
    * 3、O(T) = max{O(logN), O(N^(k-1))}，缺点会扰乱下标，但没有空间使用
    * 4、新思路：如果时间还要优化，只能用空间来换，比如俩数只和，用空间hash后可以优化为O(T) = O(N)，比一次排序的时间要少
    * tips:
    * 1、每俩个数之和，需要去重
    *  1.1 先固定首位数后，俩个数之和，可能有重复的，需要去重
    *  1.2 对于首位，也可能有重合，首位数和后边的和之间也需要去重
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0){
                break;
            }
            //首位数去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = 0 - nums[i];
            int left = i + 1, right = nums.length -1;
            while(left < right){
                if(nums[left] + nums[right] == target){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //其余俩数去重
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }else if(nums[left] + nums[right] < target){
                    left ++;
                }else{
                    right --;
                }
            }
        }
        return result;
    }
}
