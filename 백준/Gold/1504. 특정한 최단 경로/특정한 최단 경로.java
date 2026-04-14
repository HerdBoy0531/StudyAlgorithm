import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static ArrayList<Node>[] graph;
    static final int INF = Integer.MAX_VALUE;

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (Node next : graph[now]) {
                int nextNode = next.to;
                int nextCost = cost + next.weight;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        long case1 = (long) dist1[v1] + distV1[v2] + distV2[V];
        long case2 = (long) dist1[v2] + distV2[v1] + distV1[V];

        long result = Math.min(case1, case2);

        if (dist1[v1] == INF || distV1[v2] == INF || distV2[V] == INF) case1 = INF;
        if (dist1[v2] == INF || distV2[v1] == INF || distV1[V] == INF) case2 = INF;

        result = Math.min(case1, case2);

        if (result >= INF) System.out.println(-1);
        else System.out.println(result);
    }
}