package Binary_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static Binary_Tree.Subtree_of_Another_Tree.createTree;

public class ZigZag_Traversal {

    public static void main(String[] args) {
        TreeNode root = createTree();
        for (Integer i : traverseZigZag(root)) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> traverseZigZag(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        boolean leftToRight = true;
        ms.add(root);
        while (!ms.isEmpty()) {
            TreeNode temp = ms.pop();

            ans.add(temp.val);

            if (leftToRight) {
                if (temp.left != null)
                    cs.add(temp.left);
                if (temp.right != null)
                    cs.add(temp.right);
            } else {
                if (temp.right != null)
                    cs.add(temp.right);
                if (temp.left != null)
                    cs.add(temp.left);
            }

            if (ms.isEmpty()) {
                leftToRight = !leftToRight;
                ms = cs;
                cs = new Stack<>();
            }
        }

        return ans;
    }
}
