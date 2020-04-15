/*
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

/*
 * Example 1:
 *
 * Input: [4,1,2,1,2] 
 * Output: 4
 */

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int item: nums){
            ans ^= item;
        }
        return ans;
    }
}
