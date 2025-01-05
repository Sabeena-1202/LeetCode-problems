class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int n = s.length();
        int[] shiftArray = new int[n+1];

        for(int[] shift: shifts){
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if(direction == 1){
                shiftArray[start] += 1;
                shiftArray[end + 1] -= 1;
            }else{
                shiftArray[start] -= 1;
                shiftArray[end + 1] += 1;
            }
        }
        int cumulativeShift = 0;
        char[] result = s.toCharArray();

        for(int i=0;i<n;i++){
            cumulativeShift += shiftArray[i];
            int norm = (cumulativeShift % 26 + 26)% 26;
            result[i] = (char)((result[i]-'a'+norm)%26+'a');
        }
        return new String(result);
    }
}