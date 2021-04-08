class DepthFirstSearch {
    static ArrayList<Integer> result;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    
    public void traverse(int vertex) {
        visited[vertex] = true;
        result.add(vertex);
        for (int v : graph.get(vertex)) {
            if (visited[v]) continue;
            traverse(v);
        }
    }
    
    public ArrayList<Integer> deapthFirstSearch(int V, ArrayList<ArrayList<Integer>> adj) {
        result = new ArrayList<Integer>();
        visited = new boolean[V];
        graph = adj;
        traverse(0);
        return result;
    }
}
