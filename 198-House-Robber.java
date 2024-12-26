class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int[]dp = new int[n];
        Arrays.fill(dp,-1);
       int ans = memo_helper(nums, n-1,dp);
       return ans; 
    }
    public int memo_helper(int[]nums,int n,int[]dp){
        if(n==0) return nums[0];
        if(n<0) return 0;
      if(dp[n]!=-1)return dp[n];
// i have stole
            int la = memo_helper(nums, n-2, dp) + nums[n];
// i have not stole
            int ra = memo_helper(nums, n-1, dp) + 0;  

            dp[n]= Math.max(la,ra);

            return Math.max(la,ra);           
        
    }
}