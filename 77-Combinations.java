class Solution {
    public static void backTrack(int level , int start , int k , List<Integer>temp ,       List<List<Integer>>results , int n){
        if(level==k){
        results.add(new ArrayList(temp));
        return;
        }
        for(int i= start;i<=n;i++){
            temp.add(i);
            backTrack(level+1,i+1,k,temp,results,n);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(0,1,k,temp,results,n);
        return results;
    }
}