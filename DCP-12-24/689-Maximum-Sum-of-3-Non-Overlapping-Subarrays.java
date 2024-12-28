class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        int[] prefixSum = new int[n+1];
        for(int i=0;i<n;i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        int[] leftBest = new int[n];
        int[] leftIndex = new int[n];

        int maxSum = getWindowSum(prefixSum, 0, k);
        int maxIndex = 0;
        leftBest[k-1] = maxSum;
        leftIndex[k-1] = 0;

        for(int i=k;i<n-2*k;i++){
            int currentSum = getWindowSum(prefixSum, i-k+1, k);
            if(currentSum >maxSum){
                maxSum = currentSum;
                maxIndex =i-k+1;
            }
            leftBest[i] = maxSum;
            leftIndex[i] =maxIndex;
        }
        int[] rightBest = new int[n];
        int[] rightIndex = new int[n];

        maxSum = getWindowSum(prefixSum, n-k, k);
        maxIndex = n-k;
        rightBest[n-k] = maxSum;
        rightIndex[n-k] = n-k;

        for(int i=n-k-1;i >= 2*k-1;i--){
            int currentSum = getWindowSum(prefixSum, i, k);
            if(currentSum >= maxSum){
                maxSum = currentSum;
                maxIndex = i;
            }
            rightBest[i] = maxSum;
            rightIndex[i] = maxIndex;
        }

        int bestSum = 0;
        int[] result = new int[3];

        for(int i=k; i<= n-2*k;i++){
            int currentSum = getWindowSum(prefixSum, i, k);
            int leftSum = leftBest[i-1];
            int rightSum = rightBest[i+k];

            if(leftSum + currentSum + rightSum > bestSum){
                bestSum = leftSum + currentSum + rightSum;
                result[0]=leftIndex[i-1];
                result[1]=i;
                result[2]=rightIndex[i+k];

            }
        }
        return result;
    }
    private int getWindowSum(int[]prefixSum, int start,int k){
        return prefixSum[start+k]-prefixSum[start];
    }
}