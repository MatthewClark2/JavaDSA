package prj.clark.cs.dsa.algo.graph;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int given) {
        if (given == v) {
            return w;
        } else if (given == w) {
            return v;
        }

        throw new IllegalArgumentException();
    }

    @Override
    public int compareTo(Edge edge) {
        return Double.compare(weight, edge.weight);
    }

    @Override
    public String toString() {
        return v + " <---> " + w + " : " + weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge) {
            Edge e = (Edge) o;
            return e.weight == weight && e.v == v && e.w == w;
        }

        return false;
    }
}
