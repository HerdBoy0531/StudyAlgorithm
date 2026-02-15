import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[] dice = new long[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++){
            dice[i] = Long.parseLong(st.nextToken());
        }

        if(n == 1){
            long sum = 0;
            long max = 0;
            for(long v : dice){
                sum += v;
                max = Math.max(max, v);
            }
            System.out.println(sum - max);
            return;
        }

        long one = Arrays.stream(dice).min().getAsLong();

        long two = Long.MAX_VALUE;
        int[][] pair = {
                {0,1},{0,2},{0,3},{0,4},
                {5,1},{5,2},{5,3},{5,4},
                {1,2},{2,4},{4,3},{3,1}
        };

        for(int[] p : pair){
            two = Math.min(two, dice[p[0]] + dice[p[1]]);
        }

        long three = Long.MAX_VALUE;
        int[][] triple = {
                {0,1,2},{0,2,4},{0,4,3},{0,3,1},
                {5,1,2},{5,2,4},{5,4,3},{5,3,1}
        };

        for(int[] t : triple){
            three = Math.min(three, dice[t[0]] + dice[t[1]] + dice[t[2]]);
        }

        long count3 = 4;
        long count2 = 8*n - 12;
        long count1 = (n-2)*(n-2)*5 + (n-2)*4;

        long ans = three*count3 + two*count2 + one*count1;
        System.out.println(ans);
    }
}