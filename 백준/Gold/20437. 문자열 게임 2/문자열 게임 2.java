import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			String w = br.readLine();
			int k = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] arr = new ArrayList[26];
			
			for(int i = 0; i < 26; i++) {
				arr[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < w.length(); i++) {
				arr[w.charAt(i) - 'a'].add(i);
				
			}
			
			int maxRes = Integer.MIN_VALUE;
			int minRes = Integer.MAX_VALUE;
			boolean go = false;
			
			for(int i = 0; i < 26; i++) {
				if(arr[i].size() >= k) {
					go = true;
					for(int j = 0; j <= arr[i].size()-k; j++) {
						int len = arr[i].get(j + k - 1) - arr[i].get(j) + 1;
						minRes = Math.min(minRes, len);
						maxRes = Math.max(maxRes, len);
					}
				}
			}
			
			if(go) {
				System.out.println(minRes + " " + maxRes);
			}
			else {
				System.out.println(-1);
			}
			
		}
	}

}