class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count =0;
        int val = nums[nums.length/2];
        for(int num:nums){
            if(num==val){
                count++;
            }
        }
        return count>nums.length/2 ? val: -1;
}
}