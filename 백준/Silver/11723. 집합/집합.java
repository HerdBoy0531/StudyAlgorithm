import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> S = new HashSet<>();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String msg = st.nextToken();
			
			if(msg.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				if(S.contains(num)) {
					continue;
				}
				S.add(num);
			}
			else if(msg.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				if(!S.contains(num)) {
					continue;
				}
				S.remove(num);
			}
			else if(msg.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if(S.contains(num)) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
			else if(msg.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if(S.contains(num)) {
					S.remove(num);
				}
				else {
					S.add(num);
				}
			}
			else if(msg.equals("all")) {
				S.clear();
				for(int ii = 1; ii <= 20; ii++) {
					S.add(ii);
				}
			}
			else {
				S.clear();
			}
		}
		
		System.out.print(sb.toString());
		
		br.readLine();
	}

}