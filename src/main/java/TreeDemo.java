import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeDemo {
    /**
     * 给定一个二叉树, 检查它是否是镜像对称的
     * 例如以下是镜像对称的
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * 下面这个则不是镜像对称的
     * 1
     * / \
     * 2   2
     * \   \
     * 3   3
     * TreeNode类的定义:
     *
     * @param TreeNode 一颗二叉树
     * @return boolean 是否是对称的
     */
    // 以下给出TreeNode类, 请勿修改
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isTreeSymmetric(TreeNode root) {
        //判断树是否为对称二叉树
        if (root == null) {
            return true;
        }
        ExchangeNode(root.right);
        boolean pop = isNotSameTree(root.left, root.right);
        return pop;
    }

    public static boolean ExchangeNode(TreeNode root) {
        //交换一个子树的左右节点
        if (root == null) {
            return false;
        }
        if (root != null) {
            TreeNode node = null;
            node = root.left;
            root.left = root.right;
            root.right = node;
        }
        ExchangeNode(root.left);
        ExchangeNode(root.right);
        return true;
    }

    /***
     * 判断两个子树是否为相同的子树
     * @param a
     * @param b
     * @return
     */
    public static boolean isNotSameTree(TreeNode a, TreeNode b) {
        if (a == null && b != null) {
            return false;
        }
        if (a != null && b == null) {
            return false;
        }
        if (a == null && b == null) {
            return true;
        }
        if (a.val != b.val) {
            return false;
        }
        return isNotSameTree(b.left, a.left) && isNotSameTree(b.right, a.right);
    }

    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 二叉树的中序遍历（递归）
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 二叉树的前序遍历（迭代）
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    /**
     * 二叉树的后序遍历（迭代）
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

}
