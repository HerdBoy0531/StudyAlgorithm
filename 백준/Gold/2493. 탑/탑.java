import java.io.*;
import java.util.*;

public class Main {

    static class Tower {
        int height;
        int index;

        Tower(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] res = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Tower> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().height < h) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek().index;
            }

            stack.push(new Tower(h, i + 1));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }
}