import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		String[] arr = br.readLine().split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // entrySet을 list로 변환
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // value 기준 내림차순 정렬, 같으면 순서 유지 (안 건드림)
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
		
        for (Map.Entry<String, Integer> entry : list) {
            for(int i = 0; i < entry.getValue(); i++) {
            	System.out.printf(entry.getKey()+" ");
            }
        }
		
		br.close();
	}

}
