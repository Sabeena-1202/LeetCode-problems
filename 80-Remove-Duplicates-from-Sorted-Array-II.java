class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int count=1;
        if(nums.length<=1){
            return nums.length;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
               count++;
             }
            else{
            count=1;
            }
            if(count<=2){
                nums[k] = nums[i];
                k++;
            }
        }
       return k;
    }
    
}