package ru.spbstu.kspt.task1;


import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DirectGraphTest1 {

    public DirectGraph tu() {
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
        List<String> nname = new ArrayList<>();
        nname.add("red");
        nname.add("yell");
        nname.add("blue");
        nname.add("green");
        DirectGraph directGraph = new DirectGraph(mm, nname);
        return directGraph;
    }

    @org.junit.Test
    public void output() {
        List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(new Pair<>("red", 0));
        list.add(new Pair<>("yell", 0));
        list.add(new Pair<>("blue", 9));
        list.add(new Pair<>("green", 1000));
        assertEquals(list, tu().output("red"));
    }

    @Test
    public void input() {
        List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(new Pair<>("red", 1000));
        list.add(new Pair<>("yell", -999));
        list.add(new Pair<>("blue", 1314));
        list.add(new Pair<>("green", 0));
        assertEquals(list, tu().input("green"));
    }

    DirectGraph addV(String str) {
        DirectGraph yuantu = tu();
        int i;
        List<String> names = yuantu.name;
        names.add(str);
        int size = names.size();
        List<List<Integer>> m0 = yuantu.matrix;
        for (i = 0; i < size; i++)
            if (i >= yuantu.matrix.size()) m0.add(new ArrayList<>());
        yuantu.matrix = m0;
        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j >= yuantu.matrix.get(i).size()) {
                    List<Integer> list = yuantu.matrix.get(i);
                    list.add(null);
                    m0.set(i, list);
                }
            }
            yuantu.matrix = m0;
        }
        return yuantu;
    }

    @Test
    public void addVertex() {
        assertEquals(addV("white"),tu().addVertex("white"));
        assertEquals(addV("abc"), tu().addVertex("abc"));
    }

    DirectGraph deleteV(String str) {
        DirectGraph tu0 = tu();
        int i, ver;
        ver = tu0.name.indexOf(str);
        if (ver == -1) throw new IllegalArgumentException("There's no this vertex");
        for (i = 0; i < tu0.matrix.size(); i++) {
            List<Integer> list = tu0.matrix.get(i);
            list.remove(ver);
            tu0.matrix.set(i, list);
        }
        tu0.matrix.remove(ver);
        tu0.name.remove(ver);
        return tu0;
    }

    @Test
    public void deleteVertex() {
        assertEquals(deleteV("yell"), tu().deleteVertex("yell"));
        assertEquals(deleteV("red"), tu().deleteVertex("red"));

    }

    DirectGraph renameV(String now, String old) {
        DirectGraph yuantu = tu();
        int oldNumber = yuantu.name.indexOf("yell");
        if (oldNumber == -1) throw new IllegalArgumentException("There's no this vertex");
        yuantu.name.set(oldNumber, "yellow");
        int i;
        int size = yuantu.name.size();
        List<List<Integer>> m0 = yuantu.matrix;
        for (i = 0; i < size; i++)
            if (i >= yuantu.matrix.size()) m0.add(new ArrayList<>());
        yuantu.matrix = m0;
        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j >= yuantu.matrix.get(i).size()) {
                    List<Integer> list = yuantu.matrix.get(i);
                    list.add(null);
                    m0.set(i, list);
                }
            }
            yuantu.matrix = m0;
        }
        return yuantu;
    }

    @Test
    public void renameVertex() {
        assertEquals(renameV("red", "pink"), tu().renameVertex("red", "pink"));
        assertEquals(renameV("yell", "yellow"), tu().renameVertex("yell", "yellow"));
    }

    private DirectGraph changeEdge(String begin, String end, Integer number) {
        int i;
        DirectGraph graph0 = tu();
        int endNumber = graph0.name.indexOf(end);
        int beginNumber = graph0.name.indexOf(begin);
        if (endNumber == -1 || beginNumber == -1) throw new IllegalArgumentException("There's no this vertex");
        List<Integer> list = graph0.matrix.get(endNumber);
        list.remove(beginNumber);
        list.add(beginNumber, number);
        graph0.matrix.set(endNumber, list);

        int size = graph0.name.size();
        if (graph0.matrix.size() > graph0.name.size()) size = graph0.matrix.size();
        for (i = 0; i < graph0.matrix.size(); i++) {
            if (graph0.matrix.get(i).size() > size) size = graph0.matrix.get(i).size();
        }
        for (i = graph0.name.size(); i < size; i++) {
            String string = Integer.toString(i + 1);
            tu().name.add(string);
        }
        for (i = 0; i < graph0.name.size(); i++) {
            if (graph0.name.lastIndexOf(graph0.name.get(i)) != i) throw new IllegalArgumentException("Duplicate name");
        }
        return graph0;
    }

    @Test
    public void addEdge() {
        assertEquals(changeEdge("red", "green", 119), tu().addEdge("red", "green", 119));
        assertEquals(changeEdge("red", "yell", 666), tu().addEdge("red", "yell", 666));
    }

    @Test
    public void deleteEdge() {
        assertEquals(changeEdge("green", "yell", null), tu().deleteEdge("green", "yell"));
        assertEquals(changeEdge("red", "yell", null), tu().deleteEdge("red", "yell"));
    }

    @Test
    public void renameEdge() {
        assertEquals(changeEdge("blue", "red", 520), tu().renameEdge("blue", "red", 520));
        assertEquals(changeEdge("blue", "yell", 250), tu().renameEdge("blue", "yell", 250));
    }
}
