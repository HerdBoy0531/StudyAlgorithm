import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int ques = 0;
		
		for(int i = 0; i < n; i++) {
			String result = br.readLine();
			int cntO = 0;
			for(int j = 0; j < m; j++) {
				if(result.charAt(j) == 'O') {
					cntO++;
				}

			}
			if(cntO > m/2) ques++;
		}
		
		System.out.println(ques);

		
		br.close();
	}

}