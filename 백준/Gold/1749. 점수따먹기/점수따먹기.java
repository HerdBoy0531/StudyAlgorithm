import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MIN_VALUE;

        // top 행 고정
        for (int top = 0; top < N; top++) {
            int[] colSum = new int[M]; // 열 누적합

            // bottom 행 확장
            for (int bottom = top; bottom < N; bottom++) {

                // 현재 bottom 행을 colSum에 누적
                for (int j = 0; j < M; j++) {
                    colSum[j] += arr[bottom][j];
                }

                // Kadane 알고리즘 (1차원 최대 부분합)
                int cur = colSum[0];
                int max = colSum[0];

                for (int j = 1; j < M; j++) {
                    cur = Math.max(colSum[j], cur + colSum[j]);
                    max = Math.max(max, cur);
                }

                answer = Math.max(answer, max);
            }
        }

        System.out.println(answer);
    }
}
