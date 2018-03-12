package ru.spbstu.kspt.task1;


class Node {
    int date;
    Node left;
    Node right;
}

class BST {
    public Node creatNewNode(int k) {
        Node a = new Node();
        a.date = k;
        a.left = null;
        a.right = null;
        return a;
    }
    public Node insert(Node node, int val) {
        if (node == null) {
            return creatNewNode(val);
        }
        if (val < node.date) {
            node.left = insert(node.left, val);
        } else if (val > node.date) node.right = insert(node.right, val);
        return node;
    }
    public Node deleteElement(Node node, int key){
        Node newnode = node;
        while (newnode != null){
            if (newnode.date == key) {
                while (newnode.right != null){
                    newnode.date = newnode.right.date;
                    node = node.right;
                }

            }
            else if (newnode.date < key) newnode = newnode.left;
            else if (newnode.date > key) newnode = newnode.right;
        }
        return newnode;
    }
    public boolean searchElement(Node node, int key){
        while (node != null) {
            if (node.date == key) return true;
            else if (node.date < key) node = node.left;
            else if (node.date > key) node = node.right;
        }
        return false;
    }
    public int rightElement(Node node, int key){
        while (node != null) {
            if (node.date == key) return node.right.date;
            else if (node.date < key) node = node.left;
            else if (node.date > key) node = node.right;
        }
        return 0;
    }
    public int leftElement(Node node, int key){
        while (node != null) {
            if (node.date == key) return node.left.date;
            else if (node.date < key) node = node.left;
            else if (node.date > key) node = node.right;
        }
        return 0;
    }
    public int parentElement(Node node, int key){
        while (node != null) {
            if (node.right.date == key || node.left.date == key) return node.date;
            else if (node.date < key) node = node.left;
            else if (node.date > key) node = node.right;
        }
        return 0;
    }
}