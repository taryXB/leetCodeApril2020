/* Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

*/

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        if(nums[0] <= nums[n - 1]){
            return searchHelper(nums, 0, n-1, target);
        }

        int l = 0;
        int h = n - 1;
        int pivot = 0;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(l==h) {
                pivot = l;
                break;
            }
            if(mid + 1 < n && nums[mid + 1] < nums[mid]){
                pivot = mid;
                break;
            } else if(nums[mid] > nums[l]){
                l = mid + 1;
            } else if(nums[mid] < nums[l]){
                h = mid;
            }
        }
        //System.out.println("pivot:"+pivot);
        if(target == nums[pivot]) return pivot;
        //else if(pivot == n - 1) return searchHelper(nums, 0, pivot -1);
        else if(target < nums[pivot] && target >= nums[0]) return searchHelper(nums, 0 , pivot -1, target);
        else return searchHelper(nums, pivot+1, n - 1 , target);
    }

    public int searchHelper(int[] nums, int l, int h, int target){
        if(l <= h){
            int mid = l + (h-l) / 2;
            //System.out.println("mid: "+mid+", "+nums[mid]);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                return searchHelper(nums, l, mid - 1, target);
            } else {
                return searchHelper(nums,mid + 1, h, target);
            }
        }
        return -1;
    }
}
