import java.io.*;
import java.util.*;

public class Main {
    public static int n, k, minTime, findCnt;
    public static int[] directX = new int[] {1, -1, 2};
    public static int[] visited = new int[100001];

    public static void findMinTime() {
        if (n == k) {
            minTime = 0;
            findCnt = 1;
            return;
        }

        Deque<int[]> dq = new ArrayDeque<>();
        int cnt = 0;
        dq.offer(new int[] {n, cnt});

        Arrays.fill(visited, -1);
        visited[n] = 0;

        minTime = Integer.MAX_VALUE;
        findCnt = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int curX = cur[0];
            int curCnt = cur[1];

            if (curCnt > minTime) continue;

            for (int i = 0; i < 3; i++) {
                int goX;
                if (i == 2) goX = curX * directX[i];
                else goX = curX + directX[i];

                if (goX < 0 || goX > 100000) continue;

                if (goX == k) {
                    if (curCnt + 1 < minTime) {
                        minTime = curCnt + 1;
                        findCnt = 1;
                    } else if (curCnt + 1 == minTime) {
                        findCnt++;
                    }
                } else if (visited[goX] == -1 || visited[goX] == curCnt + 1) {
                    visited[goX] = curCnt + 1;
                    dq.offer(new int[] {goX, curCnt + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        k = Integer.parseInt(arr[1]);

        findMinTime();

        System.out.println(minTime);
        System.out.println(findCnt);
    }
}