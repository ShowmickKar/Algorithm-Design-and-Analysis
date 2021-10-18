// Problem Link: https://leetcode.com/problems/possible-bipartition/
// Problem Type: Graph Coloring, Bipartite Graphs

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, Boolean> colors = new HashMap<Integer, Boolean>();
      
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            edges.add(new ArrayList<Integer>());
        }
      
        boolean[] visited = new boolean[n + 1];
      
        for (int i = 0; i < dislikes.length; i++) {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
      
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            dfs(i, false, colors, edges, visited);
        }
      
        for (int i = 0; i < dislikes.length; i++) {
            if (colors.get(dislikes[i][0]) == colors.get(dislikes[i][1])) {
                return false;
            }
        }
      
        return true;
    }

    private void dfs(int node, boolean color, HashMap<Integer, Boolean> colors, ArrayList<ArrayList<Integer>> edges, boolean[] visited) {
        visited[node] = true;
      
        colors.put(node, color);
      
        for (int u : edges.get(node)) {
            if (visited[u]) continue;
            dfs(u, !color, colors, edges, visited);
        }
    }
}
