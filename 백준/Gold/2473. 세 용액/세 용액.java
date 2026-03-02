import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static long[] arr;
    static long min = Long.MAX_VALUE;
    static long[] answer = new long[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while(left < right) {

                long sum = arr[i] + arr[left] + arr[right];

                if(Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}