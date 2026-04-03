import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        if (num % 4763 != 0) {
            System.out.println(0);
            return;
        }

        int score = num / 4763;

        int[] koreanArr = {508, 108};
        int[] mathArr = {212, 305};

        Set<String> set = new HashSet<>();
        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int k : koreanArr) {
                    for (int m : mathArr) {
                        if (i * k + j * m == score) {
                            String key = i + "," + j;
                            if (set.add(key)) {
                                arr.add(new int[]{i, j});
                            }
                        }
                    }
                }
            }
        }

        arr.sort(Comparator
                .comparingInt((int[] o) -> o[0])
                .thenComparingInt(o -> o[1]));

        System.out.println(arr.size());
        for (int[] a : arr) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}