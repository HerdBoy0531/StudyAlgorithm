import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Long K = Long.parseLong(st.nextToken());
		
		long[] arr = new long[N];
		String[] list = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(list[i]);
		}

		Map<Long, Long> hm = new HashMap<>();

        hm.put(0L, 1L); 

        long prefix = 0L;
        long answer = 0L;

        for (int i = 0; i < N; i++) {
            prefix += arr[i];
    
            answer += hm.getOrDefault(prefix - K, 0L);

            hm.put(prefix, hm.getOrDefault(prefix, 0L) + 1L);
        }

        System.out.println(answer);
	}

}