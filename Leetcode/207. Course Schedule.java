// Problem Link: https://leetcode.com/problems/course-schedule/
// Problem Type: Cycle Detection, Depth First Search, Recursion

class Solution {
    private List<ArrayList<Integer>> graph;
    private int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            ArrayList<Integer> edge = new ArrayList<Integer>();
            graph.add(edge);
        }
        visited = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 1) continue;
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node) {
        visited[node] = -1;
        for (Integer u : graph.get(node)) {
            if (visited[u] == 1) continue;
            if (visited[u] < 0) {
                return false;
            }
            if (!dfs(u)) return false;
        }
        visited[node] = 1;
        return true;
    }
}

/*
20
[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]
output: false

3
[[1,0],[2,0],[0,2]]
output: false

2
[[1,0]]
output: true

5
[[1,4],[2,4],[3,1],[3,2]]
output: true
 */
