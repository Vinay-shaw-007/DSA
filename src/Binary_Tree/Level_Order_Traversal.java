package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Binary_Tree.Subtree_of_Another_Tree.createTree;

public class Level_Order_Traversal {

    public static void main(String[] args) {
        TreeNode node = createTree();
        System.out.println();
        for (List<Integer> list: levelOrder(node)) {
            for (Integer i: list) {
                System.out.print(i+" ");
            }
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.add(root);

        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                    list.add(node.val);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
