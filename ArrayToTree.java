package com.binarysearchtree;


import java.util.Scanner;

class Node2{
    int key;
    Node2 left,right;
    Node2(int item){
        key=item;
        left=right=null;
    }
}
public class ArrayToTree {
    static Node2 root;

    Node2 arrToBst(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node2 node = new Node2(arr[mid]);
        node.left = arrToBst(arr, start, mid - 1);
        node.right = arrToBst(arr, mid + 1, end);
        return node;
    }

    void preOrder(Node2 node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        ArrayToTree tree = new ArrayToTree();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no of Element");
        int size = in.nextInt();
        System.out.println("Enter the Elements");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = in.nextInt();
        }
        root=tree.arrToBst(arr,0,arr.length-1);
        tree.preOrder(root);
    }
}
