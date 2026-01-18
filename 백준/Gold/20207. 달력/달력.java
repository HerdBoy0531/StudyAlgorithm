import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] sch = new int[366];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int d = start; d <= end; d++) {
                sch[d]++;
            }
        }

        int width = 0;
        int height = 0;
        int res = 0;

        for (int i = 1; i <= 365; i++) {
            if (sch[i] == 0) {
                res += width * height;
                width = 0;
                height = 0;
            } else {
                width++;
                height = Math.max(height, sch[i]);
            }
        }
        res += width * height;
        System.out.println(res);
    }
}
