import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        
        int size = N; // 원래 크기 저장
        int num = N * N;
        int x = 0, y = 0;
        int time = 0;
        
        while (num > 0) {
            // 왼쪽 → 아래
            x = time;
            for (int i = y; i < N; i++) {
                arr[i][x] = num--;
            }
            
            // 아래 → 오른쪽
            y = N - 1;
            for (int i = x + 1; i < N; i++) {
                arr[y][i] = num--;
            }
            
            // 오른쪽 → 위
            x = N - 1;
            for (int i = y - 1; i >= time; i--) {
                arr[i][x] = num--;
            }
            
            // 위 → 왼쪽
            y = time;
            for (int i = x - 1; i > time; i--) {
                arr[y][i] = num--;
            }
            
            time++;
            N--;
            y = time;
        }
        
        StringBuilder sb = new StringBuilder();
        int tx = 0, ty = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (target == arr[i][j]) {
                    ty = i + 1;
                    tx = j + 1;
                }
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(ty).append(" ").append(tx);
        System.out.println(sb.toString());
        
        br.close();
    }
}
