/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 5, 2017
 Problem:    Majority Element
 Difficulty: Easy
 Notes:

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

import java.util.*;

class Solution1 {
    
    public int majorityElement(int[] nums){
      Arrays.sort(nums);
      return nums[nums.length/2];
    }

    public static void main(String[] args) {
        
    }
}
