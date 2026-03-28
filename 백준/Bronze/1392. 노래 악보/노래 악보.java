import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] prefix = new int[N];

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            if (i == 0) prefix[i] = t;
            else prefix[i] = prefix[i - 1] + t;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            int time = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                if (time < prefix[j]) {
                    sb.append(j + 1).append("\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
