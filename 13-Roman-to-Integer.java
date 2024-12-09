class Solution {
    public int romanToInt(String s) {
        int result =0;
        HashMap<Character,Integer> symbolValue = new HashMap<>();
        symbolValue.put('I',1);
        symbolValue.put('V',5);
        symbolValue.put('X',10);
        symbolValue.put('L',50);
        symbolValue.put('C',100);
        symbolValue.put('D',500);
        symbolValue.put('M',1000);
        for(int i=0; i < s.length();i++){
        char char1 = s.charAt(i);
        if(symbolValue.containsKey(char1)){
        int currentValue = symbolValue.get(char1);
        if(i<s.length()-1 && currentValue < symbolValue.get(s.charAt(i+1))){
            result-=currentValue;
        }
        else{
            result+=currentValue;
        }
        }
        
        }
         return result;
    
    }
    public static void main (String args[]){
        Solution ans = new Solution();
        System.out.println(ans.romanToInt("III"));
        System.out.println(ans.romanToInt("LVIII"));
        System.out.println(ans.romanToInt("MCMXCIV"));
    }
}