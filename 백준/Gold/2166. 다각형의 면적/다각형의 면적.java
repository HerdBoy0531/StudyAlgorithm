import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] x = new long[n];
        long[] y = new long[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;

        for(int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            sum += (x[i] * y[next]) - (x[next] * y[i]);
        }

        System.out.printf("%.1f", Math.abs(sum) / 2.0);
    }
}