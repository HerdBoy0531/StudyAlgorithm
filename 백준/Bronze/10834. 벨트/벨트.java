import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long cnt = 1;
        int rotateState = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int rotate = Integer.parseInt(st.nextToken());

            cnt = cnt * R / L;    // 기어비 업데이트
            rotateState ^= rotate; // 회전 방향 업데이트 (XOR)
        }

        System.out.println(rotateState + " " + cnt);
        br.close();
    }
}