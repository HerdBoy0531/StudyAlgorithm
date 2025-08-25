import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;

        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '<') {
                // 태그는 그대로 출력
                int j = i;
                while (j < n && s.charAt(j) != '>') j++;
                // j는 '>' 위치
                sb.append(s, i, Math.min(j + 1, n));
                i = j + 1;
            } else if (ch == ' ') {
                sb.append(' ');
                i++;
            } else {
                // 단어의 끝(공백 또는 '<')까지 찾은 뒤 뒤집어서 출력
                int j = i;
                while (j < n && s.charAt(j) != ' ' && s.charAt(j) != '<') j++;
                sb.append(new StringBuilder(s.substring(i, j)).reverse());
                i = j;
            }
        }

        System.out.println(sb.toString());
    }
}