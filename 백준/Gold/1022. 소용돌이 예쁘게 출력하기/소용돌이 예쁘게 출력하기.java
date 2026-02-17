import java.io.*;
import java.util.*;

public class Main {

    static int getValue(int r, int c) {
        int k = Math.max(Math.abs(r), Math.abs(c));
        int maxVal = (2 * k + 1) * (2 * k + 1);

        if (r == k) {
            return maxVal - (k - c);
        }

        if (c == -k) {
            return maxVal - 2 * k - (k - r);
        }

        if (r == -k) {
            return maxVal - 4 * k - (c + k);
        }

        return maxVal - 6 * k - (r + k);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        int[][] arr = new int[rows][cols];

        int maxNum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = getValue(r1 + i, c1 + j);
                arr[i][j] = val;
                maxNum = Math.max(maxNum, val);
            }
        }

        int width = String.valueOf(maxNum).length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%" + width + "d ", arr[i][j]));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}