import java.io.*;
import java.util.*;

public class Main {

    public static Stack<Integer> nums = new Stack<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split(" ");
            if(arr[0].equals("push")){
                nums.push(Integer.parseInt(arr[1]));
                continue;
            }
            if(arr[0].equals("pop")){
                if(!nums.isEmpty()){
                    int pop_num = nums.pop();
                    System.out.println(pop_num);
                    continue;
                }
                System.out.println(-1);
            }
            if(arr[0].equals("size")){
                System.out.println(nums.size());
                continue;
            }

            if(arr[0].equals("empty")){
                if(!nums.isEmpty()){
                    System.out.println(0);
                    continue;
                }
                System.out.println(1);
                continue;
            }
            if(arr[0].equals("top")){
                if(!nums.isEmpty()){
                    System.out.println(nums.peek());
                    continue;
                }
                System.out.println(-1);
                continue;
            }
        }

        br.close();
    }
}
