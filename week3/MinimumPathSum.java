/* Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/

class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] sum = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                sum[i][j]=Integer.MAX_VALUE;
            }
        }

        helper(grid, sum,0,0,0);
        return sum[r-1][c-1];
    }

    void helper(int[][] grid, int[][] sum, int val, int i, int j){
        int x = val + grid[i][j];
        if(x < sum[i][j]){
            sum[i][j] = x;
        } else return;
        if(i+1 < grid.length){
            helper(grid, sum, sum[i][j],i+1, j);
        }
        if(j+1 < grid[0].length){
            helper(grid, sum, sum[i][j],i, j+1);
        }
    }

}
