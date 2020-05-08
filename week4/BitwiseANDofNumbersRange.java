/* Bitwise AND of Numbers Range

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4

Example 2:

Input: [0,1]
Output: 0

 */

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        while(m > 0 && n > 0){
            int msb_m = msb(m);
            int msb_n = msb(n);
            if(msb_m != msb_n)
                break;
            int msb_val = 1 << msb_m;
            res += msb_val;
            m = m - msb_val;
            n = n - msb_val;
        }
        return res;
    }
    private int msb(int x){
        int bit = -1;
        while(x > 0){
            x = x >> 1;
            bit++;
        }
        return bit;
    }
}

