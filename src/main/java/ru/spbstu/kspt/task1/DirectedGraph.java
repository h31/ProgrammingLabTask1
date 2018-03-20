package ru.spbstu.kspt.task1;

import javafx.util.Pair;

import java.util.*;

public class DirectedGraph {

    private List<List<Integer>> matrix;
    private List<String> name;

    public DirectedGraph(List<List<Integer>> matrix, List<String> name) {
        if (matrix.size() != name.size()) throw new IllegalArgumentException("Extra vertex");

        this.matrix = new ArrayList<>(matrix);
        this.name = new ArrayList<>(name);

        Set<String> checkNames = new HashSet<>(name);
        if (name.size() != checkNames.size()) throw new IllegalArgumentException("Duplicate name");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DirectedGraph) {
            DirectedGraph directedGraph = (DirectedGraph) obj;
            return getMatrix().equals(directedGraph.getMatrix());
        }
        return false;
    }

    public int hashCode() {
        return getMatrix().hashCode() * 31 + getName().hashCode();
    }

    public List<List<Integer>> getMatrix() {
        List<List<Integer>> matrix0 = new ArrayList<>();
        matrix0.addAll(this.matrix);
        return matrix0;
    }

    public List<String> getName() {
        List<String> str = new ArrayList<>();
        str.addAll(this.name);
        return str;
    }

    private int maxLength() {
        int maxLength = 0;
        int i, length;
        for (i = 0; i < this.name.size(); i++) {
            if (this.name.get(i).length() > maxLength) {
                maxLength = this.name.get(i).length();
            }
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                if (this.matrix.get(i).get(j) != null) {
                    if (this.matrix.get(i).get(j) >= 0) {
                        length = Integer.toString(this.matrix.get(i).get(j)).length();
                    } else {
                        length = Integer.toString(0 - this.matrix.get(i).get(j)).length() + 1;
                    }
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    private StringBuilder alignGrids(int numberLength, int maxLength) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < maxLength - numberLength; i++) {
            string.append(" ");
        }
        return string;
    }

    private StringBuilder getStraightLow(int gridLength) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < this.name.size() * (gridLength + 1) + gridLength + 2; i++) {
            string.append("_");
        }
        return string;
    }

    @Override
    public String toString() {
        int i, weight;
        int maxLength = maxLength();
        StringBuilder sb = new StringBuilder();
        if (this.matrix.size() != 0) {
            sb.append("|" + alignGrids(0, maxLength));

            for (i = 0; i < this.name.size(); i++) { //add straight line in front of each element
                sb.append("|" + this.name.get(i) + alignGrids(this.name.get(i).length(), maxLength));//Align grid
            }
            sb.append("|" + "\n" + getStraightLow(maxLength) + "\n");

            for (i = 0; i < this.name.size(); i++) {
                sb.append("|" + this.name.get(i) + alignGrids(this.name.get(i).length(), maxLength) + "|");

                for (int j = 0; j < this.name.size(); j++) {
                    if (this.matrix.get(i).get(j) != null) {
                        sb.append(this.matrix.get(i).get(j));
                        weight = this.matrix.get(i).get(j);
                        if (weight < 0) weight = Integer.toString(0 - weight).length() + 1;
                        else weight = Integer.toString(weight).length();
                        sb.append(alignGrids(weight, maxLength) + "|");
                    } else {
                        sb.append("-" + alignGrids(1, maxLength) + "|");
                    }
                }
                sb.append("\n" + getStraightLow(maxLength) + "\n"); //add the last row,like:  ______________
            }
        }
        return sb.toString();
    }

    private DirectedGraph changeVertex() {
        int i;
        int size = this.name.size();
        for (i = 0; i < size; i++)
            if (i >= this.matrix.size()) this.matrix.add(new ArrayList<>());
        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j >= this.matrix.get(i).size()) {
                    List<Integer> list = this.matrix.get(i);
                    list.add(null);
                }
            }
        }
        return this;
    }

    public DirectedGraph addVertex(String vertexName) {
        this.name.add(vertexName);
        return changeVertex();
    }

    public DirectedGraph renameVertex(String old, String fresh) {
        int indexOfOld = this.name.indexOf(old);
        if (indexOfOld == -1) throw new IllegalArgumentException("There's no this vertex");
        this.name.set(indexOfOld, fresh);
        return changeVertex();
    }

    public DirectedGraph deleteVertex(String str) {
        int i, ver;
        ver = this.name.indexOf(str);
        if (ver == -1) throw new IllegalArgumentException("There's no this vertex");
        for (i = 0; i < this.matrix.size(); i++) {
            List<Integer> list = this.matrix.get(i);
            list.remove(ver);
        }
        this.matrix.remove(ver);
        this.name.remove(ver);
        return this;
    }

    private DirectedGraph changeEdge() {// number
        int i;
        int size = this.name.size();
        if (this.matrix.size() > this.name.size()) size = this.matrix.size();
        for (i = 0; i < this.matrix.size(); i++) {
            size = Math.max(this.matrix.get(i).size(), size);
        }
        for (i = this.name.size(); i < size; i++) {
            String string = Integer.toString(i + 1);
            this.name.add(string);
        }
        for (i = 0; i < this.name.size(); i++) {
            if (this.name.lastIndexOf(this.name.get(i)) != i) throw new IllegalArgumentException("Duplicate name");
        }
        return this;
    }

    public DirectedGraph addEdge(String begin, String end, Integer weight) {
        int indexOfEnd = this.name.indexOf(end);
        int indexOfBegin = this.name.indexOf(begin);
        List<Integer> list = this.matrix.get(indexOfEnd);
        if (indexOfEnd == -1 || indexOfBegin == -1) throw new IllegalArgumentException("There's no this vertex");
        list.remove(indexOfBegin);
        list.add(indexOfBegin, weight);
        this.matrix.set(indexOfEnd, list);
        return changeEdge();
    }

    public DirectedGraph deleteEdge(String start, String end) {
        return this.addEdge(start, end, null);
    }

    public DirectedGraph renameEdge(String start, String end, Integer newName) {
        return this.addEdge(start, end, newName);
    }

    public List<Pair<String, Integer>> getOutputList(String vertexName) { // |
        List<Pair<String, Integer>> list = new ArrayList<>();
        int location = this.name.indexOf(vertexName);
        if (location == -1) throw new IllegalArgumentException("Can't fine this vertex");
        for (int i = 0; i < this.matrix.size(); i++) {
            if (this.matrix.get(i).get(location) != null) {
                list.add(new Pair<>(this.name.get(i), this.matrix.get(i).get(location)));
            }
        }
        return list;
    }

    public List<Pair<String, Integer>> getInputList(String vertexName) { //___
        List<Pair<String, Integer>> list = new ArrayList<>();
        int location = this.name.indexOf(vertexName);
        if (location == -1) throw new IllegalArgumentException("Can't fine this vertex");
        for (int i = 0; i < this.matrix.size(); i++) {
            if (this.matrix.get(i).get(location) != null) {
                list.add(new Pair<>(this.name.get(i), this.matrix.get(location).get(i)));
            }
        }
        return list;
    }
}
