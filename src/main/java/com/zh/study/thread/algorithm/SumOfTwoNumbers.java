package com.zh.study.thread.algorithm;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */

public class SumOfTwoNumbers {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int[] nums1 = {3,2,4};
        int[] nums2 = {3,3};
        int target = 9;
        int target1 = 6;
        int target2 = 6;

        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        int[] ints = sumOfTwoNumbers.twoSum(nums, target);
        int[] ints1 = sumOfTwoNumbers.twoSum(nums1, target1);
        int[] ints2 = sumOfTwoNumbers.twoSum(nums2, target2);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));


        int[] numsNew = {6,3,8,2,1};
        int targetNew = 8;
        int[] ints3 = sumOfTwoNumbers.towSumNew(numsNew, targetNew);
        System.out.println(Arrays.toString(ints3)+"================");


    }

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * hash解法
     * @param nums
     * @param target
     * @return
     */
    public int[] towSumNew(int[] nums, int target) {

        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }




}
