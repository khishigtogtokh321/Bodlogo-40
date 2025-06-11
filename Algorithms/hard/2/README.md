# Highest Value Palindrome

## ---Асуулт---"english" :
Palindromes are strings that read the same from the left or right, for example madam or 0110.

You will be given a string representation of a number and a maximum number of changes you can make. Alter the string, one digit at a time, to create the string representation of the largest number possible given the limit to the number of changes. The length of the string may not be altered, so you must consider 's left of all higher digits in your tests. For example  is valid,  is not.

Given a string representing the starting number, and a maximum number of changes allowed, create the largest palindromic string of digits possible or the string '-1' if it is not possible to create a palindrome under the contstraints.

Example


Make  replacements to get .



Make  replacement to get .

Function Description

Complete the highestValuePalindrome function in the editor below.

highestValuePalindrome has the following parameter(s):

string s: a string representation of an integer
int n: the length of the integer string
int k: the maximum number of changes allowed
Returns

string: a string representation of the highest value achievable or -1
Input Format

The first line contains two space-separated integers,  and , the number of digits in the number and the maximum number of changes allowed.
The second line contains an -digit string of numbers.

Constraints

Each character  in the number is an integer where .
Output Format

Sample Input 0

STDIN   Function
-----   --------
4 1     n = 4, k = 1
3943    s = '3943'
Sample Output 0

3993
Sample Input 1

6 3
092282
Sample Output 1

992299
Sample Input 2

4 1
0011
Sample Output 2

-1
Explanation

Sample 0

There are two ways to make  a palindrome by changing no more than  digits:
## ---Асуулт---"Монголоор" :
 Бодлогын тайлбар :
Палиндром гэдэг нь хоёр талаасаа ижилхэн уншигддаг тоо буюу тэмдэгт мөр юм.
Жишээ нь: “madam” болон “0110” бол палиндромууд.
Танд нэг тоог тэмдэгт мөр (string) хэлбэрээр өгнө.
Та тухайн тэмдэгт мөр дотроос зарим цифрүүдийг өөрчлөх боломжтой.
Гэхдээ хамгийн ихдээ k удаа өөрчилж болно.
Тэмдэгт мөрийн уртыг өөрчилж болохгүй.
Зорилго нь: боломжийн хамгийн их утгатай палиндром үүсгэх юм.
Хэрвээ палиндром үүсгэх боломжгүй бол "-1" гэж буцаах хэрэгтэй.
 Функцийн тайлбар :
highestValuePalindrome гэдэг функц бичих шаардлагатай.
Энэ функц гурван параметр авна:
Нэгт: s — анхны тоог илэрхийлэх тэмдэгт мөр
Хоёрт: n — тэмдэгт мөрийн урт
Гуравт: k — өөрчилж болох дээд тоо
Функцийн зорилго бол: хамгийн том утгатай палиндром үүсгээд буцаах.
Хэрвээ бүтэх боломжгүй бол "-1" буцаана.
 Оролт болон гаралтын жишээ:
 Жишээ 1:
Оролт: n = 4, k = 1, s = "3943"
Гаргалт: "3993"
Тайлбар: Зөвхөн 4-ийг 9 болгож 1 өөрчлөлт хийснээр палиндром үүссэн.
 Жишээ 2:
Оролт: n = 6, k = 3, s = "092282"
Гаргалт: "992299"
Тайлбар: 3 өөрчлөлт хийснээр хамгийн том палиндром үүссэн.
 Жишээ 3:
Оролт: n = 4, k = 1, s = "0011"
Гаргалт: "-1"
Тайлбар: Зөвхөн 1 удаа өөрчлөх боломжтой ч палиндром болгоход 2 өөрчлөлт хэрэгтэй тул боломжгүй.
## ---Код---"java"

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
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {

        char[] arr = s.toCharArray();
        int left = 0;
        int right = n - 1;
        int changes = 0;

        while (left < right) {
            if (arr[left] != arr[right]) {
                char maxChar = (char) Math.max(arr[left], arr[right]);
                arr[left] = maxChar;
                arr[right] = maxChar;
                changes++;
            }
            left++;
            right--;
        }

        if (changes > k) {
            return "-1"; 
        }

        left = 0;
        right = n - 1;
        while (left <= right) {
            if (left == right) {
                if (k - changes > 0) {
                    arr[left] = '9';
                }
            } else {
                if (arr[left] < '9') {
                    if (k - changes >= 2 && arr[left] == s.charAt(left) && arr[right] == s.charAt(right)) {
                        
                        arr[left] = '9';
                        arr[right] = '9';
                        changes += 2;
                    } else if (k - changes >= 1 && s.charAt(left) != s.charAt(right)) {
                        
                        arr[left] = '9';
                        arr[right] = '9';
                        changes++;
                    }
                }
            }
            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Read the number of digits, maximum changes, and the string representation
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();

        // Call the function to find the highest value palindrome
        String result = highestValuePalindrome(s, n, k);

        // Output: Print the result
        System.out.println(result);

        // Close the scanner
        scanner.close();
    }
}


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
## ---Тайлбар--- ![Screenshot 2025-06-09 171040](https://github.com/user-attachments/assets/f4c92a95-a77f-405f-b1e8-6a13259d2d6d)
Энэ програмын зорилго нь өгөгдсөн тоон тэмдэгт мөрийг хамгийн том утгатай палиндром болгох явдал юм. Тухайн тэмдэгт мөрийг зөвхөн хязгаарлагдмал тооны удаа өөрчилж болно. Хэрэв палиндром болгоход шаардлагатай өөрчлөлт нь зөвшөөрөгдсөн хязгаараас хэтэрвэл, ямар ч өөрчлөлт хийж чадахгүй тул “-1” гэсэн хариуг буцаадаг.

Програм эхлээд тэмдэгт мөрийг тэмдэгт бүрт задлан боловсруулж, зүүн ба баруун талаас зэрэг шалгадаг. Хоёр талаасаа ялгаатай тоонууд байвал, илүү том утгатайг нь аль аль талд нь бичиж палиндром болгоход шаардлагатай өөрчлөлтийг тоолдог.

Хэрвээ энэ эхний алхамд зөвшөөрсөн өөрчлөлтийн хэмжээнээс давсан бол шууд “боломжгүй” гэж үзээд дуусдаг. Хэрвээ хангалттай өөрчлөлт хийх боломж байвал, үлдсэн өөрчлөлтийн эрхийг ашиглан палиндромын дотоод утгыг аль болох “9” болгож ихэсгэхийг зорьдог. Ялангуяа хоёр талаасаа хоёуланг нь өөрчлөх боломжтой тохиолдолд, хоёр өөрчлөлтөөр нэг хосыг "9" болгож чаддаг.

Хэрвээ яг голд нэг орон тоо байгаа бол үлдсэн өөрчлөлтийн эрх байвал, тэр оронг мөн “9” болгоно. Эцэст нь, бүх өөрчлөлтүүдийг хийсний дараа хамгийн их утгатай палиндромыг бүтээж буцаадаг.
