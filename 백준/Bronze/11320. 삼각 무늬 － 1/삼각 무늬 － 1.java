import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < n; tc++) {
			String[] arr = br.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			
			int areaA = a * a;
			int areaB = b * b;
			
			System.out.println(areaA / areaB);
			
		}
	}

}
