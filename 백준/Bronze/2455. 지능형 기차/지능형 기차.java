import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int man = 0;
		int maxMan = Integer.MIN_VALUE;
		
		
		for(int i = 0 ; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			man = man + in - out;
			maxMan = Math.max(maxMan, man);
		}
		
		System.out.println(maxMan);
		
		br.close();
	}

}
