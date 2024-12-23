/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int operations = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }
            operations +=getMinSwaps(level);
        }
        return operations;
    }
    private int getMinSwaps(List<Integer> nums){
        int n = nums.size();

        int[] arr = new int[n];
        HashMap<Integer,Integer> pos = new HashMap<>();
        for(int i=0;i<n;i++){
            arr[i] = nums.get(i);
            pos.put(arr[i],i);
        }
        Arrays.sort(arr);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for(int i=0;i<n;i++){
            if(visited[i]|| pos.get(arr[i])==i)continue;

            int cycleSize = 0;
            int j=i;
            while(!visited[j]){
                visited[j]=true;
                j=pos.get(arr[j]);
                cycleSize++;
            }
            swaps+=cycleSize - 1;
        }
        return swaps;
    }
}