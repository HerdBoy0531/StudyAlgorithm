import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int res = 0;
		for(int i = 0; i < num.length(); i++) {
			if(num.charAt(i) == '7') {
				res += 2;
				break;
			}
		}
		if(Integer.parseInt(num) % 7 == 0) {
			res+=1;
		}
		
		System.out.println(res);
		
		br.readLine();
	}

}