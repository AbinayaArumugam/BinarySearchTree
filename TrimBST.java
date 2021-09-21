package com.binarysearchtree;

import java.util.Scanner;

public class TrimBST {
    static class Node {
        int data;
        Node left, right;

        public  Node(int item) {
            data =item;
            left=right=null;
        }
    }
    static Node root;
    Node insert(Node root, int data){
        if(root==null){
            return (new Node(data));
        }
        if(data<= root.data){
            root.left=insert(root.left,data);
        } else {
            root.right=insert(root.right,data);
        }
        return root;
    }
    void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    static Node removeRange(Node root,int min,int max){
        if(root==null){
            return null;
        }
        root.left=removeRange(root.left,min,max);
        root.right=removeRange(root.right,min,max);
        if(root.data<min){
            Node rChild=root.right;
            root=null;
            return rChild;
        }
        if(root.data>max){
            Node lChild=root.left;
            root=null;
            return lChild;
        }
        return root;
    }
    public static void main(String[] args){
        TrimBST tree=new TrimBST();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the no of Element");
        int size = in.nextInt();
        System.out.println("Enter the Elements");
        int[] arr = new int[size];
        Node root=null;
        for (int i = 0; i < size; i++) {
            root=tree.insert(root,in.nextInt());
        }
        tree.inOrder(root);
        System.out.println();
        System.out.println("Enter the Min val");
        int min=in.nextInt();
        System.out.println("Enter the Max val");
        int max=in.nextInt();
        root=removeRange(root,min,max);
        tree.inOrder(root);


    }
}
