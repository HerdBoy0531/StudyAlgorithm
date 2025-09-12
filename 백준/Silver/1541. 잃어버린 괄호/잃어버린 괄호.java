import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Queue<String> q = new ArrayDeque<>(); 
		
		for(int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
			else if(str.charAt(i) == '-'||str.charAt(i) == '+'){
				q.add(sb.toString());
				q.add(String.valueOf(str.charAt(i)));
				sb = new StringBuilder();
			}
			if(i == str.length()-1) {
				q.add(sb.toString());
			}
		}
		int res = 0;
		boolean flag = false;
		while(!q.isEmpty()) {
			String a = q.poll();
			if(Character.isDigit(a.charAt(0))) {
				if(flag) {
					res -= Integer.parseInt(a);
				}
				else {
					res += Integer.parseInt(a);
				}
			}
			else if(a.equals("+")) continue;
			else if(a.equals("-")) flag = true;
		}
		
		System.out.print(res);
		
		br.close();
	}

}