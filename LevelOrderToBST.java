package com.binarysearchtree;

import java.util.Scanner;

public class LevelOrderToBST {
    static class Node{
        int data;
        Node left,right;
        public Node(int item){
            data=item;
            left=right=null;
        }
    }
   static Node root;
    Node insert(Node root, int data) {
        if (root == null) {
            return (new Node(data));
        } else {
            if (data <= root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
        }
        return root;
    }
        static void preOrder (Node root){
            if (root == null)
                return;
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        static Node levelOrder (Node root,int data){
            if (root == null) {
                root = new Node(data);
                return root;
            }

            if (data <= root.data) {
                root.left = levelOrder(root.left, data);
            } else {
                root.right = levelOrder(root.right, data);
            }
            return root;
        }
        static Node constructBST( int[] arr, int n){
            if (n == 0) {
                return null;
            }
            root = null;
            for (int i = 0; i < n; i++) {
                root = levelOrder(root, arr[i]);
            }
            return root;
        }
        public static void main (String[] args){
            Scanner in = new Scanner(System.in);
            LevelOrderToBST tree = new LevelOrderToBST();
            System.out.println("Enter the no of Element");
            int size = in.nextInt();
            System.out.println("Enter the Elements");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
             root=constructBST(arr,arr.length);
            preOrder(root);

        }
    }
