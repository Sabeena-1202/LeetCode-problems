class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0 ; i<nums.length;i++){
            if(nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
    public static void printArray(int[]nums,int len){
        System.out.println("[");
        for(int i=0;i<len;i++){
            System.out.println(nums[i]);
            if(i<len-1){
                System.out.println(",");
            }
        }
        System.out.println("]");
    }
    public static void main(String [] args){
        Solution ss = new Solution();
        int nums[]={3,2,2,3,5};
        int val=3;
        int resultLen = ss.removeElement(nums,val);
        
        System.out.println("After removing the occurencew of val");
        Solution.printArray(nums,resultLen);
        System.out.println();
    }
}