class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[]visited = new boolean[n];
        boolean result = Dfs(graph,source,destination,visited);
        return result;
    }
    public static boolean Dfs(ArrayList<Integer>[] graph, int src,int des, boolean[] visited){
        if(src==des){
            return true;
        }
        visited[src]=true;
        for(int nbr:graph[src]){
            if(visited[nbr]==false){
            boolean ans=Dfs(graph,nbr,des,visited);
            if(ans)return true;
            }
        }
        return false;
    }
}