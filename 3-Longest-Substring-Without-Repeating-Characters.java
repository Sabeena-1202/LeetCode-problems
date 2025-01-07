class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int maxLength = 0;

        Set<Character> window = new HashSet<>();

        int left = 0;

        for(int right = 0; right < n; right++){
            while(window.contains(s.charAt(right))){
                window.remove(s.charAt(left));
                left++;
            }

            window.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left +1);
        }
        return maxLength;
    }
}