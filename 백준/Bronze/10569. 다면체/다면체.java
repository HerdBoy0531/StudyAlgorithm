import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		int res = 0;
		
		for(int i = 0 ; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			res = 2 + E - V;
			sb.append(res).append("\n");
		}
		
		System.out.print(sb);

	}

}