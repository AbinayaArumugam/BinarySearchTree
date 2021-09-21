package com.binarysearchtree;

import java.util.Scanner;

public class BinarySearchTreeDelete {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTreeDelete() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    void deleteKey(int key){
        root = deleteRec(root,key);
    }
    Node deleteRec(Node root,int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        }
        else if (key>root.key){
            root.right=deleteRec(root.right,key);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }
    int minValue(Node root){
        int min=root.key;
        while (root.left!=null){
            min=root.left.key;
            root=root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        BinarySearchTreeDelete tree = new BinarySearchTreeDelete();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no of Element");
        int size = in.nextInt();
        System.out.println("Enter the Elements");
        for (int i = 0; i < size; i++) {
            tree.insert(in.nextInt());
        }
        tree.inorder();
        System.out.println("Enter the element to delete");
        int key=in.nextInt();
        tree.deleteKey(key);
        tree.inorder();
    }
}
