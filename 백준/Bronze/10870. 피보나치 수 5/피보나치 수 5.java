import java.io.*;

public class Main {
    public static int[] arr = new int[22];

    public static int pibo(int lev, int N) {
        if (lev > N) {
            return arr[N];
        }
        arr[lev] = arr[lev - 2] + arr[lev - 1];
        return pibo(lev + 1, N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr[0] = 0;
        arr[1] = 1;

        int res;
        if (N == 0 || N == 1) {
            res = arr[N];
        } else {
            res = pibo(2, N);
        }

        bw.write(res + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}