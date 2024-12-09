class Solution {
    public int reverse(int x) {
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;
        int result = 0;
        while(x!=0){
            int digit = x%10;
            x/=10;
            if(result > INT_MAX / 10 || result == INT_MAX && digit > 7)
            return 0;
            if(result < INT_MIN / 10 || result == INT_MIN && digit < -8)
            return 0;
            result = result*10+digit;
        }
        return result;
    }
    public static void main(String[] args){
        Solution solve = new Solution();
        System.out.println(solve.reverse(123));
        System.out.println(solve.reverse(-123));
        System.out.println(solve.reverse(120));
    }
}