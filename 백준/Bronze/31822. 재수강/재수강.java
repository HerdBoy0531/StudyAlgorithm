
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = br.readLine();
		
		int n = Integer.parseInt(br.readLine());
		
		int res = 0;
		for(int i = 0; i < n; i++) {
			String sub = br.readLine();
			boolean cnt = false;
			for(int j = 0; j < 5; j++) {
				if(answer.charAt(j) != sub.charAt(j)) {
					cnt = true;
					break;
				}
			}
			
			if(!cnt) res += 1;
		}

		System.out.println(res);
	}

}