public class FindBottomLeftTreeValue_513 {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
    }

    int maxLevel = 0;
    int result = 0;

    public int findBottomLeftValue(TreeNode root) {
        findNode(root, 0);
        return result;
    }

    public void findNode(TreeNode root, int level) {
        if(root!=null){
            level++;
            if(level>maxLevel){
                maxLevel=level;
                result=root.val;
            }
            findNode(root.left,level);
            findNode(root.right,level);
        }
    }
}
