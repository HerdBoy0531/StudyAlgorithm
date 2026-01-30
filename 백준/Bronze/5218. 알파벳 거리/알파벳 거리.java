import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> solveAlphabetDistance(String s1, String s2) {

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i);
            int b = s2.charAt(i);

            if (a <= b) {
                answer.add(b - a);
            } else {
                answer.add(26 - (a - b));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        for (int i = 0; i < numCases; i++) {
            String s1 = sc.next();
            String s2 = sc.next();

            ArrayList<Integer> answer = solveAlphabetDistance(s1, s2);
            System.out.print("Distances: ");

            for (Integer d : answer) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
}
