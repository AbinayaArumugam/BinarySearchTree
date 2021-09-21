package com.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RangeSumBST {
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
    static int sum=0;
    int rangeSumBST(Node root,int left,int right){
        if(root==null){
            return 0;
        }
            if(root.data>=left&&root.data<=right){
                sum+=root.data;
                rangeSumBST(root.right,left,right);
                rangeSumBST(root.left,left,right);
            } else {
                if (root.data<left) {
                    return rangeSumBST(root.right, left, right);
                }
                if (root.data > right) {
                    return rangeSumBST(root.left, left, right);
                }
            }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RangeSumBST tree = new RangeSumBST();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        System.out.println("Enter the value of node1");
        int left = sc.nextInt();
        System.out.println("Enter the value of node2");
        int right= sc.nextInt();
        System.out.println(tree.rangeSumBST(root,left,right));
    }
}
