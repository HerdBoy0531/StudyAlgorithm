import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr1 = br.readLine().split(" ");
		String[] arr2 = br.readLine().split(" ");
		
		int[] home = new int[5];
		int[] away = new int[5];
		
		for(int i = 0; i < 5; i++) {
			home[i] = Integer.parseInt(arr1[i]);
			away[i] = Integer.parseInt(arr2[i]);
		}
		
		int home_score = home[0]*6 + home[1]*3 + home[2]*2 + home[3] + home[4] * 2;
		int away_score = away[0]*6 + away[1]*3 + away[2]*2 + away[3] + away[4] * 2;
		
		System.out.println(home_score+" "+away_score);
		br.close();
	}

}