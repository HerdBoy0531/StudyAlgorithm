import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int a = 0;
		for(int i = 0; i < 5; i++){
			int b = Integer.parseInt(arr[i]);
			a += b * b;	
		}
		System.out.println(a%10);
		
		br.close();
	}

}
