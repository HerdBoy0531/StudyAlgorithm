import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int res = 1;
		for(int i = 0; i < N; i++) {
			res *= 2;
		}
		
		System.out.println(res);
		
		br.close();
	}

}