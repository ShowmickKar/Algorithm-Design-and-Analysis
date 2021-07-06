/* Problem Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/ 
  Problem Type: Recursion, Depth First Search 
 */

class Solution {
    ArrayList<String> result;
    char[][] letters = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public void traverse(String combination, String digits, int index) {
        if (index == digits.length()) {
            if (combination.length() > 0) {
                result.add(combination);
            }
            return;
        }
        int current = digits.charAt(index) - '0' - 2;
        for (int i = 0; i < letters[current].length; i++) {
            traverse(combination + letters[current][i], digits, index + 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();
        traverse("", digits, 0);
        return result;

    }
}
