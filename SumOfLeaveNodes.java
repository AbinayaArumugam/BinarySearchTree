package com.binarysearchtree;

import java.util.Scanner;

public class SumOfLeaveNodes {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static Node root;
static  int sum=0;
    Node insert(Node root, int data) {
        if (root == null) {
            return (new Node(data));
        }
        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
     int leafNode(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            sum+=root.data;
        }
        leafNode(root.left);
        leafNode(root.right);
        return sum;
     }
    public static void main(String[] args) {
        SumOfLeaveNodes tree = new SumOfLeaveNodes();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no of Element");
        int size = in.nextInt();
        System.out.println("Enter the Elements");
        int[] arr = new int[size];
        Node root = null;
        for (int i = 0; i < size; i++) {
            root = tree.insert(root, in.nextInt());
        }
        System.out.println(tree.leafNode(root));
    }
}
