class Solution {
    private static final int MOD = 1_000_000_007;
    public int numWays(String[] words, String target) {
        int m = target.length();
        int k = words[0].length();

        int[][] freq = new int[k][26];
        for(String word:words){
            for(int j = 0;j<k;j++){
                freq[j][word.charAt(j) - 'a']++;
            }
        }
        long[][] dp = new long[m+1][k+1];

        dp[0][0] = 1;

        for(int j=0;j<=k;j++){
            dp[0][j] = 1;
        }

        for(int i= 1;i<= m; i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = dp[i][j-1];

                char targetChar = target.charAt(i-1);
                int charCount = freq[j-1][targetChar - 'a'];
                
                if(charCount > 0){
                    dp[i][j] = (dp[i][j]+(dp[i-1][j-1]*charCount)%MOD)%MOD;
                }
            }
        }
        return (int) dp[m][k];
    }
}