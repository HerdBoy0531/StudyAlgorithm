import java.io.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String num = br.readLine();
		int K = Integer.parseInt(br.readLine());
		
		if(num.indexOf('1') == -1) {
			System.out.print("YES");
			br.close();
			return;
		}
		
		int cnt = 0;
		
		for(int i = n-1; i >= 0; i--) {
			if(num.charAt(i) == '1') break;
			cnt++;
		}
		
		if(cnt >= K) {
			System.out.print("YES");
		} else {
			System.out.print("NO");
		}
		
		
		
		br.close();
	}

}