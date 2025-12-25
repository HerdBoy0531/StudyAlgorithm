import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int totalMoney = 0;
		
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if(A == 68) {
				if(B == 136) totalMoney += 1000;
				else if(B == 142) totalMoney += 5000;
				else if(B == 148) totalMoney += 10000;
				else totalMoney += 50000;
			} else {
				if(A == 136) totalMoney += 1000;
				else if(A == 142) totalMoney += 5000;
				else if(A == 148) totalMoney += 10000;
				else totalMoney += 50000;
			}
		}
		
		System.out.println(totalMoney);

	}

}
