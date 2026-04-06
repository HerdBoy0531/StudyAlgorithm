import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int dosu = Integer.parseInt(st.nextToken());

            arr[i][0] = dosu;
            arr[i][1] = like;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;

        for (int i = 0; i < K; i++) {
            int dosu = arr[i][0];
            int like = arr[i][1];

            pq.offer(like);
            sum += like;

            if (pq.size() > N) {
                sum -= pq.poll();
            }

            if (pq.size() == N && sum >= M) {
                System.out.println(dosu);
                return;
            }
        }

        System.out.println(-1);
    }
}