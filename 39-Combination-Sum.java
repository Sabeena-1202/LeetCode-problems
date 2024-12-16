class Solution {
    public static void backTrack(int currentSum,int startIndex,int target,int[]candidates,List<List<Integer>> results,List<Integer>temp){
        if(currentSum==target){
            results.add(new ArrayList<>(temp));
            return;
        }
        if(currentSum>target){
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            temp.add(candidates[i]);
            backTrack(currentSum+candidates[i],i,target,candidates,results,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int currentSum = 0;
        backTrack(currentSum,0,target,candidates,results,temp);
        return results;
    }
}