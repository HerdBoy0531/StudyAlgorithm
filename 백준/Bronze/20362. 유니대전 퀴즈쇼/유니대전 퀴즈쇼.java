import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		String name = arr[1];
		
		String[][] lst = new String[n][2];
		int correctIdx = 0;
		for(int i = 0; i < n; i++) {
			arr = br.readLine().split(" ");
			lst[i][0] = arr[0];
			lst[i][1] = arr[1];
			
			if(lst[i][0].equals(name)) correctIdx = i;
		}
		
		String correct = lst[correctIdx][1];
		int res = 0;
		
		for(int i = 0; i < correctIdx; i ++) {
			if(lst[i][1].equals(correct)) {
				res+=1;
			}
		}
		
		System.out.println(res);

	}

}
