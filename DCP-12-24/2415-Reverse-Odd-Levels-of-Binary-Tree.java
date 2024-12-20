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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null)return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            int size= queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                levelNodes.add(curr);

                if(curr.left !=null){
                    queue.offer(curr.left);
                }
                if(curr.right !=null){
                    queue.offer(curr.right);
                }
            }

            if(level%2==1){
                int left =0;
                int right = levelNodes.size()-1;

                while(left<right){
                    int temp = levelNodes.get(left).val;
                    levelNodes.get(left).val = levelNodes.get(right).val;
                    levelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}