import java.io.*;
import java.util.*;

public class Main{

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean inRange(Node a, Node b, int R) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy <= 1L * R * R;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        Node[] towers = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            towers[i] = new Node(x, y);
        }

        Node enemy = new Node(ex, ey);

        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (inRange(towers[i], towers[j], R)) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (inRange(towers[i], enemy, R)) {
                dist[i] = 0;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        double ans = 0.0;
        for (int i = 0; i < N; i++) {
            if (dist[i] == -1) continue;
            ans += D / Math.pow(2.0, dist[i]);
        }

        System.out.printf("%.2f%n", ans);
    }
}