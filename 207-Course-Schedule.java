class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v= prerequisites[i][1];
            graph[u].add(v);
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                int vv = graph[i].get(j);
                indegree[vv]++;
            }
        }
        boolean[] visited =new boolean[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count =0;
        while(q.size()>0){
            int rem = q.poll();
            count++;
            visited[rem] =true;
            for(int nbr:graph[rem]){
                if(visited[nbr]==false){
                    indegree[nbr]--;
                    if(indegree[nbr]==0)q.add(nbr);
                }
            }
        }
        if(count==numCourses) return true;

        return false;
    }
}