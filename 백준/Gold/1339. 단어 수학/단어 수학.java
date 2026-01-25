import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] weight = new int[26];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int len = word.length();

            for (int j = 0; j < len; j++) {
                char c = word.charAt(j);
                weight[c - 'A'] += Math.pow(10, len - j - 1);
            }
        }

        Arrays.sort(weight);

        int num = 9;
        int result = 0;

        for (int i = 25; i >= 0; i--) {
            if (weight[i] == 0) break;
            result += weight[i] * num--;
        }

        System.out.println(result);
    }
}
