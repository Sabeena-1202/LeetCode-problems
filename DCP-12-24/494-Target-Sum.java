class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(Math.abs(target)>sum)return 0;

        int[] dp = new int[2*sum+1];
        dp[nums[0]+sum]=1;
        dp[-nums[0]+sum]+=1;

        for(int i=1;i<nums.length;i++){
            int[] next = new int[2*sum+1];
            for(int j= -sum;j<=sum;j++){
                if(dp[j+sum]>0){
                    next[j+nums[i]+sum] += dp[j+sum];
                    next[j-nums[i]+sum] += dp[j+sum];
                }
            }
            dp = next;
        }
        return target > sum ? 0 : dp[target+sum];
    }
}