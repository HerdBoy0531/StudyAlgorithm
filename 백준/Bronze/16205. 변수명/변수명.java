import java.io.*;
import java.util.*;

public class Main {

    static List<String> splitWords(String s) {
        List<String> words = new ArrayList<>();

        if (s.contains("_")) {
            String[] arr = s.split("_");
            for (String w : arr) words.add(w.toLowerCase());
        }
        else {
            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    if (sb.length() > 0) {
                        words.add(sb.toString().toLowerCase());
                        sb = new StringBuilder();
                    }
                }
                sb.append(c);
            }

            if (sb.length() > 0)
                words.add(sb.toString().toLowerCase());
        }

        return words;
    }

    static String toCamel(List<String> words) {
        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0));

        for (int i = 1; i < words.size(); i++) {
            sb.append(words.get(i).substring(0, 1).toUpperCase());
            sb.append(words.get(i).substring(1));
        }

        return sb.toString();
    }

    static String toPascal(List<String> words) {
        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            sb.append(w.substring(0, 1).toUpperCase());
            sb.append(w.substring(1));
        }

        return sb.toString();
    }

    static String toSnake(List<String> words) {
        return String.join("_", words);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        String input = arr[1];

        List<String> words = splitWords(input);

        System.out.println(toCamel(words));
        System.out.println(toSnake(words));
        System.out.println(toPascal(words));
    }
}
