import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
		if(!hm.containsKey(num)) {
				sb.append(0+" ");
			} else {
				sb.append(hm.get(num)+" ");
			}
		}
		
		System.out.println(sb);
	}

}