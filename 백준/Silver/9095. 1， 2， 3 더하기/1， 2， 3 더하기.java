import java.io.*;
import java.util.*;

public class Main {

	public static int plus(int n) {
		if(n == 1) {
			return 1;
		}
		else if(n == 2) {
			return 2;
		}
		else if(n == 3) {
			return 4;
		}
		else return plus(n-1) + plus(n-2) + plus(n-3);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			int res = plus(n);
			sb.append(res+"\n");
		}
		
		System.out.print(sb.toString());
		
		
		br.close();
	}

}