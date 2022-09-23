package test.tree;

import java.util.*;

public class Tree {
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
    //初始化一个
  /*  public static TreeNode initTree() {

    }*/

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

    //判断两个子树是否为相同的子树
    //递归判断，所有都为ture,才是相同
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
    //翻转二叉树
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


    //二叉树的中序遍历（递归）
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

    //二叉树的前序遍历（迭代）
    public static List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();  //取出栈尾元素
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
    //二叉树的后序遍历（迭代）
    public static List<Integer> postorderTraversal(TreeNode root) {
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
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> path = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        findPath(root, target);
        return res;
    }
    //     10
    //    / \
    //  5   12
    // / \
    //4   7
    //        TreeNode a = new TreeNode(10);
    //        TreeNode b = new TreeNode(5);
    //        TreeNode c = new TreeNode(12);
    //        TreeNode d = new TreeNode(4);
    //        TreeNode e = new TreeNode(7);
    //        a.left=b;
    //        a.right=c;
    //        b.left=d;
    //        b.right=e;
    //  System.out.println(test.tree.Tree.FindPath(a,22));
    //用减法，先序递归深度遍历，先10，如果不是目标值，22-10，就递归子树，如果不是22-10继续递归，直到叶子节点，
    public static void findPath(TreeNode root, int target) {
        //因为FindPath中和 下面程序中都进行了判null操作，root绝对不可能为 null
        path.add(root.val);
        //已经到达叶子节点，并且正好加出了target
        if (root.val == target && root.left == null && root.right == null) {
            //将该路径加入res结果集中
            res.add(new ArrayList(path));
        }
        //如果左子树非空，递归左子树
        if (root.left != null) {
            findPath(root.left, target - root.val);
        }
        //如果右子树非空，递归右子树
        if (root.right != null) {
            findPath(root.right, target - root.val);
        }
        //无论当前路径是否加出了target，必须去掉最后一个，然后返回父节点，去查找另一条路径，最终的path肯定为null
        path.remove(path.size() - 1);
        return;
    }
    // 全局变量，记录最大直径
    static int diameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return diameter;
    }
    // 此函数是返回树的最大深度
    private static int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        diameter = Math.max(diameter, l + r);  //最大直径
        return Math.max(l, r) + 1;        //最大深度
    }
    //广度优先遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> lists=new ArrayList<Integer>();
        if(root==null)
            return lists;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tree=queue.poll();
            if(tree.left!=null)
                queue.offer(tree.left);
            if(tree.right!=null)
                queue.offer(tree.right);
            lists.add(tree.val);
        }
        return lists;
    }
   //深度优先遍历，后序遍历
   public static ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
       ArrayList<Integer> lists=new ArrayList<Integer>();
       if(root==null)
           return lists;
       Stack<TreeNode> stack=new Stack<TreeNode>();
       stack.push(root);
       while(!stack.isEmpty()){
           TreeNode tree=stack.pop();
      //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
           if(tree.right!=null)
               stack.push(tree.right);
           if(tree.left!=null)
               stack.push(tree.left);
           lists.add(tree.val);
       }
       return lists;
   }

    //二叉树转数组
    public static List flattn(TreeNode root,List<Integer> aa){
        if(root==null) System.out.println("erorr");
        aa.add(root.val);
        if(root.left!=null) {
            flattn(root.left,aa);
        }
        if(root.right!=null){
            flattn(root.right,aa);
        }
        return aa;
    }
    //二叉树转化为链表结构
    public static void flatten(TreeNode root){
        if(root==null) return;
        flatten(root.left);
        flatten(root.right); //先分别将左右子树转变为链表
        if(root.left!=null){
            TreeNode tmp=root.right;
            root.right=root.left;
            root.left=null;
            if(null!=tmp){
                TreeNode t=root.right;  //将根节点，左子树链表，右子树链表合并为一个链表
                while (null!=t.right){
                    t=t.right;
                }
                t.right=tmp;
            }
        }
    }
    //打印二叉树
    public static void midTran(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        if (root.left != null)
            midTran(root.left);
        if (root.right != null)
            midTran(root.right);
    }
    //合并二叉树
    public static TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        return mergeCore(root1, root2);
    }
    public static TreeNode mergeCore(TreeNode root1, TreeNode root2) {
        if (root2 != null) {
            root1.val += root2.val;
            if (root1.left == null)
                root1.left = root2.left;
            else
                mergeCore(root1.left, root2.left);
            if (root1.right == null)
                root1.right = root2.right;
            else
                mergeCore(root1.right, root2.right);
        }
        return root1;
    }
    //根到叶子最大路径和
    static int temp=0;
    static int max=0;
   /* public static Integer maxAdd1(TreeNode root){

       return maxAdd(root,temp);
    }*/
    public static Integer maxAdd(TreeNode root){
        if(root==null){
            return 0;
        }
        temp=temp+root.val;
        if(root.left==null&&root.right==null){
            if(temp>max) max=temp;
            temp=temp-root.val;
            //temp=0;
        }
        if(root.left!=null){
            maxAdd(root.left);
        }
        //;
        if(root.right!=null){
            maxAdd(root.right);
        }
        //temp=temp-root.val;
        return max;
    }
}
