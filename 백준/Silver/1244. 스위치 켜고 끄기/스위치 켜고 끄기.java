import java.io.*;

public class Main {
    public static int[] man(int[] res, int num){
        int cnt = 1;
        while(cnt*num-1 < res.length){
            res[cnt*num-1] = 1 - res[cnt*num-1];
            cnt++;
        }
        return res;
    }

    public static int[] woman(int[] res, int num){
        res[num]= 1 - res[num];
        for(int i = 1; i < res.length; i++){
            if(num - i < 0 || num + i >= res.length){
                break;
            }
            if(res[num-i] == res[num+i]){
                res[num-i] = 1 - res[num-i];
                res[num+i] = 1 - res[num+i];
            }
            else break;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =  Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] switch_st = new int[N];
        for(int i = 0 ; i < N ; i++){
            switch_st[i] = Integer.parseInt(arr[i]);
        }
        int stu = Integer.parseInt(br.readLine());
        int[] res = switch_st;

        for(int i = 0; i < stu; i++){
            String[] lst = br.readLine().split(" ");
            int gender = Integer.parseInt(lst[0]);
            int num = Integer.parseInt(lst[1]);
            if(gender == 1){
                res = man(res, num);
            }
            else res = woman(res, num-1);
        }

        for(int i = 0; i < N; i++){
            bw.write(res[i] + " ");
            if((i + 1) % 20 == 0) {
                bw.write("\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}