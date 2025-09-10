import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int s1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int s2 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		int per = p1 + p2;
		int est = s1 + s2;
		
		if(per == est) {
			if(s1 > p2) {
				System.out.printf("Esteghlal");
			}
			else if(p2 > s1) {
				System.out.printf("Persepolis");
			}
			else {
				System.out.printf("Penalty");
			}
		}
		else if(per > est) {
			System.out.printf("Persepolis");
		}
		else {
			System.out.printf("Esteghlal");
		}
		br.close();
	}

}