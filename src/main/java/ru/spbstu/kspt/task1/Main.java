package ru.spbstu.kspt.task1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main class
 */


public class Main {

    private static List<List<Integer>> Array2DToList(Integer[][] x) {
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < x[i].length; j++) {
                List<Integer> list = matrix.get(i);
                list.add(x[i][j]);
                matrix.set(i, list);
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        List<List<Integer>> matrix0 = Array2DToList(new Integer[][]{{0, 3, 1, -9}, {0, 0, 99, 17}, {9, -1, 0, -1}, {1000, -999, 1314, 0}});
        List<String> names = Arrays.asList(new String[]{"red", "yell", "blue", "green"});
        DirectedGraph directGraph = new DirectedGraph(matrix0, names);

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
