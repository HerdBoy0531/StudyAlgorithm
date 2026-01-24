import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int res = 0;

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;

            res += sum;
            pq.offer(sum);
        }

        System.out.println(res);
    }
}