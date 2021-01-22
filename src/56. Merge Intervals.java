// Problem Link: https://leetcode.com/problems/merge-intervals/

class Solution {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<int[]>();
        int[] temp = new int[2];
        temp[0] = intervals[0][0];
        temp[1] = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(intervals[i][1], temp[1]);
            } else {
                ans.add(temp);
                int s = temp[1];
                temp = new int[2];
                temp[0] = intervals[i][0];
                temp[1] = Math.max(intervals[i][1], s);
            }
        }
        if (ans.size() == 0 || ans.get(ans.size() - 1) != temp) {
            ans.add(temp);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
