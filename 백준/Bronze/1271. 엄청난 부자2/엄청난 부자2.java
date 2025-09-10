import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger N = new BigInteger(st.nextToken());
		BigInteger M = new BigInteger(st.nextToken());

		BigInteger res = N.divide(M);
		BigInteger res_coin = N.remainder(M);

		System.out.println(res);
		System.out.println(res_coin);
		br.close();
	}

}