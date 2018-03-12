package ru.spbstu.kspt.task1;

import javafx.util.Pair;

import java.util.*;

public class DirectGraph {

    List<List<Integer>> matrix;
    List<String> name;

    public DirectGraph(List<List<Integer>> m, List<String> n) {
        List<List<Integer>> matri = new ArrayList<>();
        List<String> names = new ArrayList<>();
        int i;
        if (m.size() != n.size()) throw new IllegalArgumentException("Extra vertex");
        for (i = 0; i < n.size(); i++) {
            names.add(n.get(i));
        }
        for (i = 0; i < m.size(); i++) {
            if (m.get(i).size() != n.size()) throw new IllegalArgumentException("Extra vertex");
            matri.add(new ArrayList<>());
            for (int j = 0; j < m.get(i).size(); j++) {
                List<Integer> list = matri.get(i);
                list.add(m.get(i).get(j));
                matri.set(i, list);
            }
        }
        this.matrix = matri;
        this.name = names;
        Set<String> nameFailed = new HashSet<>();
        int size = matri.size();
        for (i = 0; i < matri.size(); i++) {
            if (matri.get(i).size() > size) size = matri.get(i).size();
        }

        for (i = 0; i < size; i++) {
            if (name.size() < i + 1) {
                String str = Integer.toString(i + 1);
                this.name.add(str);
            }
        }
        for (i = 0; i < name.size(); i++) nameFailed.add(name.get(i));
        if (name.size() != nameFailed.size()) throw new IllegalArgumentException("Duplicate name");

        for (i = 0; i < names.size(); i++) {
            for (int j = this.matrix.get(i).size(); j < names.size(); j++) {
                List<Integer> list = this.matrix.get(i);
                list.add(null);
                this.matrix.set(i, list);
            }
            if (matrix.size() <= i) {
                this.matrix.add(new ArrayList<>());
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DirectGraph) {
            DirectGraph graph = (DirectGraph) obj;
            return getMatrix().equals(graph.getMatrix());
        }
        return false;
    }

    public int hashCode() {
        return getMatrix().hashCode() * 31 + getName().hashCode();
    }

    public List<List<Integer>> getMatrix() {
        List<List<Integer>> matr = new ArrayList<>();
        for (int i = 0; i < this.matrix.size(); i++) {
            matr.add(new ArrayList<>());
            for (int j = 0; j < this.matrix.size(); j++) {
                List<Integer> list = new ArrayList<>();
                list.add(this.matrix.get(i).get(j));
                matr.set(i, list);
            }
        }
        return matr;
    }

    public List<String> getName() {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < this.name.size(); i++) {
            str.add(this.name.get(i));
        }
        return str;
    }

    public int maxLength() {
        int maxLength = 0;
        int i, number;
        for (i = 0; i < this.name.size(); i++) {
            if (this.name.get(i).length() > maxLength) {
                maxLength = this.name.get(i).length();
            }
            for (int j = 0; j < this.matrix.get(i).size(); j++) {
                if (this.matrix.get(i).get(j) != null) {
                    if (this.matrix.get(i).get(j) >= 0) {
                        number = Integer.toString(this.matrix.get(i).get(j)).length();
                    } else {
                        number = Integer.toString(0 - this.matrix.get(i).get(j)).length() + 1;
                    }
                    if (number > maxLength) maxLength = number;
                }
            }

        }
        return maxLength;
    }

    @Override
    public String toString() {
        int i, weight, a;
        int maxLength = maxLength();
        StringBuilder sb = new StringBuilder();
        if (this.matrix.size() == 0) {
            sb.append("Empty graph" + "\n");
        } else {
            sb.append("|");
            for (a = 0; a < maxLength; a++) {
                sb.append(" ");
            }
            for (i = 0; i < this.name.size(); i++) {
                sb.append("|" + this.name.get(i));
                for (a = 0; a < maxLength - this.name.get(i).length(); a++) {
                    sb.append(" ");
                }
            }
            sb.append("|" + "\n");
            String s = "";
            for (i = 0; i < this.name.size() * (maxLength + 1) + maxLength + 2; i++) {
                sb.append("_");
                s += "_";
            }
            sb.append("\n");
            for (i = 0; i < this.name.size(); i++) {
                sb.append("|" + this.name.get(i));
                for (a = 0; a < maxLength - this.name.get(i).length(); a++) {
                    sb.append(" ");
                }
                sb.append("|");
                for (int j = 0; j < this.name.size(); j++) {
                    if (this.matrix.get(i).get(j) != null) {
                        sb.append(this.matrix.get(i).get(j));
                        weight = this.matrix.get(i).get(j);
                        if (weight < 0) weight = Integer.toString(0 - weight).length() + 1;
                        else weight = Integer.toString(weight).length();
                        for (a = 0; a < maxLength - weight; a++) {
                            sb.append(" ");
                        }
                        sb.append("|");
                    } else {
                        sb.append("-");
                        for (a = 0; a < maxLength - 1; a++) sb.append(" ");
                        sb.append("|");
                    }
                }
                sb.append("\n" + s + "\n");
            }
        }
        return sb.toString();
    }

