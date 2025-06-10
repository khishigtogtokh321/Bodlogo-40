# waiter

# ---Асуулт---"english" :

You are given a list of numbers.
For each element at position 
𝑖
i, we define 
𝑃
(
𝑖
)
P(i) and 
𝑁
(
𝑖
)
N(i) as:

𝑃
(
𝑖
)
P(i) = closest index 
𝑗
j such that 
𝑗
<
𝑖
j<i and 
𝑎
[
𝑗
]
>
𝑎
[
𝑖
]
a[j]>a[i]. If no such 
𝑗
j exists then 
𝑃
(
𝑖
)
=
0
P(i)=0.

𝑁
(
𝑖
)
N(i) = closest index 
𝑘
k such that 
𝑘
>
𝑖
k>i and 
𝑎
[
𝑘
]
>
𝑎
[
𝑖
]
 a[k]>a[i]. If no such 𝑘 exists then 𝑁
(
𝑖
)
=
0
N(i)=0.

We define 
𝑆
(
𝑖
)
=
𝑃
(
𝑖
)
∗
𝑁
(
𝑖
)
S(i)=P(i)∗N(i).
You need to find out the maximum 
𝑆
(
𝑖
)
S(i) among all 
𝑖
i.

Input Format:
The first line contains an integer 
𝑛
n, the number of integers.
The next line contains the 
𝑛
n integers describing the list 
𝑎
[
1..
𝑛
]
a[1..n].

Constraints

Output Format:
Output the maximum 
𝑆
(
𝑖
)
S(i) among all indices from 1 to 
𝑛
n.

Sample Input:
5
5 4 3 4 5

Sample Output:
8

Explanation:
We can compute the following:
The largest of these is 8, so it is the answer.

# ---Асуулт---"Монголоор" :
Танд тоонуудын жагсаалт өгөгдсөн.
Жагсаалтын 
𝑖
i байрлал дахь элементийн хувьд 
𝑃
(
𝑖
)
P(i) ба 
𝑁
(
𝑖
)
N(i)-г дараах байдлаар тодорхойлно:

𝑃
(
𝑖
)
P(i) = 
𝑗
<
𝑖
j<i бөгөөд 
𝑎
[
𝑗
]
>
𝑎
[
𝑖
]
a[j]>a[i] байх хамгийн ойр индекс 
𝑗
j. Хэрвээ ийм 
𝑗
j байхгүй бол 
𝑃
(
𝑖
)
=
0
P(i)=0.

𝑁
(
𝑖
)
N(i) = 
𝑘
>
𝑖
k>i бөгөөд 
𝑎
[
𝑘
]
>
𝑎
[
𝑖
]
a[k]>a[i] байх хамгийн ойр индекс 
𝑘
k. Хэрвээ ийм 
𝑘
k байхгүй бол 
𝑁
(
𝑖
)
=
0
N(i)=0.

𝑆
(
𝑖
)
=
𝑃
(
𝑖
)
∗
𝑁
(
𝑖
)
S(i)=P(i)∗N(i) гэж тодорхойлъё.
Бүх 
𝑖
i-гийн хувьд хамгийн их 
𝑆
(
𝑖
)
S(i)-г ол.

Оролтын формат:
Эхний мөрөнд 
𝑛
n бүхэл тоо байна — тоонуудын тоо.
Дараагийн мөрөнд жагсаалтыг илэрхийлэх 
𝑛
n ширхэг бүхэл тоо өгөгдөнө 
𝑎
[
1..
𝑛
]
a[1..n].

Гаралтын формат:
1-ээс 
𝑛
n хүртэлх бүх индексийн хувьд хамгийн их 
𝑆
(
𝑖
)
S(i)-г хэвлэ.

Жишээ оролт:
5
5 4 3 4 5

Жишээ гаралт:
8
# ---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

long long solve(vector<long> arr) {
    vector<long> prevBigger(arr.size() + 1);
    vector<long> nextBigger(arr.size() + 1);
    for (int i =2; i<= arr.size(); i++ ){
        if (arr[i - 1] < arr[i - 2]) {
            prevBigger[i] = i - 1;
        } else {
            long it = prevBigger[i - 1];
            
            while (arr[it - 1] < arr[i - 1] && it != 0) {
                it = prevBigger[it];
            }
            
            prevBigger[i] = prevBigger[it];
        } 
    } 
    
    for (int i = arr.size() - 1; i >= 1; i--) {
        if (arr[i] > arr[i - 1]) {
            nextBigger[i] = i+ 1;
        } else {
            long it = nextBigger[i+1];
            while (it != 0 && arr[i - 1] > arr[it - 1]) {
                it = nextBigger[it];
            }
            nextBigger[i] = nextBigger[it];
        }
    }
    long long res = 0;
    for (int i = 1; i<= arr.size(); i++) {
        long long t = prevBigger[i] * nextBigger[i];
        if (t > res) {
            res = t;
        }
    }
    return res;
}

int main()
{
    // std::ifstream in("input.txt");
    // std::streambuf *cinbuf = std::cin.rdbuf(); //save old buf
    // std::cin.rdbuf(in.rdbuf()); //redirect std::cin to in.txt!
    
    // std::ofstream fout("output.txt");
    ofstream fout(getenv("OUTPUT_PATH"));

    string arr_count_temp;
    getline(cin, arr_count_temp);

    int arr_count = stoi(ltrim(rtrim(arr_count_temp)));

    string arr_temp_temp;
    getline(cin, arr_temp_temp);

    vector<string> arr_temp = split(rtrim(arr_temp_temp));

    vector<long> arr(arr_count);

    for (int i = 0; i < arr_count; i++) {
        long arr_item = stol(arr_temp[i]);

        arr[i] = arr_item;
    }

    long long result = solve(arr);

    fout << result << "\n";

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

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}
---Тайлбар--- 
![find-max-index](https://github.com/user-attachments/assets/d11ac028-633e-4e1a-a5b5-cb51816d4915)
