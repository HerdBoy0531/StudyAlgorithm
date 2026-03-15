import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> num = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine()) % 42;
			if(!num.contains(n)) {
				num.add(n);
			}
		}
		
		System.out.println(num.size());
	}

}

