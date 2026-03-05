import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long res = 1;

        for(int i = 1; i <= n; i++) {

            res *= i;

            while(res % 10 == 0) {
                res /= 10;
            }

            res %= 1_000_000_000_000L;
        }

        System.out.printf("%05d\n", res % 100000);
    }
}