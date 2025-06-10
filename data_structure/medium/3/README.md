# Pairs

---Асуулт---"english" :
Given an array of integers and a target value, determine the number of pairs of array elements that have a difference equal to the target value.

Example


There are three values that differ by : , , and . Return .

Function Description

Complete the pairs function below.

pairs has the following parameter(s):

int k: an integer, the target difference
int arr[n]: an array of integers
Returns

int: the number of pairs that satisfy the criterion
Input Format

The first line contains two space-separated integers  and , the size of  and the target value.
The second line contains  space-separated integers of the array .

Constraints

each integer  will be unique
Sample Input

STDIN       Function
-----       --------
5 2         arr[] size n = 5, k =2
1 5 3 4 2   arr = [1, 5, 3, 4, 2]
Sample Output

3
Explanation

There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1]. .

---Асуулт---"Монголоор" :
Өгөгдсөн бүхэл тоонуудын массив болон зорилтот утгыг ашиглан, ялгаа нь тухайн зорилтот утгатай тэнцүү байх массив дахь хосуудын тоог тодорхойл.
Жишээ:
Жишээ нь, доорх массив дахь 3 утга дараах ялгаатай байна: 5 ба 3, 4 ба 2, 3 ба 1. Тэгэхээр хариу нь 3 байна.
Функцийн тодорхойлолт:
pairs функц нь дараах параметрүүдтэй байна:
int k: нэг бүхэл тоо, зорилтот ялгааны утга
int arr[n]: бүхэл тоонуудын массив
Буцаах утга:
int: өгөгдсөн шалгуурыг хангаж буй хосуудын тоо
Оролтын формат:
Эхний мөр нь хоёр зайгаар тусгаарлагдсан бүхэл тоо агуулна: массивын хэмжээ n ба ялгааны зорилтот утга k
Хоёрдугаар мөр нь n ширхэг бүхэл тоо агуулна — массивын элементүүд
Хязгаарлалт:
Массив дахь бүхэл тоо бүр давтагдашгүй байна
Жишээ оролт:
5 2
1 5 3 4 2
Жишээ гаралт:
3
Тайлбар:
Массив дахь 3 хос ялгаа нь 2-той тэнцүү байна. Эдгээр нь:
[5, 3]
[4, 2]
[3, 1]
Тиймээс хариу нь 3 юм.
---Код---" "
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    
    public static int pairs(int k, List<Integer> arr) {
    // Write your code here
  Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : arr) {
            if (set.contains(num - k)) count++;
            if (set.contains(num + k)) count++;
            set.add(num);
        }
        return count;
    }
    }
    



    

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

---Тайлбар---
![pairs](https://github.com/user-attachments/assets/b0dcb354-d974-43d5-b93f-694a028d7aa7)
