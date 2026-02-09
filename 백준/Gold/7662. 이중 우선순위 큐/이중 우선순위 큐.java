import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();

            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                long num = Long.parseLong(st.nextToken());

                if (op == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    long key = (num == 1) ? map.lastKey() : map.firstKey();
                    int cnt = map.get(key);

                    if (cnt == 1) map.remove(key);
                    else map.put(key, cnt - 1);
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}