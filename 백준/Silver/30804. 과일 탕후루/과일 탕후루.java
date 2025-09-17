import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>(); // 과일 종류별 개수
        int left = 0, res = 0;

        for (int right = 0; right < N; right++) {
            // 오른쪽 과일 추가
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // 과일 종류가 2개 초과라면 왼쪽 줄이기
            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }

            // 최대 길이 갱신
            res = Math.max(res, right - left + 1);
        }

        System.out.println(res);
        br.close();
    }
}