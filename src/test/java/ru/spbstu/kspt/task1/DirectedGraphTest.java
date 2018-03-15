package ru.spbstu.kspt.task1;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DirectedGraphTest {

    private static List<String> ArrayToList(String[] y) {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < y.length; i++) {
            str.add(y[i]);
        }
        return str;
    }

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

    List<List<Integer>> matrix0 = Array2DToList(new Integer[][]{{0, 3, 1, -9}, {0, 0, 99, 17}, {9, -1, 0, -1}, {1000, -999, 1314, 0}});
    List<String> names = ArrayToList(new String[]{"red", "yell", "blue", "green"});
    DirectedGraph graph = new DirectedGraph(matrix0, names);

    @Test
    public void getOutputList() {
        List<Pair<String, Integer>> list1 = new ArrayList<>();
        list1.add(new Pair<>("red", 3));
        list1.add(new Pair<>("yell", 0));
        list1.add(new Pair<>("blue", -1));
        list1.add(new Pair<>("green", -999));
        List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(new Pair<>("red", 0));
        list.add(new Pair<>("yell", 0));
        list.add(new Pair<>("blue", 9));
        list.add(new Pair<>("green", 1000));
        assertEquals(list1, graph.getOutputList("yell"));
        assertEquals(list, graph.getOutputList("red"));
    }

    @Test
    public void getInputList() {
        List<Pair<String, Integer>> list1 = new ArrayList<>();
        list1.add(new Pair<>("red", 9));
        list1.add(new Pair<>("yell", -1));
        list1.add(new Pair<>("blue", 0));
        list1.add(new Pair<>("green", -1));
        List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(new Pair<>("red", 1000));
        list.add(new Pair<>("yell", -999));
        list.add(new Pair<>("blue", 1314));
        list.add(new Pair<>("green", 0));
        assertEquals(list1, graph.getInputList("blue"));
        assertEquals(list, graph.getInputList("green"));
    }

    @Test
    public void addVertex() {
        List<List<Integer>> matrix1 = Array2DToList(new Integer[][]{{0, 3, 1, -9, null}, {0, 0, 99, 17, null}, {9, -1, 0, -1, null}, {1000, -999, 1314, 0, null},
                {null, null, null, null, null}});
        List<String> addName = ArrayToList(new String[]{"red", "yell", "blue", "green", "white"});
        DirectedGraph graphA = new DirectedGraph(matrix1, addName);
        assertEquals(graphA, graph.addVertex("white"));
    }

    @Test
    public void deleteVertex() {
        List<List<Integer>> matrixD = Array2DToList(new Integer[][]{{0, 1, -9}, {9, 0, -1}, {1000, 1314, 0}});
        List<String> nameD = ArrayToList(new String[]{"red", "blue", "green"});
        DirectedGraph graphD = new DirectedGraph(matrixD, nameD);
        assertEquals(graphD, graph.deleteVertex("yell"));
    }

    @Test
    public void renameVertex() {
        List<String> nameR = ArrayToList(new String[]{"pink", "yell", "blue", "green"});
        DirectedGraph graphR = new DirectedGraph(matrix0, nameR);
        List<String> nameR1 = ArrayToList(new String[]{"red", "yellow", "blue", "green"});
        DirectedGraph graphR1 = new DirectedGraph(matrix0, nameR1);

        assertEquals(graphR, graph.renameVertex("red", "pink"));
        assertEquals(graphR1, graph.renameVertex("yell", "yellow"));
    }

    @Test
    public void addEdge() {
        List<List<Integer>> matrixAE = Array2DToList(new Integer[][]{{0, 3, 1, -9}, {0, 0, 99, 17}, {9, -1, 0, -1}, {119, -999, 1314, 0}});
        DirectedGraph graphAE = new DirectedGraph(matrixAE, names);
        List<List<Integer>> matrixAE1 = Array2DToList(new Integer[][]{{0, 3, 1, -9}, {666, 0, 99, 17}, {9, -1, 0, -1}, {1000, -999, 1314, 0}});
        DirectedGraph graphAE1 = new DirectedGraph(matrixAE1, names);

        assertEquals(graphAE, graph.addEdge("red", "green", 119));
        assertEquals(graphAE1, graph.addEdge("red", "yell", 666));
    }

    @Test
    public void deleteEdge() {
        List<List<Integer>> matrixDE = Array2DToList(new Integer[][]{{0, 3, 1, -9}, {0, 0, 99, null}, {9, -1, 0, -1}, {1000, -999, 1314, 0}});
        DirectedGraph graphDE = new DirectedGraph(matrixDE, names);
        List<List<Integer>> matrixDE1 = Array2DToList(new Integer[][]{{0, 3, 1, -9}, {0, 0, 99, 17}, {null, -1, 0, -1}, {1000, -999, 1314, 0}});
        DirectedGraph graphDE1 = new DirectedGraph(matrixDE1, names);

        assertEquals(graphDE1, graph.deleteEdge("red", "blue"));
        assertEquals(graphDE, graph.deleteEdge("green", "yell"));

    }

    @Test
    public void renameEdge() {
        List<List<Integer>> matrixRE = Array2DToList(new Integer[][]{{0, 3, 520, -9}, {0, 0, 99, 17}, {9, -1, 0, -1}, {1000, -999, 1314, 0}});
        DirectedGraph graphRE = new DirectedGraph(matrixRE, names);
        List<List<Integer>> matrixRE1 = Array2DToList(new Integer[][]{{0, 3, 1, -9}, {0, 0, 250, 17}, {9, -1, 0, -1}, {1000, -999, 1314, 0}});
        DirectedGraph graphRE1 = new DirectedGraph(matrixRE1, names);

        assertEquals(graphRE, graph.renameEdge("blue", "red", 520));
        assertEquals(graphRE1, graph.renameEdge("blue", "yell", 250));
    }
}
