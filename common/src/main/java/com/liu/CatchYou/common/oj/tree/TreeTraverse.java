package com.liu.CatchYou.common.oj.tree;

/**
 * Created by simon.liu on 2018/3/1.
 */
public class TreeTraverse {
    public static void rootFirst(Node root) {
        if (root != null) {
            System.out.println(root.getValue());
            if (root.getLeftNode() != null) {
                rootFirst(root.getLeftNode());
            }
            if (root.getRightNode() != null) {
                rootFirst(root.getRightNode());
            }
        }
    }
    public static void rootMiddle(Node root) {
        if (root != null) {
            if (root.getLeftNode() != null) {
                rootFirst(root.getLeftNode());
            }
            System.out.println(root.getValue());
            if (root.getRightNode() != null) {
                rootFirst(root.getRightNode());
            }
        }
    }

    public static void rootLast(Node root) {
        if (root != null) {
            if (root.getLeftNode() != null) {
                rootFirst(root.getLeftNode());
            }
            if (root.getRightNode() != null) {
                rootFirst(root.getRightNode());
            }
            System.out.println(root.getValue());
        }
    }


    public static void main(String[] args) {
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);

        rootFirst(A);
    }
}
