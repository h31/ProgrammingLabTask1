package binarySearchTree;


import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void InsertTest() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(6);
        tree.insert(4);
        tree.insert(1);
        tree.insert(7);
        tree.insert(14);
        tree.insert(13);
        Assert.assertEquals(tree.treeSearch(1).getValue(),1);
        Assert.assertEquals(tree.treeSearch(3).getValue(),3);
        Assert.assertEquals(tree.treeSearch(4).getValue(),4);
        Assert.assertEquals(tree.treeSearch(6).getValue(),6);
        Assert.assertEquals(tree.treeSearch(7).getValue(),7);
        Assert.assertEquals(tree.treeSearch(8).getValue(),8);
        Assert.assertEquals(tree.treeSearch(10).getValue(),10);
        Assert.assertEquals(tree.treeSearch(14).getValue(),14);
        Assert.assertEquals(tree.treeSearch(13).getValue(),13);
    }
}
