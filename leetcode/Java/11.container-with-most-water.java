/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (42.10%)
 * Total Accepted:    336.6K
 * Total Submissions: 777.7K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a
 * point at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * 
 * 
 * 
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In
 * this case, the max area of water (blue section) the container can contain is
 * 49. 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 */
class Solution {
    /**
    * 输入是各个节点对高度，选定俩个点，高度为俩个最小，再乘以横轴，求面积最大
    * 方案：
    * 1、依次遍历各个点，求出各个点最大对面积，再返回所有节点对最大面积
    * 2、某个节点对最大面积，遍历之前对节点，取俩点最小值*x轴，算面积
    */
    public int maxArea(int[] height) {
        int maxAreaValue = 0;
        for(int i = 1; i < height.length; i++){
            int curMaxArea = Math.min(height[i], height[i - 1]);
            for(int j = i-2; j >= 0; j--){  //往回回溯，获取当前节点对最大值
                int minHeight = Math.min(height[i], height[j]);
                curMaxArea = Math.max(curMaxArea, minHeight * (i - j));
            }
            maxAreaValue = Math.max(maxAreaValue, curMaxArea);
        }
        return maxAreaValue;
    }
}
