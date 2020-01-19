package com.leetcode.practise.practise1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:   liuss
 * Date:     2020/1/14 20:01
 * Description:
 *  给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public static int[] twoSumForce(int[] nums, int target) {
        Long d1 = new Date().getTime();
        Runtime r = Runtime.getRuntime();
        r.gc();
        long startMem = r.freeMemory(); // 开始时的剩余内存
        Long d2 = new Date().getTime();

        for(int n=0; n<nums.length; n++){
            for(int m=n+1; m<nums.length;m++){
                if(nums[n]+nums[m]==target){
                    long orz = startMem - r.freeMemory();
                    System.out.println("twoSum耗时："+(new Date().getTime()-d1)+"ms");
                    System.out.println("twoSum内存消耗："+orz+"kb");
                    return new int[]{m, n};
                }
            }
        }
        throw new IllegalArgumentException("twoSum ERROR");
    }

    public static int[] twoSum(int[] nums, int target) {
        Long d1 = new Date().getTime();
        Runtime r = Runtime.getRuntime();
        r.gc();
        long startMem = r.freeMemory(); // 开始时的剩余内存
        Long d2 = new Date().getTime();

        Map<Integer, Integer> initMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int compareInteger = target - nums[i];
            if(initMap.containsKey(compareInteger)) {
                long orz = startMem - r.freeMemory();
                System.out.println("twoSum耗时："+(new Date().getTime()-d1)+"ms");
                System.out.println("twoSum内存消耗："+orz+"kb");
                return new int[]{i, initMap.get(compareInteger)};
            }
            initMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("twoSum3 ERROR");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        twoSumForce(nums, target);
        twoSum(nums, target);
    }

}
