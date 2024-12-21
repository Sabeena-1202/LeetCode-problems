class Solution {
    private List<List<Integer>> adj;
    private int[] values;
    private int k;
    private int maxComponents;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.values = values;
        this.k = k;
        this.maxComponents=0;

        adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        long totalSum=dfs(0,-1);
        if(maxComponents==0){
            maxComponents=1;
        }
        return maxComponents;
    }
    private long dfs(int node, int parent){
        long sum = values[node];

        for(int child: adj.get(node)){
            if(child != parent){
                long childSum = dfs(child,node);
                if(childSum%k!=0){
                    sum+=childSum;
                }
            }
        }

        if(sum%k==0){
            maxComponents++;
            return 0;
        }
        return sum; 
    }
}