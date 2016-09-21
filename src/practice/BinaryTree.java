package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 二叉树（前序、中序、后序遍历）
 *
 * Created by admin on 16/9/4.
 */
public class BinaryTree {

    /**
     * 使用二叉链表结构实现
     * */
    private static class Node {

        private Node leftChild;

        private Node rightChild;

        private int data;

        private Node(Node leftChild, Node rightChild, int data) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.data = data;
        }
    }

    //--------------------------------递归实现遍历【递归实现代码比较清晰，但是效率较低】---------------------------------------

    /**
     * 前序遍历二叉树
     * */
    public static void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data);
            // 前序遍历左子树
            preOrder(node.leftChild);
            // 前序遍历右子树
            preOrder(node.rightChild);
        }
    }

    /**
     * 中序遍历二叉树
     * */

    public static void inOrder(Node node) {
        if(node != null) {
            // 中序遍历左子树
            inOrder(node.leftChild);
            System.out.print(node.data);
            // 中序遍历右子树
            inOrder(node.rightChild);
        }
    }

    /**
     * 后序遍历二叉树
     * */
    public static void postOrder(Node node) {
        if(node != null) {
            // 后序遍历左子树
            postOrder(node.leftChild);
            // 后序遍历右子树
            postOrder(node.rightChild);
            System.out.print(node.data);
        }
    }

    //--------------------------------非递归实现遍历-----------------------------------------------------------------------

    /**
     * 【前序】
     *  利用栈实现循环先序遍历二叉树
     *
     *  维护一个栈，将根节点入栈，然后只要栈不为空，出栈并访问，接着依次将访问节点的右节点、左节点入栈。
     *  这种方式应该是对先序遍历的一种特殊实现（看上去简单明了），但是不具备很好的扩展性，在中序和后序方式中不适用
     * */
     public static void preNodeStack(Node root) throws Exception {
         if(root == null) return;

         Stack<Node> stack = new Stack<Node>();
         stack.push(root);
         while (!stack.isEmpty()) {
             Node temp = stack.pop();
             System.out.print(temp.data);

             if(temp.rightChild != null) stack.push(temp.rightChild);
             if(temp.leftChild != null) stack.push(temp.leftChild);
         }
     }

    /**
     * 【中序】
     *  利用栈模拟递归过程实现循环中序遍历二叉树
     *  访问的时间是在左子树都处理完直到null的时候出栈并访问。
     * */
    public static void inOrderStack(Node root) throws Exception {
        if(root == null) return;

        Stack<Node> stack = new Stack<Node>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftChild;
            }

            root = stack.pop();
            System.out.print(root.data);
            root = root.rightChild;// 如果是null，出栈并处理右子树
        }
    }

    /**
     * 【后序】
     *
     *  后序遍历不同于先序和中序，它是要先处理完左右子树，然后再处理根(回溯)，
     *  所以需要一个记录哪些节点已经被访问的结构(可以在树结构里面加一个标记)，这里可以用map实现
     * */
    public static void postOrderStack(Node root) throws Exception {
        if(root == null) return;

        Stack<Node> stack = new Stack<Node>();
        Map<Node, Boolean> map = new HashMap<Node, Boolean>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.peek();

            if(temp.leftChild != null && !map.containsKey(temp.leftChild)) {
                temp = temp.leftChild;
                while (temp != null) {
                    if (map.containsKey(temp)) break;
                    else stack.push(temp);

                    temp = temp.leftChild;
                }
                continue;
            }
            if(temp.rightChild != null && !map.containsKey(temp.rightChild)) {
                stack.push(temp.rightChild);
                continue;
            }

            Node t = stack.pop();
            map.put(t, true);
            System.out.println(t.data);
        }
    }

    //---------------------------------广度优先遍历【层次遍历】------------------------------------------------------------

    /**
     * 层序遍历二叉树，用队列实现，先将根节点入队列，只要队列不为空，然后出队列，并访问，接着讲访问节点的左右子树依次入队列
     * */
    public static void levelTravel(Node root) {
        if(root == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.println(temp.data);

            if (temp.leftChild != null) q.add(temp.leftChild);
            if (temp.rightChild != null) q.add(temp.rightChild);
        }
    }

    //---------------------------------已知前序中序求后序-----------------------------------------------------------------

    public static String posOrder(String pre, String mid) {
        if(pre.length() != mid.length()) return null;

        if(pre.length() == 1) return pre;
        else if(pre.length() == 0) return "";

        int m = mid.indexOf(pre.charAt(0));
        return posOrder(pre.substring(1, m + 1), mid.substring(0, m)) + posOrder(pre.substring(m + 1), mid.substring(m + 1)) + pre.charAt(0);
    }

}
