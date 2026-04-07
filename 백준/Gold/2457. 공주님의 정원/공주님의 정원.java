import java.io.*;
import java.util.*;

public class Main {

    static class Flower {
        int start, end;

        Flower(int sm, int sd, int em, int ed) {
            this.start = sm * 100 + sd;
            this.end = em * 100 + ed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(sm, sd, em, ed);
        }

        Arrays.sort(flowers, (a, b) -> {
            if (a.start == b.start) return b.end - a.end;
            return a.start - b.start;
        });

        int current = 301;
        int target = 1201;
        int idx = 0;
        int cnt = 0;
        int maxEnd = 0;

        while (current < target) {
            boolean found = false;

            while (idx < N && flowers[idx].start <= current) {
                maxEnd = Math.max(maxEnd, flowers[idx].end);
                idx++;
                found = true;
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            current = maxEnd;
            cnt++;
        }

        System.out.println(cnt);
    }
}