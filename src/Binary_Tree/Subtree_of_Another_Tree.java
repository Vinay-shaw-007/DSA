package Binary_Tree;

import java.util.Scanner;

public class Subtree_of_Another_Tree {
    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("Create Tree");
        TreeNode root = createTree();

        System.out.println("Create Sub Tree");
        TreeNode subRoot = createTree();

        System.out.println(isSubTree(root, subRoot));
    }

    private static TreeNode createTree() {
        TreeNode root;

        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1) return null;
        root = new TreeNode(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for " + data);
        root.right = createTree();

        return root;
    }

    private static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (subRoot == null) return true;

        if (sameTree(root, subRoot)) return true;

        return (isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot));
    }

    private static boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;

        if ((root != null && subRoot != null) && (root.val == subRoot.val)) {
            return (sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right));
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
