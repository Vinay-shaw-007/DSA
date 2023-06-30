package Binary_Tree;


import static Binary_Tree.Subtree_of_Another_Tree.createTree;

public class Invert_Binary_Tree {
    public static void main(String[] args) {
        TreeNode node = createTree();
        System.out.println("After");
        TreeNode reverseNode = invertTree(node);
    }

    private static TreeNode invertTree(TreeNode node) {
        if (node == null) return null;

        TreeNode nodeLeft = node.left;
        TreeNode nodeRight = node.right;

        node.left = nodeRight;
        node.right = nodeLeft;

        invertTree(node.left);
        invertTree(node.right);

        return node;
    }
}
