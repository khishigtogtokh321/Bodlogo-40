package bodlogo3;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

 
 
      public static int lilysHomework(List<Integer> arr) {
           // Write your code here
        // Create copies to avoid modifying original array
        List<Integer> arrCopy1 = new ArrayList<>(arr);
        List<Integer> arrCopy2 = new ArrayList<>(arr);
        
        // Get sorted versions
        List<Integer> sortedAsc = new ArrayList<>(arr);
        Collections.sort(sortedAsc);
        
        List<Integer> sortedDesc = new ArrayList<>(sortedAsc);
        Collections.reverse(sortedDesc);
        
        // Count swaps for both orders
        int ascSwaps = countSwaps(arrCopy1, sortedAsc);
        int descSwaps = countSwaps(arrCopy2, sortedDesc);
        
        return Math.min(ascSwaps, descSwaps);
    }
    
    private static int countSwaps(List<Integer> arr, List<Integer> target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            valueToIndex.put(arr.get(i), i);
        }
        
        int swaps = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).equals(target.get(i))) {
                swaps++;
                int swapIndex = valueToIndex.get(target.get(i));
                
                // Swap elements
                Collections.swap(arr, i, swapIndex);
                
                // Update positions in map
                valueToIndex.put(arr.get(swapIndex), swapIndex);
                valueToIndex.put(arr.get(i), i);
            }
        }
        return swaps;
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

