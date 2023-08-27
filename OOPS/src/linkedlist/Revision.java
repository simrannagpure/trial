package linkedlist;

import java.util.Scanner;

public class Revision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i<N; i++){
            array[i] = sc.nextInt();
        }
        int ans = minSubArrayLength(target, array);
        System.out.println(ans);
    }
    //LeetCode 209 - minimum size subarray sum
    public static int minSubArrayLength(int target, int[] nums){
        //logic - using two pointers of binary search concept
        int left = 0;
        int right = 0;
        int minAns = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        while(left < nums.length && right < nums.length){
            currentWindowSum += nums[right];
            right++;
        }
        while (currentWindowSum >= target){
            currentWindowSum -= nums[left];
            left++;
            minAns = Math.min(minAns, right - left +1);
        }
        if(minAns == Integer.MAX_VALUE){
            //no ans
            return 0;
        }
        else {
            return minAns;
        }
    }
    //Leetcode que - 11 Container with most container
    //-----TO DO-------
}