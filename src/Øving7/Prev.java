package Øving7;

public class Prev {
    int dist;
    Node prev;
    static int infinite = 1000000000;

    public int getDist() {
        return this.dist;
    }
    public Node getPrev() {
        return this.prev;
    }
    public Prev() {
        this.dist = infinite;
    }

}
