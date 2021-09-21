package com.algorithm.vincent.algorithms.mindepthofbinarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class TreeDeep {

    public static void main(String[] args) {


        TreeNode node7 = new TreeNode(7,null, null);
        TreeNode node6 = new TreeNode(6,node7, null);
        TreeNode node5 = new TreeNode(5,null, null);
        TreeNode node4 = new TreeNode(4,null, null);
        TreeNode node3 = new TreeNode(3,node6, null);
        TreeNode node2 = new TreeNode(2,node4, node5);
        TreeNode node1 = new TreeNode(1,node2, node3);

        // 最小深度-深度优先
//        System.out.println(minDepthDFS(node1));
        // 最大深度-深度优先
//        System.out.println(maxDepthDFS(node1));
        // 最小深度-广度优先
//        System.out.println(minDepthBFS(node1));
        // 递归方法的前, 中, 后序遍历, 层序遍历
//        preOrderedTraversal(node1);
//        inOrderedTraversal(node1);
//        postOrderedTraversal(node1);
//        ArrayList<Integer> result  = new ArrayList<>();
//        levelOrderTraversal(node1, 1, result);
//        System.out.println(result);
//         非递归方式的 前序遍历
//        preOrderTraversalNoRecursive(node1);
        // 非递归方式的 中序遍历
//        inOrderTraversalNoRecursive(node1);
        // 非递归方式的 后序遍历
//        postOrderedTraversalNoRecursive(node1);
        // 非递归方式的 层序遍历
        levelOrderedTraversalNoRecursive(node1);
    }

    public static int minDepthDFS(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return minDepthDFS(root.right) + 1;
        }
        if(root.right == null){
            return minDepthDFS(root.left) + 1;
        }
        return Math.min(minDepthDFS(root.left), minDepthDFS(root.right)) + 1;
    }

    public static int maxDepthDFS(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return maxDepthDFS(root.right) + 1;
        }
        if(root.right == null){
            return maxDepthDFS(root.left) + 1;
        }
        return Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right)) + 1;
    }

    public static int minDepthBFS(TreeNode root){

        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        root.deep = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null){
                return node.deep;
            }
            if(node.left != null){
                node.left.deep = node.deep + 1;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.deep = node.deep + 1;
                queue.offer(node.right);
            }
        }
        return 0;
    }

    public static void preOrderedTraversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        System.out.println(treeNode.val);
        preOrderedTraversal(treeNode.left);
        preOrderedTraversal(treeNode.right);
    }
    public static void inOrderedTraversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        inOrderedTraversal(treeNode.left);
        System.out.println(treeNode.val);
        inOrderedTraversal(treeNode.right);
    }

    public static void postOrderedTraversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        postOrderedTraversal(treeNode.left);
        postOrderedTraversal(treeNode.right);
        System.out.println(treeNode.val);

    }

    public static void levelOrderTraversal(TreeNode root, int i, ArrayList list){
        if(root == null){
            return ;
        }
        int length = list .size();
        if(length <= i){
            for(int j = 0; j <= i -length; j++){
                list.add(length + j, null);
            }
        }
        list.set(i, root.val);
        levelOrderTraversal(root.left, 2 * i, list);
        levelOrderTraversal(root.right, 2 * i + 1, list);
    }

    public static void preOrderTraversalNoRecursive(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                if(root != null){
                    System.out.println(root.val);
                    stack.push(root.right);
                    stack.push(root.left);
                }
            }
        }
    }

    public static void inOrderTraversalNoRecursive(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            while(root != null || !stack.isEmpty()){
                if(root != null){
                    stack.push(root);
                    root = root.left ;
                }else{
                    root = stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }

    public static void postOrderedTraversalNoRecursive(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            while(root != null || !stack.isEmpty()){
                while(root != null){
                    stack.push(root);
                    root = root.left ;
                }
                root = stack.pop();
                if(root.right == null || root.right == prev){
                    System.out.println(root.val);
                    prev = root;
                    root = null;
                }else{
                    stack.push(root);
                    root = root.right;
                }
            }
        }
    }

    public static void levelOrderedTraversalNoRecursive(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        if(root != null){
            queue.offer(root);
            while(!queue.isEmpty()){
                root = queue.poll();
                System.out.println(root.val);
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
        }
    }

    public static void morrisPre(TreeNode cur){
        if(cur == null){
            return ;
        }
        TreeNode mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null ){
                    // 建立线索指针
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    // mostRight.right == cur 删除线索指针
                    mostRight.right = null;
                }
            }else {
                cur = cur.right;
            }

        }

    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int deep;
        TreeNode(int val, TreeNode left,  TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
