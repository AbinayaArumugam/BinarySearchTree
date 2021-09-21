package com.binarysearchtree;

import java.util.Scanner;

public class SumOfKSmallestElement {
   static class Node {
        int data;
        Node left, right;

        public  Node(int item) {
            data =item;
            left=right=null;
        }
    }
    static Node root;
   Node insert(Node root,int data){
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
   static int count=0;
   static int findSmallestRec(Node root,int k){
       if(root==null)
           return 0;
       if(count>k)
           return 0;
       int res=findSmallestRec(root.left,k);
       if (count>=k)
           return res;
       res+=root.data;
       count++;
       if (count>=k)
           return res;
       return res+findSmallestRec(root.right,k);
   }
   static int findSmallest(Node root,int k){
       int res=findSmallestRec(root,k);
       return res;
   }
   public static void main(String[] args){
       SumOfKSmallestElement tree=new SumOfKSmallestElement();
       Scanner in=new Scanner(System.in);
       System.out.println("Enter the no of Element");
       int size = in.nextInt();
       System.out.println("Enter the Elements");
       int[] arr = new int[size];
       Node root=null;
       for (int i = 0; i < size; i++) {
           root=tree.insert(root,in.nextInt());
       }
       System.out.println("Enter the count");
       int k=in.nextInt();
       int count=findSmallest(root,k);
       System.out.println(count);
   }
}
