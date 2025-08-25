import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] target = br.readLine().toCharArray(); // 매칭해야 할 숫자열
        int idx = 0; // target에서 현재 매칭 위치

        for (int n = 1; ; n++) {
            String s = Integer.toString(n);
            for (int i = 0; i < s.length() && idx < target.length; i++) {
                if (s.charAt(i) == target[idx]) idx++;
            }
            if (idx == target.length) { // 전부 매칭 완료
                System.out.println(n);
                break;
            }
        }
    }
}