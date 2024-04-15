package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {

    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum_New(num);
        System.out.println("\n");
        for (List<Integer> l : res) {
            System.out.print(l + ",");
        }
    }

    public static List<List<Integer>> threeSum_New(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;

                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }

        }
        res.addAll(set);
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        int len = nums.length;
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < len; i++) {
            int target = 0 - sortedNums[i];
            List<int[]> subArr = twoSum(i + 1, sortedNums, target);

            if (!subArr.isEmpty()) {
                for (int[] a : subArr) {
                    List<Integer> li = new ArrayList<>();
                    li.add(sortedNums[i]);
                    li.add(a[0]);
                    li.add(a[1]);
                    List<Integer> l2 = li.stream().sorted().collect(Collectors.toList());

                    arr.add(l2);
                }
            }
        }
        List<List<Integer>> res = arr.stream().distinct().collect(Collectors.toList());
        return res;
    }

    public static List<int[]> twoSum(int start, int[] num, int target) {
        int len = num.length;
        Set<Integer> mySet = new HashSet<>();
        List<int[]> myList = new ArrayList<>();

        for (int i = start; i < len; i++) {
            int comp = target - num[i];
            if (mySet.contains(comp)) {
                int[] r = new int[]{num[i], comp};
                myList.add(r);
            } else {
                mySet.add(num[i]);
            }
        }

        return myList;
    }


}
