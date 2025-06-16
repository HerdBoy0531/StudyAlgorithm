import java.io.*;

public class Main {

	public static int Factorial(int A, int lev, int res) {
		if (lev > A) {
			return res;
		}
		return Factorial(A, lev + 1, res * lev);
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int A = Integer.parseInt(br.readLine());
		
		int res = Factorial(A, 1, 1);
		bw.write(res+"");
		
		bw.flush();
		br.close();
		bw.close();
	}

}