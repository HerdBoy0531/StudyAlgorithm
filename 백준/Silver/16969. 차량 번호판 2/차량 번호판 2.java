import java.io.*;
import java.math.BigInteger;

public class Main {
    static final BigInteger MOD = BigInteger.valueOf(1000000009);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String car = br.readLine();

        BigInteger res = BigInteger.ONE;

        for (int i = 0; i < car.length(); i++) {
            char cur = car.charAt(i);

            if (i == 0) {
                res = res.multiply(cur == 'c'
                        ? BigInteger.valueOf(26)
                        : BigInteger.valueOf(10));
            } else {
                char prev = car.charAt(i - 1);

                if (cur == 'c') {
                    res = res.multiply(cur == prev
                            ? BigInteger.valueOf(25)
                            : BigInteger.valueOf(26));
                } else {
                    res = res.multiply(cur == prev
                            ? BigInteger.valueOf(9)
                            : BigInteger.valueOf(10));
                }
            }

            res = res.mod(MOD);
        }

        System.out.println(res);
    }
}