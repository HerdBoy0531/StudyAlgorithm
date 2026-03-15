import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = Math.max(num, max);
			min = Math.min(num, min);
		}
		
		System.out.println(min + " " + max);

	}

}