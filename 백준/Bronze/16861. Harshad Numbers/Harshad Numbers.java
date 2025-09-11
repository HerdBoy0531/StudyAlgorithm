import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		boolean res = true;
		
		while(res) {
			int num = Integer.parseInt(N);
			int len = N.length();
			int cnt = 0;
			for(int i = 0; i < len; i++) {
				cnt += N.charAt(i) -'0';
			}
			if(num % cnt == 0) {
				System.out.print(num);
				res = false;
			}
			N = Integer.toString(num+1);
		}
		
		br.close();
	}

}