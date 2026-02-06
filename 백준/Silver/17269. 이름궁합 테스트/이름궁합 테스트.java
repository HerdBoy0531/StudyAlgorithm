import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		String name1 = st.nextToken();
		String name2 = st.nextToken();
		
		StringBuilder name = new StringBuilder();
		
		if(name1.length() > name2.length()) {
			for(int i = 0; i < name2.length(); i++) {
				name.append(name1.charAt(i));
				name.append(name2.charAt(i));
			}
			for(int i = name2.length(); i < name1.length(); i++) {
				name.append(name1.charAt(i));
			}
		}
		else {
			for(int i = 0; i < name1.length(); i++) {
				name.append(name1.charAt(i));
				name.append(name2.charAt(i));
			}
			if(name2.length() > name1.length())
			for(int i = name1.length(); i < name2.length(); i++) {
				name.append(name2.charAt(i));
			}
		}
		
		StringBuilder sb1 = new StringBuilder();
		
		
		for(int i = 0; i < name.length(); i++) {
			if(name.charAt(i) == 'C' || name.charAt(i) == 'G' || name.charAt(i) == 'I' || name.charAt(i) == 'J' ||
				name.charAt(i) == 'L' || name.charAt(i) == 'O' || name.charAt(i) == 'S' || name.charAt(i) == 'U' ||
				name.charAt(i) == 'V' || name.charAt(i) == 'W' || name.charAt(i) == 'Z') {
				sb1.append('1');
			}
			else if(name.charAt(i) == 'E') {
				sb1.append('4');
			}
			else if(name.charAt(i) == 'A' || name.charAt(i) == 'F' || name.charAt(i) == 'H' || name.charAt(i) == 'K' ||
					name.charAt(i) == 'M') {
				sb1.append('3');
			}
			else sb1.append('2');
		}
		
		
		while(sb1.length() > 2) {
			StringBuilder sb2 = new StringBuilder();
			for(int i = 1; i < sb1.length(); i++) {
				int a = (int) sb1.charAt(i) - '0';
				int b = (int) sb1.charAt(i-1) - '0';
				sb2.append((a + b)%10);
			}
			sb1 = sb2;

		}
		if(sb1.charAt(0) == '0') {
			sb1.deleteCharAt(0);
		}
		System.out.println(sb1 + "%");
		
		
		
	}

}