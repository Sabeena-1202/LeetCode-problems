class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxPrevious = values[0]+0;

        for(int j=1;j<values.length;j++){
            maxScore = Math.max(maxScore,maxPrevious+values[j]-j);

            maxPrevious = Math.max(maxPrevious, values[j]+j);
        }
        return maxScore;
    }
}