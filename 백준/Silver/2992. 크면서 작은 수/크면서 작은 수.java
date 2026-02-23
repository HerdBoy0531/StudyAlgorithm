import java.io.*;
import java.util.*;

public class Main {

    static String n;
    static int[] arr;
    static boolean[] visited;
    static int target;
    static int answer = Integer.MAX_VALUE;

    static void dfs(int depth, int num) {

        if (depth == arr.length) {
            if (num > target) {
                answer = Math.min(answer, num);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (visited[i]) continue;

            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            dfs(depth + 1, num * 10 + arr[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();

        target = Integer.parseInt(n);

        arr = new int[n.length()];
        visited = new boolean[n.length()];

        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i) - '0';
        }

        Arrays.sort(arr);

        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}