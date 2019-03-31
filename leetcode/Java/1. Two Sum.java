/*
1. Two Sum
一个无序数组（每个数都是唯一的），和俩个数的目标合，求这俩个数的下标

Example：
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        //给定一个无序数组，求和为目标数的俩个下标
        //若有序，则可以前后同时查找，时间可缩短为 o(n)
        //若无序，则需要一次嵌套遍历，时间为o(n^2)
        //方案一：朴素遍历，第二次查找时，朴素依此遍历
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+ 1 ; j< nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        
        //方案二：空间换时间，将时间的复杂度 O(n^2) 降为 O(n)，再查找时，使用 hash 表将查找时间从 O(n)降为O(1)
        //注意是俩个不同的数，需要判相等
        // Map<Integer, Integer> targetsMap = new HashMap<Integer, Integer>();
        // for(int i = 0; i < nums.length; i++){
        //     targetsMap.put(nums[i], i);
        // }
        // for(int i = 0; i< nums.length; i++){
        //     int targetsComponent = target - nums[i];
        //     if(targetsMap.containsKey(targetsComponent) && targetsMap.get(nums[i] != i)){
        //         return new int[]{i, targetsMap.get(nums[i])};
        //     }
        // }
        
        //方案三：俩次遍历减少为一次遍历
        //hash 表中的数和当前遍历的无交集
//         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//         for(int i = 0; i< nums.length; i++){
//             int targetComponent = target - nums[i];
//             if(map.containsKey(targetComponent)){
//                 return new int[]{map.get(targetComponent), i};
//             }
//             map.put(nums[i], i);
//         }

        //方案四：先排序，再左右夹逼，但会扰乱下标
        
        throw new IllegalArgumentException("No two sum solution");
        
    }
}