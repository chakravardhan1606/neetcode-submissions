
class DSU{
    int n;
    int [] parent;
    int [] rank;

    public DSU(int n){
        this.n =n;
        parent = new int [n];
        rank = new int[n];
         for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int findParent(int node){
        if(this.parent[node]==node)
        return node;

        return findParent(this.parent[node]);
    }

    public boolean union(int u, int v){
         int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) {
            return false;
        }
        if (rank[pv] > rank[pu]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }


}
class Solution {
    public int countComponents(int n, int[][] edges) {
 DSU dsu = new DSU(n);
        int res = n;
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                res--;
            }
        }
        return res;
    }
}
