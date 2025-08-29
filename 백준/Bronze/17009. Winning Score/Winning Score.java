import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = 0;
		int B = 0;
		int[] arr = new int[6];
		for(int i = 0 ; i < 6; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		A = arr[0] * 3 + arr[1] * 2 + arr[2];
		B = arr[3] * 3 + arr[4] * 2 + arr[5];
		
		if(A > B) {
			System.out.println("A");
	    } else if (A < B) {
	        System.out.println("B");
	    } else {
	        System.out.println("T");
	    }
		
		br.readLine();
	}

}