/*
* Given an array nums of n integers where n > 1,  return an array output such that
* output[i] is equal to the product of all the elements of nums except nums[i].
*/

/*
* Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
* Note: Please solve it without division and in O(n).
*/

/* 
* Example:
* Input:  [1,2,3,4]
* Output: [24,12,8,6]
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i];
        }
        suffix[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i];
        }
        nums[0] = suffix[1];
        nums[n-1] = prefix[n-2];
        for(int i=1; i < n-1; i++){
            nums[i] = prefix[i-1] * suffix[i+1];
        }
        return nums;
    }
}


