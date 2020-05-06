/* Backspace String Compare

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.

Follow up:

    Can you solve it in O(N) time and O(1) space?


 *
 */

class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] ch1 = new char[S.length()];
        char[] ch2 = new char[T.length()];
        int k=0,l=0;
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            if(c!='#') {ch1[k]=c;k++;}
            if(c=='#' && k>0) {
                k--;
                ch1[k]=0;
            }
        }
        for(int i=0;i<T.length();i++){
            char c=T.charAt(i);
            if(c!='#') {ch2[l]=c;l++;}
            if(c=='#' && l>0) {
                l--;
                ch2[l]=0;
            }
        }
        if(k!=l)return false;
        for(int i=0;i<k;i++){
            if(ch1[i]!=ch2[i]) return false;
        }
        return true;
    }
}
