package com.binarysearchtree;

import java.util.Scanner;

public class MinimumAbsoluteDiff {
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
static Node prev;
    static int ans;
    static void inOrder(Node curr){
        if(curr==null){
            return;
        }
        inOrder(curr.left);
        if(prev!=null){
            ans=Math.min(curr.data-prev.data,ans);
        }
        prev=curr;
        inOrder(curr.right);
    }
    static int minDiff(Node root){
        prev=null;
        ans=Integer.MAX_VALUE;
        inOrder(root);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinimumAbsoluteDiff tree = new MinimumAbsoluteDiff();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        System.out.println(minDiff(root));
    }
}
