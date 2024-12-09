class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk=0;
        for(int c:chalk){
            totalChalk+=c;
        }
        k=(int)(k%totalChalk);
       for(int i=0;i<chalk.length;i++){
        if(k<chalk[i]){
            return i;
        }else{
            k-=chalk[i];
        }
       } 
       return 0;
    }
}