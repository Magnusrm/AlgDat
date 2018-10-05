package Øving7;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class GraphTab {
    int N;
    Object[] node;
    EdgeTab[][] edge;

    public void newGraphTabFromFile(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        edge = new EdgeTab[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                edge[i][j] = new EdgeTab();
            }
        }
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edge[from][to].exists = 1;
        }
    }


}

