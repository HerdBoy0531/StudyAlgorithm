import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = 0;
		int n = Integer.parseInt(st.nextToken());
		if(n == 1) {
			for(int i = 1; i < 8; i++) {
				n = Integer.parseInt(st.nextToken());
				if(n != 1+i) {
					res = 0; 
					break;
				}
				res = 1;
			}
			
		}
		else if(n == 8) {
			for(int i = 1; i < 8; i++) {
				n = Integer.parseInt(st.nextToken());
				if(n != 8-i) {
					res = 0; 
					break;
				}
				res = 2;
			}
		}
		
		if(res == 0) {
			System.out.printf("mixed");
		}
		else if(res == 1) {
			System.out.printf("ascending");
		}
		else {
			System.out.printf("descending");
		}
		
		br.close();
	}

}