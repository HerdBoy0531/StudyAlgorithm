import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] qs = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            qs[i] = Integer.parseInt(br.readLine());
            if (qs[i] > maxN) maxN = qs[i];
        }

        // DP 배열 준비 (문제 조건상 N ≤ 40)
        int[] zero = new int[Math.max(2, maxN + 1)];
        int[] one  = new int[Math.max(2, maxN + 1)];
        zero[0] = 1; one[0] = 0;
        zero[1] = 0; one[1] = 1;

        for (int i = 2; i <= maxN; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i]  = one[i - 1]  + one[i - 2];
        }

        StringBuilder sb = new StringBuilder();
        for (int n : qs) {
            sb.append(zero[n]).append(' ').append(one[n]).append('\n');
        }
        System.out.print(sb);
    }
}