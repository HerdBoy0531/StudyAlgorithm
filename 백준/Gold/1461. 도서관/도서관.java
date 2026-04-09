import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> negative = new ArrayList<>();
		ArrayList<Integer> positive = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		int max = 0;
		boolean check = true;
		
		for(int i = 0; i < N; i++) {
			int route = Integer.parseInt(st.nextToken());
			if(route < 0 ) {
				negative.add(Math.abs(route) * 2);
				max = Math.max(max, Math.abs(route));
			} else {
				positive.add(route * 2);
				max = Math.max(max, route);
			}
			
		}
		
		negative.sort(Collections.reverseOrder());
		positive.sort(Collections.reverseOrder());
		
		int ans = 0;
		for(int i = 0; i < 50; i++) {
			if(i * M >= negative.size()) break;
			ans += negative.get(i * M);
		}
		for(int i = 0; i < 50; i++) {
			if(i * M >= positive.size()) break;
			ans += positive.get(i * M);
		}
			
		System.out.println(ans -= max);

	}

}