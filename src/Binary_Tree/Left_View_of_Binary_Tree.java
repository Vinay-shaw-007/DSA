package Binary_Tree;

import java.util.ArrayList;
import java.util.List;

import static Binary_Tree.Subtree_of_Another_Tree.createTree;

public class Left_View_of_Binary_Tree {

    public static void main(String[] args) {
        TreeNode root = createTree();

        for (Integer i :findLeftView(root)){
            System.out.print(i+" ");
        }

    }

    private static List<Integer> findLeftView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        leftView(root, ans, 0);
        return ans;
    }

    private static void leftView(TreeNode root, List<Integer> ans, int level) {
        if (root == null) return;
        if (ans.size() == level) ans.add(root.val);
        level++;
        leftView(root.left, ans, level);
        leftView(root.right, ans, level);
    }
}
