# lily


---Асуулт---"english" :
Whenever George asks Lily to hang out, she's busy doing homework. George wants to help her finish it faster, but he's in over his head! Can you help George understand Lily's homework so she can hang out with him?

Consider an array of  distinct integers, . George can swap any two elements of the array any number of times. An array is beautiful if the sum of  among  is minimal.

Given the array , determine and return the minimum number of swaps that should be performed in order to make the array beautiful.

Example


One minimal array is . To get there, George performed the following swaps:

    Swap      Result
          [7, 15, 12, 3]
    3 7   [3, 15, 12, 7]
    7 15  [3, 7, 12, 15]
   
It took  swaps to make the array beautiful. This is minimal among the choices of beautiful arrays possible.

Function Description

Complete the lilysHomework function in the editor below.

lilysHomework has the following parameter(s):

int arr[n]: an integer array
Returns

int: the minimum number of swaps required
Input Format

The first line contains a single integer, , the number of elements in . The second line contains  space-separated integers, .

Constraints

Sample Input

STDIN       Function
-----       --------
4           arr[]size n = 4
2 5 3 1     arr = [2, 5, 3, 1]
Sample Output

2
Explanation

Define  to be the beautiful reordering of . The sum of the absolute values of differences between its adjacent elements is minimal among all permutations and only two swaps ( with  and then  with ) were performed.

---Асуулт---"Монголоор" :
Жорж Лилигээ хамт тоглохыг урих бүрд Лили гэрийн даалгавар хийж завгүй байдаг.
Жорж түүнд хурдан дуусгахад нь туслахыг хүсдэг ч даалгавар нь түүний ойлгож чадахааргүй хэцүү байна!
Та Жоржид Лилигийн даалгаврыг ойлгуулахад нь тусалж чадах уу, ингэснээр Лили Жоржтой хамт тоглож чадна.

Бодлого:

arr гэж нэрлэгдэх бүхэл тоонуудын дахин давтагдаагүй массив өгөгдсөн гэж үзье.
Жорж энэ массив дахь аль ч хоёр элементийг дурын тооны удаа сольж болно.
Массив "үзэсгэлэнтэй" байх нь дараах нөхцөлтэй:
массив дахь хөрш элементүүдийн ялгааны абсолют утгуудын нийлбэр хамгийн бага байх.
Танд өгөгдсөн arr массивыг ашиглан, массивыг үзэсгэлэнтэй болгохын тулд хийгдэх ёстой хамгийн бага солилцоо (swap)-ны тоог олоорой.
Жишээ:
Нэг боломжит үзэсгэлэнтэй массив бол [3, 7, 12, 15] юм.
Үүнийг бүтээхийн тулд Жорж дараах солилцоог хийжээ:
Солилцоо	Үр дүн
3 ↔ 7	[3, 15, 12, 7]
7 ↔ 15	[3, 7, 12, 15]
Ингээд нийт 2 солилцоо хийсэн бөгөөд энэ нь боломжит үзэсгэлэнтэй массивууд дундаас хамгийн бага нь юм.
Функцийн тодорхойлолт:
Параметр:
int arr[n] — бүхэл тоонуудын массив
Буцаах утга:
int — массивыг үзэсгэлэнтэй болгохын тулд шаардлагатай хамгийн бага солилцооны тоо
Оролтын формат:
Эхний мөрөнд нэг бүхэл тоо n — массивын хэмжээ
Хоёр дахь мөрөнд n ширхэг зайгаар тусгаарлагдсан бүхэл тоо arr өгөгдөнө
Хязгаарлалт:
Массивын бүх элементүүд давтагдахгүй
Жишээ оролт:
4
2 5 3 1
Жишээ гаралт:
2
Тайлбар:
arr массивын үзэсгэлэнтэй хувилбар бол 1 2 3 5 юм.
Хөрш элементүүдийн ялгаанууд: |2-1| + |3-2| + |5-3| = 1 + 1 + 2 = 4
Энэ нь боломжит хамгийн бага утгуудын нэг бөгөөд, энэ хувилбар руу хүрэхийн тулд ердөө 2 солилцоо хийсэн
(Жишээлбэл: 5 ↔ 1, дараа нь 2 ↔ 3 гэх мэт).
---Код---"java8"
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int lilysHomework(int arr[], int arr2[]) 
        {        
        boolean isIdentical = true;
        Map<Integer, Integer> locations = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            locations.put(arr[i], i);
            if (arr[i]!=arr2[i])
            {
                isIdentical = false;
            }
        }
        int swapCount=0;
        if (isIdentical)
        {
            return swapCount;
        }
        for (int i=0; i<arr.length; i++)
        {
            if (arr[i]!=arr2[i])
            {
                int arrIndex = locations.get(arr2[i]);
                locations.put(arr[i], arrIndex);
                
                int temp = arr[i];
                arr[i]= arr2[arrIndex];
                arr[arrIndex] = temp;
                
                swapCount++;
            }
        }
        return swapCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int numberOfElements = scn.nextInt();

        int[] values = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            int value = scn.nextInt();
            values[i] = value;
        }
        int valuesCopy[] = values.clone();
        int sortedArray[] = values.clone();
        
        Arrays.sort(sortedArray);
        
        int[] reverseSortedArray = IntStream.range(0, sortedArray.length)
                          .map(i -> sortedArray[sortedArray.length-i-1])
                          .toArray();
        int regArraySwapCount = Result.lilysHomework(values, sortedArray);
        
        int reverseArraySwapCount = Result.lilysHomework(valuesCopy, reverseSortedArray);
        
        int result = Math.min(regArraySwapCount, reverseArraySwapCount);
        System.out.println(result);
       
    }
}
---Тайлбар--- 
![lily](https://github.com/user-attachments/assets/72dfbf79-7fb8-4350-b1f6-8b3e2080a5ad)
