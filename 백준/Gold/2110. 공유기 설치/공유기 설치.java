import java.io.*;
import java.util.*;

public class Main {

    static int n, c;
    static int[] home;

    static boolean install(int dist) {
        int count = 1;
        int last = home[0];

        for(int i = 1; i < n; i++) {
            if(home[i] - last >= dist) {
                count++;
                last = home[i];
            }
        }

        return count >= c;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        home = new int[n];

        for(int i = 0; i < n; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int start = 1;
        int end = home[n-1] - home[0];
        int answer = 0;

        while(start <= end) {

            int mid = (start + end) / 2;

            if(install(mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}