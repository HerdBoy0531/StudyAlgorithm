import java.io.*;
import java.util.*;

public class Main {
	public static char[] vow = {'a', 'e', 'i', 'o', 'u'};
	
	public static int Checking(String arr) {
		int vow_T = 0;
		int vow_num = 0;
		int con_num = 0;
		char check = 'a';
		boolean st = true;
		
		for(int i = 0; i < arr.length(); i++) {
			boolean con_T = true;
			if(!st) break;
			for(int ii = 0; ii < vow.length; ii++) {
				// 모음이 최소 1개 이상인지 확인
				// 모음이 연속 3개 이상인지 확인
				if(arr.charAt(i) == vow[ii]) {
					vow_T += 1;
					con_num = 0;
					vow_num += 1;
					check = vow[ii];
					con_T = false;
					break;
				}
			}
			if(con_T) {
				vow_num = 0;
				con_num += 1;
				check = arr.charAt(i);
			}
			if(i+1 != arr.length() && arr.charAt(i) == arr.charAt(i+1) && arr.charAt(i) != 'e' && arr.charAt(i) != 'o') {
				st = false;
			}
			if(vow_num >=3 || con_num >= 3) {
				st = false;
			}
		}
		
		if(st && vow_T > 0) return 0;
		else return 1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean end = true;
		int u = 1;
		while(end) {
			String arr = br.readLine();
			if(arr.length() == 3 && arr.charAt(0) == 'e' && arr.charAt(1) == 'n' && arr.charAt(2) == 'd') {
				end = false;
				break;
			}
			int res = Checking(arr);
			if(res == 0) {
				bw.write('<'+arr+"> is acceptable.\n");
			}
			else {
				bw.write('<'+arr+"> is not acceptable.\n");
			}
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}