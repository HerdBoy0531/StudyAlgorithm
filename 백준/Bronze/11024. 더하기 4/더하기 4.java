import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < test; tc++) {
			int res = 0;
			String[] arr = br.readLine().split(" ");
			for(int i = 0; i < arr.length; i++) {
				res += Integer.parseInt(arr[i]);
			}
			
			System.out.println(res);
		}

	}

}