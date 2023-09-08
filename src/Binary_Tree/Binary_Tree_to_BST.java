package Binary_Tree;

import java.util.PriorityQueue;

public class Binary_Tree_to_BST {
    public static void main(String[] args) {
        System.out.println(binaryTreeToBST(new TreeNode(8)));
    }

    // Do inorder traversal of the tree and store the values and sort the values and again do the inorder traversal but in this time we'll update the values in the tree.
    static TreeNode binaryTreeToBST(TreeNode root) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        inOrder(root, pq, true);
        inOrder(root, pq, false);
        return root;
    }

    private static void inOrder(TreeNode root, PriorityQueue<Integer> pq, boolean isFillingPq) {
        if (root == null) return;

        inOrder(root.left, pq, isFillingPq);
        if (isFillingPq)
            pq.add(root.val);
        else {
            root.val = pq.remove();
        }
        inOrder(root.right, pq, isFillingPq);
    }
}
