import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int y, x, cost;

    Node(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class Main {

    static int n;
    static int[][] map;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = map[0][0];
        pq.offer(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int y = cur.y;
            int x = cur.x;

            if (cur.cost > dist[y][x]) continue;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;

                int nextCost = dist[y][x] + map[ny][nx];
                if (dist[ny][nx] > nextCost) {
                    dist[ny][nx] = nextCost;
                    pq.offer(new Node(ny, nx, nextCost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            map = new int[n][n];
            dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], INF);
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();
            System.out.println("Problem " + tc++ + ": " + dist[n - 1][n - 1]);
        }
    }
}