import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int min = 0;
        while (min < max) {
            int mid = (min + max) / 2;
            long tree = 0;  // 합은 int 범위를 넘을 수 있어서 long 권장

            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    tree += arr[i] - mid;
                }
            }

            if (tree < M) {
                // 덜 잘랐으니 더 낮게 잘라야 함
                max = mid;
            } else {
                // 충분히 잘랐거나 더 많이 잘랐으니 더 높이 잘라도 됨
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
        br.close();
    }
}