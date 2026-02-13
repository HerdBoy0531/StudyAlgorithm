import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n <= 99) {
			System.out.println(n);
		}
		else {
			int cnt = 99;
			int a = 0, b = 0, c = 0;
			for(int i = 100; i <= n; i++) {
				a = i / 100;
				c = i % 10;
				b = (i % 100 - c) / 10;
				
                if (a - b == b - c) {
                    cnt++;
                }
			}
			
			System.out.println(cnt);
		}

	}

}