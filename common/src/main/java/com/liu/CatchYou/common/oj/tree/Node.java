package com.liu.CatchYou.common.oj.tree;

/**
 * Created by simon.liu on 2018/3/1.
 */
public class Node {
    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value, Node leftNode, Node rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
