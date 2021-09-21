package com.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModesInBST {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.left, data);
        }
        return root;
    }
    int currVal;
    int count=0;
    int max=0;
    public int[] findMode(Node root){

        List<Integer> list= new ArrayList<>();
        traverse(root,list);
        int[] result=new int[list.size()];
        for (int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
    private void traverse(Node node,List<Integer> list) {
        if (node == null)
            return;
        traverse(node.left, list);
        handleValues(node, list);
        traverse(node.right, list);
    }
    private void handleValues(Node node,List<Integer> list){
            if(currVal!=node.data) {
                currVal=node.data;
                count=0;
            }  count++;

        if(count>max){
            list.clear();
            list.add(currVal);
            max=count;
        } else if(count==max){
            list.add(currVal);
        } else {
            count++;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ModesInBST tree = new ModesInBST();
        System.out.println("Enter the size");
        int size = in.nextInt();
        System.out.println("Enter the Array Elements");
        int[] arr = new int[size];
        Node root = null;
        for (int i = 0; i < size; i++) {
            root = tree.insert(root, in.nextInt());
        }
       int[] res=tree.findMode(root);
        for (int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }

    }
}