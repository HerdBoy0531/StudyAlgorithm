import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] board;
    static char[][][] digit = new char[10][5][3];

    static final String[] DIGITS = {
            "###\n#.#\n#.#\n#.#\n###",
            "..#\n..#\n..#\n..#\n..#",
            "###\n..#\n###\n#..\n###",
            "###\n..#\n###\n..#\n###",
            "#.#\n#.#\n###\n..#\n..#",
            "###\n#..\n###\n..#\n###",
            "###\n#..\n###\n#.#\n###",
            "###\n..#\n..#\n..#\n..#",
            "###\n#.#\n###\n#.#\n###",
            "###\n#.#\n###\n..#\n###"   
    };

    static boolean isPossible(int idx, int d) {
        int colStart = idx * 4;
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 3; c++) {
                char cur = board[r][colStart + c];
                char need = digit[d][r][c];
                if (cur == '#' && need == '.') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int d = 0; d < 10; d++) {
            String[] lines = DIGITS[d].split("\n");
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 3; c++) {
                    digit[d][r][c] = lines[r].charAt(c);
                }
            }
        }

        N = Integer.parseInt(br.readLine().trim());
        board = new char[5][4 * N - 1];
        for (int r = 0; r < 5; r++) {
            board[r] = br.readLine().toCharArray();
        }

        List<Integer>[] candidates = new ArrayList[N];
        for (int i = 0; i < N; i++) candidates[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int d = 0; d <= 9; d++) {
                if (isPossible(i, d)) candidates[i].add(d);
            }
            if (candidates[i].isEmpty()) {
                System.out.println(-1);
                return;
            }
        }

        double ans = 0.0;
        for (int i = 0; i < N; i++) {
            double place = Math.pow(10, N - 1 - i);
            double sum = 0.0;
            for (int d : candidates[i]) sum += d;
            ans += (sum / candidates[i].size()) * place;
        }

        System.out.println(ans);
    }
}