import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] arr;
    static int swapCount = 0;
    static boolean found = false;

    public static void quickSort(int left, int right) {
        if (left < right) {
            int pivot = partition(left, right);
            if (found) return;
            quickSort(left, pivot - 1);
            if (found) return;
            quickSort(pivot + 1, right);
        }
    }

    public static int partition(int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(i, j);
                if (found) return i + 1;
            }
        }

        if (i + 1 != right) {
            swap(i + 1, right);
        }
        return i + 1;
    }

    public static void swap(int a, int b) {
        int x = arr[a];
        int y = arr[b];

        arr[a] = y;
        arr[b] = x;

        swapCount++;

        if (!found && swapCount == K) {
            System.out.println(Math.min(x, y) + " " + Math.max(x, y));
            found = true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        quickSort(0, N - 1);

        if (!found) System.out.println(-1);
    }
}
