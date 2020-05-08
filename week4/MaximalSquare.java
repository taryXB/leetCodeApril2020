/*  Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        int max = 0;
        int[][] DP = new int[m][n];

        if(m==1 && n==1){
            if(matrix[0][0]=='1') return 1;
            else return 0;
        }

        for(int i = 0 ; i < m; i++) {
            if(matrix[i][0] == '1') DP[i][0] = 1;
            else DP[i][0] = 0;
            if(DP[i][0] > max) max = DP[i][0];
        }
        for(int i = 0 ; i < n; i++) {
            if(matrix[0][i] == '1') DP[0][i] = 1;
            else DP[0][i] = 0;
            if(DP[0][i] > max) max = DP[0][i];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '1'){
                    DP[i][j] = 1 + Math.min(DP[i-1][j-1], Math.min(DP[i-1][j], DP[i][j-1]));
                } else {
                    DP[i][j] = 0;
                }
                if(DP[i][j] > max) max = DP[i][j];
            }
        }
        System.out.println(max);
        return max * max;
    }
}

