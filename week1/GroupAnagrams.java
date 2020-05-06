/* Group Anagrams
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
*/
class Solution {
    
    private String sortLetters(String input){
        char[] newString = input.toCharArray();
        Arrays.sort(newString);
        return new String(newString);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        Set set = new HashSet();
        List<String> l1;
        List<List<String>> list = new ArrayList<>();
        for(String item: strs){
            String s = sortLetters(item);
            set.add(s);
            if(map.containsKey(s)){
                l1 = map.get(s);
            }
            else{
                l1 = new ArrayList<String>();
            }
            l1.add(item);
            map.put(s,l1);
        }
        for (Object item: set){
            l1 = map.get(item);
            list.add(l1);
        }
        return list;
    }
}

