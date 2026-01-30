import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] arr = new String[7][2];
		StringTokenizer st;
		
		for(int i = 0; i < 7; i++) {
			String[] input = br.readLine().split(" ");
			arr[i][0] = input[0];
			arr[i][1] = input[1];
		}
		
        List<String[]> list = new ArrayList<>(Arrays.asList(arr));

        Collections.sort(list, (a, b) ->
            Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1]))
        );

        System.out.println(list.get(0)[0]);
		
	}

}