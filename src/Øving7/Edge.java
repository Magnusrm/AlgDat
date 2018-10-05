package Øving7;

public class Edge {
    Edge next;
    Node to;

    public Edge(Node n, Edge next) {
        this.to = n;
        this.next = next;
    }
}
