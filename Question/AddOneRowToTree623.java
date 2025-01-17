package Question;

public class AddOneRowToTree623 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    int gd;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            return new TreeNode(val, root, null);
        }
        // root = createRow(root, val, depth, 1);

        gd = depth;
        ans(root, val, 1);
        return root;
    }
    private void ans(TreeNode node, int val, int d){  // Most optimized
        if(node == null){
            return;
        }
        if(d == gd-1){
            TreeNode leftNode = new TreeNode(val);
            TreeNode rightNode = new TreeNode(val);

            leftNode.left = node.left;
            rightNode.right = node.right;

            node.left = leftNode;
            node.right = rightNode;

            return;
        }
        ans(node.left,val,d+1);
        ans(node.right,val,d+1);
    }
    private TreeNode createRow(TreeNode node, int val, int gd, int d){
        if(node == null){
            return node;
        }
        if(d == gd - 1){
            TreeNode leftNode = new TreeNode(val);
            leftNode.left = createRow(node.left,val,gd,d+1);

            TreeNode rightNode = new TreeNode(val);
            rightNode.right = createRow(node.right,val,gd,d+1);

            node.left = leftNode;
            node.right = rightNode;

            return node;
        }
        node.left = createRow(node.left,val,gd,d+1);
        node.right = createRow(node.right,val,gd,d+1);

        return node;
    }
}
