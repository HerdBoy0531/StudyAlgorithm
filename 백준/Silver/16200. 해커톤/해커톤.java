import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] team = new int[n];
		for(int i = 0; i < n; i++) {
			team[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(team);
		
		int res = 0;
		int cnt = 0;
		for(int i = 0; i < n; i += cnt) {
			if(i > n) {
				res+=1;
				break;
			}
			res += 1;
			cnt = team[i];
			
		}
		
		System.out.println(res);
		
	}

}