import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        int[] coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int idx = N-1;
        int cnt = 0;
        int res = K;

        while(res > 0){
            if(res >= coins[idx]){
                res -= coins[idx];
                cnt++;
            }
            else {
                idx--;
            }
        }

        bw.write(cnt+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
