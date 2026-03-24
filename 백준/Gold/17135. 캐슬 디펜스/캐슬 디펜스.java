import java.io.*;
import java.util.*;

public class Main {
    static int n, m, d;
    static int[][] map;
    static int[] archer = new int[3];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = i+1; j < m; j++) {
                for(int k = j+1; k < m; k++) {
                    archer[0] = i;
                    archer[1] = j;
                    archer[2] = k;

                    answer = Math.max(answer, simulate());
                }
            }
        }

        System.out.println(answer);
    }

    static int simulate() {
        int[][] temp = new int[n][m];
        for(int i = 0; i < n; i++) {
            temp[i] = map[i].clone();
        }

        int kill = 0;

        while(true) {
            List<int[]> targets = new ArrayList<>();

            for(int i = 0; i < 3; i++) {
                int minDist = Integer.MAX_VALUE;
                int tx = -1, ty = -1;

                for(int r = 0; r < n; r++) {
                    for(int c = 0; c < m; c++) {
                        if(temp[r][c] == 1) {
                            int dist = Math.abs(n - r) + Math.abs(archer[i] - c);

                            if(dist <= d) {
                                if(dist < minDist || 
                                  (dist == minDist && c < tx)) {
                                    minDist = dist;
                                    tx = c;
                                    ty = r;
                                }
                            }
                        }
                    }
                }

                if(tx != -1) {
                    targets.add(new int[]{ty, tx});
                }
            }

            for(int[] t : targets) {
                if(temp[t[0]][t[1]] == 1) {
                    kill++;
                    temp[t[0]][t[1]] = 0;
                }
            }

            for(int r = n-1; r > 0; r--) {
                temp[r] = temp[r-1].clone();
            }
            Arrays.fill(temp[0], 0);

            if(isEmpty(temp)) break;
        }

        return kill;
    }

    static boolean isEmpty(int[][] map) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) return false;
            }
        }
        return true;
    }
}