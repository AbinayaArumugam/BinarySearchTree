package com.binarysearchtree;

import java.util.Scanner;

class Node1{
    int data;
    Node1 left,right;
    Node1(int item){
        data=item;
        left=right=null;
    }
}
class MinimumNode {
    static Node1 head;

    Node1 insert(Node1 node, int data) {
        if (node == null)
            return (new Node1(data));
        else if (data <= node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }


        static int minValue(Node1 node){
            Node1 current = node;
            while (current.left != null) {
                current = current.left;
            }
            return (current.data);
        }

    public static void main(String[] args) {
        MinimumNode tree = new MinimumNode();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the no of Element");
        int size = in.nextInt();
        System.out.println("Enter the Elements");
        Node1 root=null;
        for (int i = 0; i < size; i++) {
           root = tree.insert(root,in.nextInt());
        }
        System.out.println(minValue(root));
    }
}


