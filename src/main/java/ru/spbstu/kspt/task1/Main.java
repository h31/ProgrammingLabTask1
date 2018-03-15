package ru.spbstu.kspt.task1;


import java.util.ArrayList;
import java.util.List;

/**
 * Main class
 */
public class Main {

    public static void main(String[] args) {
        List<List<Integer>> mm = new ArrayList<>();
        List<Integer> m1 = new ArrayList<>();
        m1.add(0);
        m1.add(3);
        m1.add(1);
        m1.add(-9);
        mm.add(m1);
        List<Integer> m2 = new ArrayList<>();
        m2.add(0);
        m2.add(0);
        m2.add(99);
        m2.add(17);
        mm.add(m2);
        List<Integer> m3 = new ArrayList<>();
        m3.add(9);
        m3.add(-1);
        m3.add(0);
        m3.add(-1);
        mm.add(m3);
        List<Integer> m4 = new ArrayList<>();
        m4.add(1000);
        m4.add(-999);
        m4.add(1314);
        m4.add(0);
        mm.add(m4);
        List<String> name = new ArrayList<>();
        name.add("red");
        name.add("yell");
        name.add("blue");
        name.add("green");
        DirectGraph directGraph = new DirectGraph(mm, name);

        System.out.println(directGraph);

        System.out.println(directGraph.getOutputList("red"));
        System.out.println(directGraph.getInputList("green"));
        System.out.println(directGraph.addVertex("abc"));
        System.out.println(directGraph.deleteVertex("abc"));
        System.out.println(directGraph.renameVertex("yell", "yellow"));
        System.out.println(directGraph.renameVertex("yellow", "yell"));
        System.out.println(directGraph.addEdge("red", "yell", 666));
        System.out.println(directGraph.deleteEdge("red", "yell"));
        System.out.println(directGraph.renameEdge("blue", "red", 520));

    }
}
