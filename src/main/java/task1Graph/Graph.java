package task1Graph;

import java.util.*;

public class Graph {

    private Map <String, Integer> vertices;
    private Vector<Arc> arcs;

    public class Arc {

        private String name;
        private int weight;
        private Integer begin;
        private Integer end;

        public void printArc() {
            System.out.println("Дуга " + name + ", соединяющая " + begin + " и " + end + ", вес = "+ weight);
        }

        Arc(String n, int w, String p1, String p2) {
            name = n;
            weight = w;
            begin = vertices.get(p1);
            end = vertices.get(p2);
        }

        public Integer getArcBegin() {
            return this.begin;
        }

        public Integer getArcEnd() {
            return end;
        }

        public String getArcName() {
            return name;
        }

        public int getArcWeight() {
            return weight;
        }
    }

    Graph(Map <String, Integer> vertices, Vector<Arc> arcs) {
        this.vertices = vertices;
        this.arcs = arcs;
    }

    public void addVertex(String name) {
        vertices.put(name, vertices.size() + 1);
    }

    public void addArc(String name, int weight, String firstVertex, String secondVertex) {
        Arc a = new Arc(name, weight, firstVertex, secondVertex);
        arcs.add(a);
    }

    public void deleteVertex(String vertexName) {
        vertices.remove(vertexName);
        for (int i = 0; i < arcs.size(); i++) {
            if (arcs.get(i).begin.equals(vertices.get(vertexName))) arcs.remove(i);
            if (arcs.get(i).end.equals(vertices.get(vertexName))) arcs.remove(i);
        }
    }

    public void deleteArc(String arcName) {
        for (int i = 0; i < arcs.size(); i++)
            if (arcs.get(i).name.equals(arcName)) arcs.remove(i);
    }

    public void changeVertexName(String oldName, String newName) {
        vertices.put(newName, vertices.get(oldName));
        vertices.remove(oldName);
    }

    public void changeArcWeight(String arcName, int newWeight) {
        for (Arc arc : arcs) if (arc.name.equals(arcName)) arc.weight = newWeight;
    }

    public ArrayList<String> getOutList(String vertexName) {
        ArrayList<String> result = new ArrayList();
        for (Arc arc : arcs) if (vertices.get(vertexName).equals(arc.begin)) result.add(arc.name);
        return result;
    }

    public ArrayList<String> getInList(String vertexName) {
        ArrayList<String> result = new ArrayList();
        for (Arc arc : arcs) if (vertices.get(vertexName).equals(arc.end)) result.add(arc.name);
        return result;
    }
}
