package com.binarysearchtree;

import java.util.Scanner;


public class LeastCommonAncestor {
    class Node{
        int data;
        Node left,right;
        Node(int item){
            data=item;
            left=right=null;
        }
    }
    Node root;
    Node insert(Node root,int data){
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
    Node lca(Node root,int n1,int n2){
        if(root==null)
            return null;
        if(root.data>n1&&root.data>n2){
            return lca(root.left,n1,n2);
        } else if(root.data<n1&&root.data<n2){
            return lca(root.right,n1,n2);
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LeastCommonAncestor tree =new LeastCommonAncestor();
        System.out.println("Enter the no of Element");
        int size = in.nextInt();
        System.out.println("Enter the Elements");
        Node root=null;
        for (int i = 0; i < size; i++) {
            root =tree.insert(root,in.nextInt());
        }


        System.out.println("Enter the data ");
        int n1=in.nextInt();
        System.out.println("Enter the data ");
        int n2=in.nextInt();
        Node t=tree.lca(tree.root,n1,n2);
        System.out.println(t.data);
    }
}
