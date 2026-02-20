import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long D = Long.parseLong(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        double dist = Math.sqrt((double)X * X + (double)Y * Y);

        double ans = dist;

        if (T >= D) {
            System.out.println(ans);
            return;
        }

        long k = (long)(dist / D);

        ans = Math.min(ans, k * (double)T + (dist - k * (double)D));

        ans = Math.min(ans, (k + 1) * (double)T + Math.abs(dist - (k + 1) * (double)D));

        long need = (long)Math.ceil(dist / D);
        if (need >= 2) ans = Math.min(ans, need * (double)T);

        if (dist < D) {
            ans = Math.min(ans, (double)T + (D - dist));
            ans = Math.min(ans, 2.0 * T);
        }

        System.out.println(ans);
    }
}