package leetcode;

import java.util.HashMap;

/**
 * @ProjectName: BCDS
 * @Package: leetcode
 * @ClassName: _01TwoSum
 * @Author: yuxingsheng
 * @Description: Given an array of integers,
 * return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 * Example:  Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum
 * @Date: 2020/1/10 16:15
 * @Version: 1.0
 */
public class _01TwoSum {
    /*
    * The easy solution is O(n^2) run-time complexity.
    *
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    */
    public  int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp), i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
