class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
             graph[i] = new ArrayList<>();
        }
        for( int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v= prerequisites[i][1];
            graph[v].add(u);
        }
        int[] indegree =  new int[numCourses];

        for(int i=0;i<graph.length;i++){
           for(int j=0;j<graph[i].size();j++){
              int vv = graph[i].get(j);
              indegree[vv]++;
           }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        int[] ans = new int[numCourses];
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
               queue.add(i);
            }
        }
        int index=0;
        while(queue.size()>0){
            int rem = queue.poll();
            ans[index++] = rem;
            visited[rem]= true;
            for(int nbr:graph[rem]){
                if(visited[nbr]==false){
                    indegree[nbr]--;
                    if(indegree[nbr]==0){
                        queue.add(nbr);
                    }
                }
            }
        }
      if(index==numCourses) return ans;
      return new int[]{};
    }
}