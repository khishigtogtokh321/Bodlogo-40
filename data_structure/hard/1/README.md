# Find the running median

---Асуулт---"english" :
The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your set of integers in non-decreasing order, then:

If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set ,  is the median.
If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted set ,  is the median.
Given an input stream of  integers, perform the following task for each  integer:

Add the  integer to a running list of integers.
Find the median of the updated list (i.e., for the first element through the  element).
Print the updated median on a new line. The printed value must be a double-precision number scaled to  decimal place (i.e.,  format).
Example

Sorted          Median
[7]             7.0
[3, 7]          5.0
[3, 5, 7]       5.0
[2, 3, 5, 7]    4.0
Each of the median values is stored in an array and the array is returned for the main function to print.

Note: Add formatting to the print statement.

Function Description
Complete the runningMedian function in the editor below.

runningMedian has the following parameters:
- int a[n]: an array of integers

Returns
- float[n]: the median of the array after each insertion, modify the print statement in main to get proper formatting.

Input Format

The first line contains a single integer, , the number of integers in the data stream.
Each line  of the  subsequent lines contains an integer, , to be inserted into the list.

Constraints

Sample Input

STDIN   Function
-----   --------
6       a[] size n = 6
12      a = [12, 4, 5, 3, 8, 7]
4
5
3
8
7
Sample Output

12.0
8.0
5.0
4.5
5.0
6.0
Explanation

There are  integers, so we must print the new median on a new line as each integer is added to the list:



# ---Асуулт---"Монголоор" :
Бүхэл тоонуудын цуглуулгын медиан гэдэг нь тухайн өгөгдлийн дунд хэсгийн утга бөгөөд энэ утгаас бага, их тоонуудын тоо ижил байна.
Медианыг олохын тулд эхлээд бүх тоонуудыг өсөх дарааллаар эрэмбэлнэ. Дараа нь:

Хэрвээ таны цуглуулгад сондгой тооны элемент байвал, медиан нь дунд талын элемент байна. Эрэмбэлэгдсэн цуглуулгад тэр нь медиан болно.

Хэрвээ таны цуглуулгад тэгш тооны элемент байвал, медиан нь хоёр дунд талын элементийн дундаж байна. Эрэмбэлэгдсэн цуглуулгад энэ нь медиан болно.

Өгөгдсөн урсгалаар ирэх 
𝑛
n ширхэг бүхэл тооны хувьд дараах үйлдлийг бүр тоо дээр гүйцэтгэнэ:

𝑖
i дахь тоог жагсаалт руу нэмнэ.

Шинэчлэгдсэн жагсаалтын медианыг олно (жишээ нь эхний 
𝑖
i тооны хувьд).

Шинэ медианыг шинэ мөрөнд хэвлэнэ. Хэвлэгдэх утга нь нэг оронгийн нарийвчлалтай хөвөгч таслалттай тоо байх ёстой (жишээ нь %.1f формат).

Жишээ:

csharp
Copy
Edit
Эрэмбэлэгдсэн       Медиан
[7]                 7.0
[3, 7]              5.0
[3, 5, 7]           5.0
[2, 3, 5, 7]        4.0
Медиануудын утгыг массивт хадгалж, энэ массивыг үндсэн функц хэвлэнэ.
Тайлбар: Хэвлэлийн мөрөнд формат нэмэх шаардлагатай.
Функцийн тодорхойлолт:
runningMedian функцыг дараах байдлаар гүйцээнэ:
runningMedian нь дараах параметртэй:
int a[n]: бүхэл тоонуудын массив
Буцаах утга:
float[n]: бүр тоо нэмэгдэх бүрд үүсэх жагсаалтын медиан
Оролтын формат:
Эхний мөрөнд нэг бүхэл тоо өгөгдөнө — урсгалаар ирэх тоонуудын тоо 
n.
Дараагийн 
n мөр тус бүрд нэг бүхэл тоо a[i] өгөгдөнө.

Жишээ оролт:

STDIN   Function
-----   --------
6       a[] хэмжээтэй массив (n = 6)
12      a = [12, 4, 5, 3, 8, 7]
4
5
3
8
7
Жишээ гаралт:

12.0  
8.0  
5.0  
4.5  
5.0  
6.0  

# ---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'runningMedian' function below.
 *
 * The function is expected to return a DOUBLE_ARRAY.
 * The function accepts INTEGER_ARRAY a as parameter.
 */
vector<double> runningMedian(vector<int> const&a) {
    if(0==a.size())
        return vector<double>();
    map<int,int> aux; 
    aux.insert({a[0],1});
    auto lowerMed = aux.begin();
    vector<double> retq;
    retq.push_back(1.0*(lowerMed->first));
    int pos=0;
    for(int i=1; i<a.size();i++)
    {
        if(!aux.count(a[i]))
            aux.insert({a[i],1});
        else{aux[a[i]]++;}
        if((a[i]<lowerMed->first)&&(i&1))
            pos--;
        else if((a[i]>=lowerMed->first)&&(0==(i&1)))
            pos++;
        if(0>pos)
        {
            lowerMed--;
            pos=lowerMed->second-1;
        }
        else if(lowerMed->second<=pos)
        {
            lowerMed++;
            pos=0;
        }
        if(0==(i&1))
        {
            retq.push_back(1.0*(lowerMed->first));
        }
        else
        {
            auto x=lowerMed;
            if(pos+1>=lowerMed->second)
                x++; 
            retq.push_back(0.5*(lowerMed->first + x->first));
        }
    }
    return retq;
}
int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string a_count_temp;
    getline(cin, a_count_temp);

    int a_count = stoi(ltrim(rtrim(a_count_temp)));

    vector<int> a(a_count);

    for (int i = 0; i < a_count; i++) {
        string a_item_temp;
        getline(cin, a_item_temp);

        int a_item = stoi(ltrim(rtrim(a_item_temp)));

        a[i] = a_item;
    }

    vector<double> result = runningMedian(a);

    for (size_t i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

# ---Тайлбар---
![find running median](https://github.com/user-attachments/assets/c760a0af-af4f-4bdc-9425-7afe3292ff5b)
