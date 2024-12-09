class Solution {
    public int removeDuplicates(int[] nums) {
       int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j-1]){
               nums[j]=nums[i];
               j++; 
            }
        }
        return j;
    }
    public void printArray(int arr[],int len){
        System.out.println("[");
        for(int i=0;i<len;i++){
            System.out.println(arr[i]);
            if(i<len-1){
                System.out.println(",");
            }
        }
        System.out.println("]");
    }
    public static void main(String [] args){
        Solution ss = new Solution();
        int nums[]={1,1,2};
        int k=ss.removeDuplicates(nums);
        System.out.println("after removing the duplicates");
        ss.printArray(nums,k);
    }
}