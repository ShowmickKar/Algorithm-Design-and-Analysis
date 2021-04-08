class BreadthFirstSearch {
    public ArrayList<Integer> breadthFirstSearch(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> vertices = new ArrayList<Integer>();
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int start = 0;
        queue.add(start);
        while (queue.size() > 0) {
            int current = queue.poll();
            vertices.add(current);
            for (int vertex : adj.get(current)) {
                if (visited[vertex]) continue;
                visited[vertex] = true;
                queue.add(vertex);
            }
        }
        return vertices;
    }
}
