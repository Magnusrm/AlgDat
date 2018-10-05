package Øving7;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graph {
    int N, K;
    Node[] node;

    public void newGraphFromFile(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        node = new Node[N];
        for (int i = 0; i < N; i++) {
            node[i] = new Node();
        }
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            Edge e = new Edge(node[to], node[from].edge1);
            node[from].edge1 = e;
        }
    }

    public void dfsInit() {
        for (int i = N; i > 0; i--) {
            node[i].d = new DfsPrev();
        }
        DfsPrev.nullTime();
    }

    public void dfSearch(Node n) {
        DfsPrev nd = (DfsPrev)n.d;
        nd.foundTime = DfsPrev.readTime();
        for (Edge e = n.edge1; e != null; e = e.next) {
            DfsPrev md = (DfsPrev)e.to.d;
            if (md.foundTime == 0) {
                md.prev = n;
                md.dist = nd.dist +1;
                dfSearch(e.to);
            }
        }
        nd.doneTime = DfsPrev.readTime();
    }

    public void dfs(Node s) {
        dfsInit();
        ((DfsPrev)s.d).dist = 0;
        dfSearch(s);
    }

    Node dfTopo(Node n, Node l) {
        TopoList nd = (TopoList)n.d;
        if (nd.found) {
            return l;
        }
        nd.found = true;
        for (Edge e = n.edge1; e != null; e = e.next) {
            l = dfTopo(e.to, l);
        }
        nd.next = l;
        return n;
    }

    Node topologySort() {
        Node l = null;
        for (int i = N; i > 0; i--) {
            node[i].d = new TopoList();
        }
        for (int i = N; i > 0; i--) {
            l = dfTopo(node[i], l);
        }
        return l;
    }
}
