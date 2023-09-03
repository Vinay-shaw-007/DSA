package Binary_Tree;


import java.util.Deque;
import java.util.LinkedList;

public class LeftMost_RightMost_Binary_Tree {
    public static void main(String[] args) {

    }

    public static void printCorner(TreeNode node)
    {

        // add your code here
        Deque<TreeNode> q = new LinkedList<>();
        q.add(node);
        helper(q);
    }

    private static void helper(Deque<TreeNode> q) {
        while (!q.isEmpty()) {
            TreeNode currNode, leftNode, rightNode;
            if (q.size() > 1) {
                leftNode = q.removeFirst();
                rightNode = q.removeLast();
                int size = q.size();

                if (leftNode.left != null) q.add(leftNode.left);
                if (leftNode.right != null) q.add(leftNode.right);

                while (size != 0) {
                    TreeNode temp = q.removeFirst();
                    if (temp.left != null) q.add(temp.left);
                    if (temp.right != null) q.add(temp.right);
                    size--;
                }

                if (rightNode.left != null) q.add(rightNode.left);
                if (rightNode.right != null) q.add(rightNode.right);

                System.out.print(leftNode.val+" "+rightNode.val+" ");

            } else {
               currNode = q.removeFirst();
                System.out.print(currNode.val+" ");
               if (currNode.left != null) q.add(currNode.left);
               if (currNode.right != null) q.add(currNode.right);
            }
        }
    }

}
