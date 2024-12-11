class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[]freq = new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:freq){
            if(i!=0){
                pq.add(i);
            }
        }
        int time=0;
        while(pq.size()>0){
        List<Integer>temp = new ArrayList<>();
        for(int i=1;i<=n+1;i++){
            if(!pq.isEmpty()){
                temp.add(pq.poll()-1);
            }
        }
        for(int fre:temp){
            if(fre>0){
                pq.add(fre);
            }
        }
            time +=pq.isEmpty()?temp.size():n+1;
        }
        return time;
    }
}