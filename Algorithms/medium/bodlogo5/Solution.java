package bodlogo3;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
    // Write your code here
    Map<String, Integer> directions = new HashMap<>();
    directions.put("N", n - r_q);
    directions.put("S", r_q - 1);
    directions.put("E", n - c_q);
    directions.put("W", c_q - 1);
    directions.put("NE", Math.min(n - r_q, n - c_q));
    directions.put("NW", Math.min(n - r_q, c_q - 1));
    directions.put("SE", Math.min(r_q - 1, n - c_q));
    directions.put("SW", Math.min(r_q - 1, c_q - 1));


    for (List<Integer> obs : obstacles) {
        int r = obs.get(0);
        int c = obs.get(1);

        int deltaR = r - r_q;
        int deltaC = c - c_q;

        if (c == c_q) {
            if (r > r_q)
                directions.put("N", Math.min(directions.get("N"), r - r_q - 1));
            else
                directions.put("S", Math.min(directions.get("S"), r_q - r - 1));
        } else if (r == r_q) {
            if (c > c_q)
                directions.put("E", Math.min(directions.get("E"), c - c_q - 1));
            else
                directions.put("W", Math.min(directions.get("W"), c_q - c - 1));
        } else if (Math.abs(deltaR) == Math.abs(deltaC)) {
            if (deltaR > 0 && deltaC > 0)
                directions.put("NE", Math.min(directions.get("NE"), deltaR - 1));
            else if (deltaR > 0 && deltaC < 0)
                directions.put("NW", Math.min(directions.get("NW"), deltaR - 1));
            else if (deltaR < 0 && deltaC > 0)
                directions.put("SE", Math.min(directions.get("SE"), -deltaR - 1));
            else if (deltaR < 0 && deltaC < 0)
                directions.put("SW", Math.min(directions.get("SW"), -deltaR - 1));
        }
    }


    int total = 0;
    for (int steps : directions.values()) {
        total += steps;
    }

    return total;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> obstaclesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowTempItems[j]);
                obstaclesRowItems.add(obstaclesItem);
            }

            obstacles.add(obstaclesRowItems);
        }

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
