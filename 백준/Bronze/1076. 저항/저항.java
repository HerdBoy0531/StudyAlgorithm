import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> valueMap = new HashMap<>();
        Map<String, Long> multiMap = new HashMap<>();

        valueMap.put("black", 0);
        valueMap.put("brown", 1);
        valueMap.put("red", 2);
        valueMap.put("orange", 3);
        valueMap.put("yellow", 4);
        valueMap.put("green", 5);
        valueMap.put("blue", 6);
        valueMap.put("violet", 7);
        valueMap.put("grey", 8);
        valueMap.put("white", 9);

        multiMap.put("black", 1L);
        multiMap.put("brown", 10L);
        multiMap.put("red", 100L);
        multiMap.put("orange", 1000L);
        multiMap.put("yellow", 10000L);
        multiMap.put("green", 100000L);
        multiMap.put("blue", 1000000L);
        multiMap.put("violet", 10000000L);
        multiMap.put("grey", 100000000L);
        multiMap.put("white", 1000000000L);

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        long result = (valueMap.get(first) * 10L + valueMap.get(second)) * multiMap.get(third);

        System.out.println(result);
    }
}