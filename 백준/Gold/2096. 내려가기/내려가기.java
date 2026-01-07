import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
            int val = Integer.parseInt(st.nextToken());
            maxDp[j] = val;
            minDp[j] = val;
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] nextMax = new int[3];
            int[] nextMin = new int[3];

            nextMax[0] = Math.max(maxDp[0], maxDp[1]) + a;
            nextMax[1] = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + b;
            nextMax[2] = Math.max(maxDp[1], maxDp[2]) + c;

            nextMin[0] = Math.min(minDp[0], minDp[1]) + a;
            nextMin[1] = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]) + b;
            nextMin[2] = Math.min(minDp[1], minDp[2]) + c;

            maxDp = nextMax;
            minDp = nextMin;
        }

        int maxResult = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int minResult = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);

        System.out.println(maxResult + " " + minResult);
    }
}