    private DirectGraph changeV() {// string
        int i;
        int size = this.name.size();
        List<List<Integer>> m0 = this.matrix;
        for (i = 0; i < size; i++)
            if (i >= this.matrix.size()) m0.add(new ArrayList<>());
        this.matrix = m0;
        for (i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j >= this.matrix.get(i).size()) {
                    List<Integer> list = this.matrix.get(i);
                    list.add(null);
                    m0.set(i, list);
                }
            }
            this.matrix = m0;
        }
        return this;
    }

    public DirectGraph addVertex(String str) {
        this.name.add(str);
        return changeV();
    }

    public DirectGraph renameVertex(String old, String new1) {
        int oldNumber = this.name.indexOf(old);
        if (oldNumber == -1) throw new IllegalArgumentException("There's no this vertex");
        this.name.set(oldNumber, new1);
        return changeV();
    }

    public DirectGraph deleteVertex(String str) {
        int i, ver;
        ver = this.name.indexOf(str);
        if (ver == -1) throw new IllegalArgumentException("There's no this vertex");
        for (i = 0; i < this.matrix.size(); i++) {
            List<Integer> list = this.matrix.get(i);
            list.remove(ver);
            this.matrix.set(i, list);
        }
        this.matrix.remove(ver);
        this.name.remove(ver);
        return this;
    }

    private DirectGraph changeEdge() {// number
        int i;
        int size = this.name.size();
        if (this.matrix.size() > this.name.size()) size = this.matrix.size();
        for (i = 0; i < this.matrix.size(); i++) {
            if (this.matrix.get(i).size() > size) size = this.matrix.get(i).size();
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

    public DirectGraph addEdge(String begin, String end, Integer number) {
        int endNumber = this.name.indexOf(end);
        int beginNumber = this.name.indexOf(begin);
        List<Integer> list = this.matrix.get(endNumber);
        if (endNumber == -1 || beginNumber == -1) throw new IllegalArgumentException("There's no this vertex");
        list.remove(beginNumber);
        list.add(beginNumber, number);
        this.matrix.set(endNumber, list);
        return changeEdge();
    }

    public DirectGraph deleteEdge(String start, String end) {
        return this.addEdge(start, end, null);
    }

    public DirectGraph renameEdge(String start, String end, Integer newName) {
        return this.addEdge(start, end, newName);
    }

    public List<HashMap<String, Integer>> output(String s) { // |
        List<HashMap<String, Integer>> list = new ArrayList<>();
        int location = this.name.indexOf(s);
        if (location == -1) throw new IllegalArgumentException("Can't fine this vertex");
        for (int i = 0; i < this.matrix.size(); i++) {
            if (this.matrix.get(i).get(location) != null) {
                HashMap map = new HashMap();
                map.put(this.name.get(i), this.matrix.get(i).get(location));
                list.add(map);
            }
        }
        return list;
    }

    public List<HashMap<String, Integer>> input(String s) { //___
        List<HashMap<String, Integer>> list = new ArrayList<>();
        int location = this.name.indexOf(s);
        if (location == -1) throw new IllegalArgumentException("Can't fine this vertex");
        for (int i = 0; i < this.matrix.size(); i++) {
            if (this.matrix.get(i).get(location) != null) {
                HashMap map = new HashMap();
                map.put(this.name.get(i), this.matrix.get(location).get(i));
                list.add(map);
            }
        }
        return list;
    }
}
