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

    public List<Node> getOrderedNodes() {
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
        Node newNode = new Node(key);
        Node x = root;
        Node y = null;
        while (x != null) {
            y = x;
            if (newNode.getValue() < x.getValue()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
            newNode.setParent(y);
        }
        if (y == null) {
            root = newNode;
        } else {
            if (newNode.getValue() < y.getValue()) {
                y.setLeft(newNode);
            } else {
                y.setRight(newNode);
            }
        }
    }

    public void delete(int key) {
        Node x;
        Node y;
        Node newNode = (Node) treeSearch(key);
        if (newNode.getLeft() == null || newNode.getRight() == null) {
            y = newNode;
        } else {
            y = treeSuccessor(newNode);
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
        if (y != newNode) {
            newNode.setValue(y.getValue());
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

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }

    public class Node {


        private int key;
        private Node left;
        private Node right;
        private Node parent;

        Node(int value) {
            this.key = value;
        }

        void setValue(int key) {
            this.key = key;
        }

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


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (key != node.key) return false;
            if (left != null ? !left.equals(node.left) : node.left != null) return false;
            if (right != null ? !right.equals(node.right) : node.right != null) return false;
            return parent != null ? parent.equals(node.parent) : node.parent == null;
        }

        @Override
        public int hashCode() {
            int result = key;
            result = 31 * result + (left != null ? left.hashCode() : 0);
            result = 31 * result + (right != null ? right.hashCode() : 0);
            result = 31 * result + (parent != null ? parent.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + left +
                    ", right=" + right +
                    ", parent=" + parent +
                    '}';
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinarySearchTree that = (BinarySearchTree) o;

        return root != null ? root.equals(that.root) : that.root == null;
    }

    @Override
    public int hashCode() {
        return root != null ? root.hashCode() : 0;
    }
}
