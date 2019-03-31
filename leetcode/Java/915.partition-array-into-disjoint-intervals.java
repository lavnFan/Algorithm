/*
 * @lc app=leetcode id=915 lang=java
 *
 * [915] Partition Array into Disjoint Intervals
 *
 * https://leetcode.com/problems/partition-array-into-disjoint-intervals/description/
 *
 * algorithms
 * Medium (41.63%)
 * Total Accepted:    9.2K
 * Total Submissions: 21.8K
 * Testcase Example:  '[5,0,3,8,6]'
 *
 * Given an array A, partition it into two (contiguous) subarrays left and
 * right so that:
 * 
 * 
 * Every element in left is less than or equal to every element in right.
 * left and right are non-empty.
 * left has the smallest possible size.
 * 
 * 
 * Return the length of left after such a partitioning.  It is guaranteed that
 * such a partitioning exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [5,0,3,8,6]
 * Output: 3
 * Explanation: left = [5,0,3], right = [8,6]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,0,6,12]
 * Output: 4
 * Explanation: left = [1,1,1,0], right = [6,12]
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * It is guaranteed there is at least one way to partition A as
 * described.
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    /**
    * 找到一个基准，左边的都小于右边的
    * 方案：
    * 1、max[0,i] < min[i + i, n]，所以只要把 max[i] 和 min[i] 求出，再进行一个求值即可
    * O(s) = O(N),O(T) = O(N)
    */
    public int partitionDisjoint(int[] A) {
        int[] max = new int[A.length], min = new int[A.length];
        int curMax = A[0], curMin = A[A.length - 1];
        for(int i = 0; i < A.length; i++){
            max[i] = Math.max(curMax, A[i]);
            curMax = max[i];
        }
        for(int i = A.length - 1; i >= 0; i--){
            min[i] = Math.min(curMin, A[i]);
            curMin = min[i];
        }
        for(int i = 0; i < A.length - 1; i++){
            if(max[i] <= min[i+1]){
                return i + 1;
            }
        }
        return 0;
    }
}
