import java.io.*;

public class Main {

    static int n;
    static int cnt = 0;

    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    static void queen(int y) {
        if (y == n) {
            cnt++;
            return;
        }

        for (int x = 0; x < n; x++) {
            int d1 = y - x + n - 1;
            int d2 = y + x;

            if (col[x] || diag1[d1] || diag2[d2]) continue;

            col[x] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            queen(y + 1);

            col[x] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        queen(0);

        System.out.println(cnt);
    }
}
