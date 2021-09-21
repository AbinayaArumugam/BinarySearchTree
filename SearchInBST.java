package com.binarysearchtree;

import java.util.Scanner;

public class SearchInBST {
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

    static Node searchElement(Node root, int key) {
        if (root == null) {
            return null;
        } if(root.data==key){
            return root;
        }
        else if (root.data < key) {
            return searchElement(root.right, key);
        } else if (root.data > key) {
            return searchElement(root.left, key);
        }
        return root;
    }
    static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        SearchInBST tree = new SearchInBST();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no of Element");
        int size = in.nextInt();
        System.out.println("Enter the Elements");
        int[] arr = new int[size];
        Node root = null;
        for (int i = 0; i < size; i++) {
            root = tree.insert(root, in.nextInt());
        }
        System.out.println("Enter the key");
        int key = in.nextInt();
       root= searchElement(root,key);
       preOrder(root);
    }
}