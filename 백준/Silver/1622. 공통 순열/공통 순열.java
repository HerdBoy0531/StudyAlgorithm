import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineA;

        while ((lineA = br.readLine()) != null) {
            String lineB = br.readLine();
            if (lineB == null) break;

            int[] cntA = new int[26];
            int[] cntB = new int[26];

            for (int i = 0; i < lineA.length(); i++) {
                cntA[lineA.charAt(i) - 'a']++;
            }

            for (int i = 0; i < lineB.length(); i++) {
                cntB[lineB.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                int common = Math.min(cntA[i], cntB[i]);
                for (int j = 0; j < common; j++) {
                    sb.append((char) (i + 'a'));
                }
            }

            System.out.println(sb);
        }
    }
}
