import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < tc; i++) {
			int rank = Integer.parseInt(br.readLine());
			String res;
			if(rank > 4500) {
				res = "Round 1";
			}
			else if(rank > 1000) {
				res = "Round 2";
			}
			else if(rank > 25) {
				res = "Round 3";
			}
			else res = "World Finals";
			
			System.out.println("Case #"+(i+1)+": "+res);
		}
		
		br.close();
	}

}