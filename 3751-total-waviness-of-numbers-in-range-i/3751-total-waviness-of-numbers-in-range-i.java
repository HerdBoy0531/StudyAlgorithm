import java.util.*;

class Solution {
    static int[] waviness = new int[1000];

    int thous(int num) {
        int first = num / 10;
        int second = num % 1000;

        // if(second < 100) {
        //     return waviness[first - 100];
        // }

        return waviness[first] + waviness[second];
    }

    int tenThous(int num) {
        int first = num / 100;
        int second = num % 10000 / 10;
        int third = num % 1000;

        // if(second < 100) {
        //     if(third < 100) {
        //         return waviness[first - 100];
        //     }
        //     return waviness[first - 100] + waviness[third - 100];
        // }
        // if(third < 100) {
        //     return waviness[first - 100] + waviness[second - 100];
        // }

        return waviness[first] + waviness[second] + waviness[third];
    }

    public int totalWaviness(int num1, int num2) {
        for(int i = 0; i < 1000; i++) {
            int first = i / 100;
            int second = (i % 100) / 10;
            int third = i % 10;

            if(first < second && third < second) {
                waviness[i] = 1;
            }

            if(first > second && third > second) {
                waviness[i] = 1;
            }
        }

        int ans = 0;
        for(int i = num1; i <= num2; i++) {
            if(i < 100) continue;
            if(i == 100000) continue;
            if(i / 1000 > 0) {
                if(i / 10000 > 0) {
                    ans += tenThous(i);
                } else {
                    ans += thous(i);
                }
            } else {
                ans += waviness[i];
            }
        }

        for(int i = 98; i <= 102 ; i++){
            System.out.println(waviness[989]);
        }
        
        return ans;
    }

}