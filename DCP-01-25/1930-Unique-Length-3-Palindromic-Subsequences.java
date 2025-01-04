class Solution {
    public int countPalindromicSubsequence(String s) {
        
        HashSet<String> result = new HashSet<>();

        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];
        Arrays.fill(firstOcc, -1);

        for(int i=0; i < s.length(); i++){
            int char_idx = s.charAt(i) - 'a';
            if(firstOcc[char_idx] == -1){
                firstOcc[char_idx] = i;
            }
            lastOcc[char_idx] = i;
        }

        for(int i=0; i < 26; i++){
            if(firstOcc[i] != -1 && lastOcc[i] > firstOcc[i]){

                for(int j = firstOcc[i] + 1; j < lastOcc[i]; j++){
                    String palindrome = "" + (char)(i + 'a') + s.charAt(j) +(char)(i+'a');
                    result.add(palindrome);
                }
            }
        }
        return result.size();
    }
}