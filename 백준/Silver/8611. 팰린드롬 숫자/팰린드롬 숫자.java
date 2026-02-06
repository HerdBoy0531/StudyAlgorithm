import java.io.*;
import java.math.BigInteger;

public class Main {

    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());

        boolean found = false;

        for (int base = 2; base <= 10; base++) {

            String converted = n.toString(base);

            if (isPalindrome(converted)) {
                System.out.println(base + " " + converted);
                found = true;
            }
        }

        if (!found) {
            System.out.println("NIE");
        }
    }
}