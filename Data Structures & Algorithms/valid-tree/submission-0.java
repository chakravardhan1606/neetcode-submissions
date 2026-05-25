class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // Tree must have exactly n - 1 edges

        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        if (!dfs(adj, 0, -1, visited)) return false;

        // Ensure all nodes were visited (i.e., graph is connected)
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> adj, int u, int parent, boolean[] visited) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (visited[v]) return false;

            if (!dfs(adj, v, u, visited)) return false;
        }

        return true;
    }
}
