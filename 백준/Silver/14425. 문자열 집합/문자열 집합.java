import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> S = new HashSet<>();
		for(int i = 0; i < N; i++) {
			String mem = br.readLine();
			S.add(mem);
		}
		
		int cnt = 0;
		
		for(int i = 0; i < M; i++) {
			String mem = br.readLine();
			if(S.contains(mem)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
		
		
		
		
		br.close();
	}

}