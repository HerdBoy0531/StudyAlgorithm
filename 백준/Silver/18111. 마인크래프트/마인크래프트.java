import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int min = 256, max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        // 0 ~ 256 높이까지 시뮬레이션
        for (int h = min; h <= max; h++) {
            int time = 0;
            int blocks = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = arr[i][j] - h;
                    if (diff > 0) { // 블록 깎기
                        time += diff * 2;
                        blocks += diff;
                    } else if (diff < 0) { // 블록 쌓기
                        time += (-diff);
                        blocks += diff; // diff가 음수
                    }
                }
            }

            if (blocks >= 0) { // 가능한 경우
                if (time < resultTime || (time == resultTime && h > resultHeight)) {
                    resultTime = time;
                    resultHeight = h;
                }
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}