package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void setRoot(Node elem) {
        this.root = elem;
    }

    public List<Node> getOrderedNotes() {
        List<Node> list = new ArrayList<Node>();
        inOrderTreeWalk(list, root);
        return list;
    }

    private void inOrderTreeWalk(List<Node> list, Node x) {
        if (x != null) {
            inOrderTreeWalk(list, x.getLeft());
            list.add(x);
            inOrderTreeWalk(list, x.getRight());
        }
    }

    public Node treeSearch(int key) {
        Node x = root;
        while (x != null && x.getValue() != key) {
            if (x.getValue() > key) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        return x;
    }

    public void insert(int key) {
        Node z = new Node(key);
        Node x = root;
        Node y = null;
        while (x != null) {
            y = x;
            if (z.getValue() < x.getValue()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
            z.setParent(y);
        }
        if (y == null) {
            root = z;
        } else {
            if (z.getValue() < y.getValue()) {
                y.setLeft(z);
            } else {
                y.setRight(z);
            }
        }
    }

    public void delete(int key) {
        Node x;
        Node y;
        Node z = (Node) treeSearch(key);
        if (z.getLeft() == null || z.getRight() == null) {
            y = z;
        } else {
            y = treeSuccessor(z);
        }
        if (y.getLeft() != null) {
            x = y.getLeft();
        } else {
            x = y.getLeft();
        }
        if (y.getParent() == null) {
            root = x;
        } else {
            if (y == y.getParent().getLeft()) {
                y.getParent().setLeft(x);
            } else {
                y.getParent().setRight(x);
            }
        }
        if (y != z) {
            z.setValue(y.getValue());
        }
    }

    private Node treeMinimum(Node x) {
        while (x.getLeft() != null) {
            x.getLeft();
        }
        return x;
    }

    private Node treeSuccessor(Node x) {
        if (x.getRight() != null) {
            return treeMinimum(x.getRight());
        }
        Node y = x.getParent();
        while (y != null && x == y.getRight()) {
            x = y;
            y = y.getParent();
        }
        return y;
    }

    public class Node {
        private int key;
        private Node left;
        private Node right;
        private Node parent;

        Node(int value) {
            this.key = value;
        }

        void setValue(int key) { this.key = key; }

        int getValue() {
            return key;
        }

        Node getLeft() {
            return left;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        Node getRight() {
            return right;
        }

        void setRight(Node right) {
            this.right = right;
        }

        Node getParent() {
            return parent;
        }

        void setParent(Node parent) {
            this.parent = parent;
        }


    }
}
