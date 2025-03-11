package TreeQs;
// COMPLETED
// Can be more optimized using MonotonicStack

public class MaximumBT654 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    static TreeNode helper(int[] arr, int start, int end){
        if(start > end) return null;
        System.out.println(start + " - " + end);

        int maxIndex = start;
        for(int i=start; i<=end; i++){
            if(arr[maxIndex] < arr[i]){
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(arr[maxIndex]);

        node.left = helper(arr, start, maxIndex-1);
        node.right = helper(arr, maxIndex+1, end);

        return node;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,6,0,5};
        System.out.println(constructMaximumBinaryTree(arr));
    }
}
