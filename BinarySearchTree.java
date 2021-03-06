package com.binarysearchtree;

import java.util.Scanner;

public class BinarySearchTree {
    class Node{
        int key;
        Node left,right;
        public Node(int item){
            key=item;
            left=right=null;
        }
    }
    Node root;
    BinarySearchTree(){
        root=null;
    }
    void insert(int key){
        root=insertRec(root,key);
    }
    Node insertRec(Node root,int key){
       if(root==null){
           root=new Node(key);
           return root;
       }
       if(key<root.key) {
           root.left = insertRec(root.left, key);
       }
       else if (key>root.key ){
           root.right=insertRec(root.right,key);
       }
       return root;
    }
    void inorder(){
        inorderRec(root);
    }
    void inorderRec(Node root){
        if(root!=null){
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    public static void main(String[] args){
        BinarySearchTree tree=new BinarySearchTree();
       Scanner in=new Scanner(System.in);
        System.out.println("Enter the no of Element");
        int size=in.nextInt();
        System.out.println("Enter the Elements");
        for (int i=0;i<size;i++){
            tree.insert(in.nextInt());
        }
      /*  tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(1);
        tree.insert(5);
        tree.insert(6);*/
        System.out.println("Enter the Key");
        int key=in.nextInt();
        tree.insert(key);
        tree.inorder();


    }
}

