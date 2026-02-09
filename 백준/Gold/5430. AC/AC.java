import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<Integer> dq = new ArrayDeque<>();

            if (n > 0) {
                String inside = input.substring(1, input.length() - 1);
                String[] arr = inside.split(",");
                for (String s : arr) {
                    dq.add(Integer.parseInt(s));
                }
            }

            boolean reverse = false;
            boolean error = false;

            for (char c : func.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else {
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!reverse) dq.pollFirst();
                    else dq.pollLast();
                }
            }

            if (error) {
                sb.append("error\n");
                continue;
            }

            sb.append("[");
            while (!dq.isEmpty()) {
                sb.append(reverse ? dq.pollLast() : dq.pollFirst());
                if (!dq.isEmpty()) sb.append(",");
            }
            sb.append("]\n");
        }

        System.out.print(sb);
    }
}