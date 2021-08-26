/* Problem Link: https://leetcode.com/problems/all-paths-from-source-to-target/ */

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        int source = 0;
        int target = graph.length - 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(source);
        queue.add(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if ((cur.get(cur.size() - 1)) == (target)) {
                paths.add(new ArrayList<>(cur));
            } else {
                int i = cur.get(cur.size() - 1);
                for (int j = 0; j < graph[i].length; j++) {
                    List<Integer> curPath = new ArrayList<>(cur);
                    curPath.add(graph[i][j]);
                    queue.add(curPath);
                }

            }
        }
        return paths;
    }
}
