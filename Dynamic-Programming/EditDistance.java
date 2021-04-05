/* Practice Problem Link: https://practice.geeksforgeeks.org/problems/edit-distance3702/1 */

class EditDistance {
    static String s, t;
    static int[][] memo;
    
    public int cost(int i, int j) {
        if (s.charAt(i) == t.charAt(j)) return 0;
        return 1;
    }
    
    public int dp(int i, int j) {
        if (memo[i][j] >= 0) return memo[i][j];
        if (i == 0 && j == 0) return 0;
        if (i == 0) return j;
        if (j == 0) return i;
        memo[i][j] = Math.min(Math.min(dp(i - 1, j), dp(i, j - 1)) + 1, dp(i - 1, j - 1) + cost(i, j));
        return memo[i][j];
    }
    
    public int editDistance(String s, String t) {
        this.s = ' ' + s;
        this.t = ' ' + t;
        memo = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return dp(s.length(), t.length());
    }
}
