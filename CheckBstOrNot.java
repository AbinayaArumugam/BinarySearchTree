package com.binarysearchtree;

import java.util.Scanner;

public class CheckBstOrNot {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            right = left = null;
        }
    }
    Node root;
    Node insert(Node root, int data){
    if(root==null){
        return (new Node(data));
    } else{
        if(data<= root.data){
            root.left=insert(root.left,data);
        }
        else{
            root.right=insert(root.right,data);
        }
    }
    return root;
}
    static boolean isBST(Node root, Node left, Node right) {
        if (root == null)
            return true;
        if (left != null && root.data <= left.data)
            return false;
        if (right != null && root.data <= right.data)
            return false;
        return isBST(root.left, left, root) && isBST(root.right, root, right);
    }

    public static void main(String[] args) {
      /*  Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(4);*/
        Scanner in = new Scanner(System.in);
        CheckBstOrNot tree =new CheckBstOrNot();
        System.out.println("Enter the no of Element");
        int size = in.nextInt();
        System.out.println("Enter the Elements");
        Node root=null;
        for (int i = 0; i < size; i++) {
            root =tree.insert(root,in.nextInt());
        }
        if(isBST(root,null,null))
            System.out.println("BST");
        else
            System.out.println("Not BST");
    }
}
