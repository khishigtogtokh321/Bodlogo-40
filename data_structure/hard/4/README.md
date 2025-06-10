# queries-with-fixed-length

---Асуулт---"english" :
Consider an -integer sequence, . We perform a query on  by using an integer, , to calculate the result of the following expression:

In other words, if we let , then you need to calculate .

Given  and  queries, return a list of answers to each query.

Example


The first query uses all of the subarrays of length : . The maxima of the subarrays are . The minimum of these is .

The second query uses all of the subarrays of length : . The maxima of the subarrays are . The minimum of these is .

Return .

Function Description

Complete the solve function below.

solve has the following parameter(s):

int arr[n]: an array of integers
int queries[q]: the lengths of subarrays to query
Returns

int[q]: the answers to each query
Input Format

The first line consists of two space-separated integers,  and .
The second line consists of  space-separated integers, the elements of .
Each of the  subsequent lines contains a single integer denoting the value of  for that query.

Constraints

Sample Input 0

5 5
33 11 44 11 55
1
2
3
4
5
Sample Output 0

11
33
44
44
55
Explanation 0

For , the answer is

.
For , the answer is
.
For , the answer is
.
For , the answer is
.
For , the answer is
.
Sample Input 1

5 5
1 2 3 4 5
1
2
3
4
5
Sample Output 1

1
2
3
4
5
Explanation 1

For each query, the "prefix" has the least maximum value among the consecutive subsequences of the same size.

---Асуулт---"Монголоор" :
n бүхэл тооноос бүрдсэн дараалал өгөгдсөн гэж үзье.
Бид уг дараалалд нэг бүхэл тоо болох d ашиглан дараах илэрхийллийг бодох асуулт тавина:

min(all subarray maxima of length d)
Өөрөөр хэлбэл, урт нь d тэнцүү бүх дэд массивуудын хамгийн их утгуудыг олж, тэдгээрийн дундаас хамгийн бага утгыг авна.

Танд arr массив болон queries гэсэн d утгуудын жагсаалт өгөгдөнө.
Танд асуулт бүрийн хариуг жагсаалтаар буцаах хэрэгтэй.

Жишээ:

Эхний асуулт нь урт нь 1 тэнцүү бүх дэд массивуудыг авна: [33], [11], [44], [11], [55].
Эдгээрийн хамгийн их утгууд: 33, 11, 44, 11, 55. Эдгээрийн хамгийн бага нь: 11.

Хоёр дахь асуулт нь урт нь 2 тэнцүү дэд массивуудыг авна: [33 11], [11 44], [44 11], [11 55].
Хамгийн их утгууд: 33, 44, 44, 55. Эдгээрийн хамгийн бага нь: 33.

Ингээд үр дүн нь: [11, 33, 44, 44, 55].

Функцийн тайлбар:

solve функц дараах параметрүүдтэй:

int arr[n]: бүхэл тоон дараалал

int queries[q]: дэд массивын уртуудыг илэрхийлэх бүхэл тоонуудын жагсаалт

Буцаах утга:

int[q]: асуулт бүрийн хариу

Оролтын формат:

Эхний мөрөнд хоёр бүхэл тоо: n ба q

Хоёр дахь мөрөнд n ширхэг бүхэл тоо (arr)

Дараагийн q мөрөнд тус бүр нэг бүхэл тоо байгаа ба энэ нь d утга
---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

/*
 * Complete the 'solve' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY arr
 *  2. INTEGER_ARRAY queries
 */
void add(deque<int>& q, int v){
    while(!q.empty() && q.back() < v) q.pop_back();
    q.push_back(v);      
}

int getMax(deque<int>& q){ return q.front(); }

void pop(deque<int>& q, int rv){
    if(!q.empty() && rv == q.front()) q.pop_front();
}

int computeMinOfSubarrays(vector<int> maxs){
    int ans = INT_MAX;
    for(auto m : maxs) ans = min(ans, m);
    return ans;    
}

vector<int> solve(vector<int> arr, vector<int> queries) {
   vector<int> mins;
   for(auto subArrayLength : queries){
       deque<int> q; vector<int> maxs; 
       int size = 0;
       int toBeRemoved = 0;
       for(int i=0; i<arr.size(); ++i){
           add(q, arr[i]);
           size++;
           if(size == subArrayLength){
               size -= 1;
               maxs.push_back(getMax(q));
               pop(q, arr[toBeRemoved++]);
           }
       }
       mins.push_back(computeMinOfSubarrays(maxs));
   } 
   return mins; 
}
int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int n = stoi(first_multiple_input[0]);

    int q = stoi(first_multiple_input[1]);

    string arr_temp_temp;
    getline(cin, arr_temp_temp);

    vector<string> arr_temp = split(rtrim(arr_temp_temp));

    vector<int> arr(n);

    for (int i = 0; i < n; i++) {
        int arr_item = stoi(arr_temp[i]);

        arr[i] = arr_item;
    }

    vector<int> queries(q);

    for (int i = 0; i < q; i++) {
        string queries_item_temp;
        getline(cin, queries_item_temp);

        int queries_item = stoi(ltrim(rtrim(queries_item_temp)));

        queries[i] = queries_item;
    }

    vector<int> result = solve(arr, queries);

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
![image](https://github.com/user-attachments/assets/4798e20a-129f-4934-83fc-ded97dbbcfca)
