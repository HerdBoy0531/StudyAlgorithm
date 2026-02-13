import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		BigInteger res = BigInteger.ZERO;
		
		for(int i = 1; i < n; i++) {
            long value = (long)i * n + i;
            res = res.add(BigInteger.valueOf(value));
		}
		
		System.out.println(res);
	}

}