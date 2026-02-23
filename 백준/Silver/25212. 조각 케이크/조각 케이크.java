import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            a[i] = 100.0 / x;
        }

        int ans = 0;
        double eps = 1e-12;

        for (int mask = 1; mask < (1 << n); mask++) {
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) sum += a[i];
            }
            if (sum + eps >= 99.0 && sum - eps <= 101.0) ans++;
        }

        System.out.println(ans);
    }
}