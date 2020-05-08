/* Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

 

Constraints:

    1 <= nums.length <= 3 * 10^4
    0 <= nums[i][j] <= 10^5

*/

class Solution {
    public boolean canJump(int[] nums) {
        //2,3,1,1,4
        //3,2,1,0,4
        int n = nums.length;
        if(n==1) return true;
        int[] jumps = new int[n];
        jumps[0] = 0;
        for(int i = 1; i < n; i++){
            jumps[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(i <= j + nums[j] && jumps[j] != Integer.MAX_VALUE){
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }

        if(jumps[n-1] != Integer.MAX_VALUE)
            return true;
        return false;
    }
}
