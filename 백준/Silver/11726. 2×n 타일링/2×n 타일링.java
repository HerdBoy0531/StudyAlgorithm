import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] fill = new int[Math.max(3, N + 1)];
		
		fill[1] = 1;
		fill[2] = 2;
		
        for (int i = 3; i <= N; i++) {
            fill[i] = (fill[i - 1] + fill[i - 2]) % 10007;
        }
		
		System.out.print(fill[N]%10007);
		
		br.close();
	}

}