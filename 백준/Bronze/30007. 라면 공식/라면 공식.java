import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int end = Integer.parseInt(br.readLine());
		int ramen = 0;
		
		while(ramen != end) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int res = A * (X - 1) + B;
			
			System.out.println(res);
			ramen++;
		}
		
		
	}

}