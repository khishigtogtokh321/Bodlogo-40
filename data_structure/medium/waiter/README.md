# waiter

---Асуулт---"english" :
You are a waiter at a party. There is a pile of numbered plates. Create an empty  array. At each iteration, , remove each plate from the top of the stack in order. Determine if the number on the plate is evenly divisible by the  prime number. If it is, stack it in pile . Otherwise, stack it in stack . Store the values in  from top to bottom in . In the next iteration, do the same with the values in stack . Once the required number of iterations is complete, store the remaining values in  in , again from top to bottom. Return the  array.

Example
An abbreviated list of primes is . Stack the plates in reverse order.
Begin iterations. On the first iteration, check if items are divisible by .
Move  elements to .
On the second iteration, test if  elements are divisible by .
Move  elmements to .
And on the third iteration, test if  elements are divisible by .
Move  elmements to .
All iterations are complete, so move the remaining elements in , from top to bottom, to .
. Return this list.
Function Description
Complete the waiter function in the editor below.
waiter has the following parameters:
int number[n]: the numbers on the plates
int q: the number of iterations
Returns
int[n]: the numbers on the plates after processing
Input Format
The first line contains two space separated integers,  and .
The next line contains  space separated integers representing the initial pile of plates, i.e., .
Constraints
Sample Input 0
5 1
3 4 7 6 5
Sample Output 0
4
6
3
7
5
Explanation 
Initially:
 = [3, 4, 7, 6, 5]<-TOP

After 1 iteration (divide by 2, the 1st prime number):
 = [5, 7, 3]<-TOP
 = [6, 4]<-TOP
Move  elements to .
All iterations are complete, so move  elements to .
Sample Input 1
5 2
3 3 4 4 9
Sample Output 1
4
4
9
3
3
Explanation 1
Initially:
 = [3, 3, 4, 4, 9]<-TOP
After  iteration (divide by 2):
 = [9, 3, 3]<-TOP
 = [4, 4]<-TOP
Move  to .
After  iteration (divide by 3):
 = []<- TOP
 = [3, 3, 9]<-TOP
Move  elements to .
There are no values remaining in .
---Асуулт---"Монголоор" :
Нэг багц дугаарласан таваг байна. Эхлээд хоосон массив (list) үүсгэ.
Итерац бүрд дараах алхмуудыг хий:
stack-ийн орой талаас тавагнуудыг дарааллаар нь ав.
Таваган дээрх тоо нь тухайн үеийн i-дах анхны тоонд жигд хуваагдаж байгаа эсэхийг шалга.
Хэрвээ жигд хуваагддаг бол, B_i багц руу хий.
Үгүй бол A_i багц руу хий.
B_i багцын утгуудыг дээдээс нь доош result массив руу хадгал.
Дараагийн итерацид, A_i дээрээ яг энэ үйлдлүүдийг давтана.
q итерац дуусмагц, A багцад үлдсэн утгуудыг ч мөн адил дээд талаас нь доош result руу нэмнэ.
Анхны анхны тоонууд: [2, 3, 5, 7, 11, …]
Тавагнуудыг эсрэг дарааллаар жагсааж байрлуулна (хамгийн сүүлд бичигдсэн таваг хамгийн дээр байна).
Итерац эхэлнэ:
Эхний итерац: бүгдийг 2-т хуваагдаж байгаа эсэхийг шалгана
Хуваагдаж байвал → B1
Үгүй бол → A1
B1-г дээдээс доош result-д нэмнэ
Хоёр дахь итерац: A1-ээс авч, 3-т хуваагдах эсэхийг шалгана
Хуваагдаж байвал → B2
Үгүй бол → A2
B2-г result-д нэмнэ
Гурав дахь итерац: A2 дээр 5-т хуваагдах эсэхийг шалгана
Хуваагдвал → B3
Үгүй бол → A3
B3-г result-д нэмнэ
Ингээд бүх итерац дууссан бол, үлдсэн A3-ийн утгуудыг ч бас result-д нэмж дуусгана.
def waiter(number, q):
Оролт:
number[n]: Тавагнууд дээрх тоонууд (хамгийн сүүлд бичигдсэн нь дээр байрлана)
q: Итерацийн тоо (мөн q ширхэг анхны тоо ашиглана)
 Гаралт:
Боловсруулсан дарааллаар гарсан бүх тавагны дугаарууд (шинэ мөр бүрт нэг утга)
 Оролтын формат
Эхний мөр: n ба q гэсэн хоёр бүхэл тоо (таслалаар салгасан)
Хоёр дахь мөр: n ширхэг бүхэл тоо (анхны тавагнуудын дугаар)
Жишээ Оролт 1
5 1
3 4 7 6 5
Үйл явц:
Эхлээд:
A = [3, 4, 7, 6, 5] <- TOP
1-р итерац (анхны тоо 2):
Тавганд байгаа тоо	2-т хуваагдах уу Ямар багцад очих вэ
5	Үгүй	A1
6	Тийм	B1
7	Үгүй	A1
4	Тийм	B1
3	Үгүй	A1
B1 = [6, 4] <- TOP → [4, 6] → result руу орно
A1 = [3, 7, 5] <- TOP → [5, 7, 3] → мөн result руу орно
Гаралт:
4
6
3
7
5
 Жишээ Оролт 2
5 2
3 3 4 4 9
Эхлээд:
A = [3, 3, 4, 4, 9] <- TOP
Итерац 1 (анхны тоо: 2):
9 → A1
4 → B1
4 → B1
3 → A1
3 → A1
B1 = [4, 4] → result руу
A1 = [3, 3, 9]
Итерац 2 (анхны тоо: 3):
9 → B2
3 → B2
3 → B2
B2 = [3, 3, 9] → result руу
A2 = [] — юу ч үлдээгүй
Гаралт:
4
4
9
3
3
---Код---"c++"
#include <bits/stdc++.h>
using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

vector<int> waiter(vector<int> number, int q) {
    
    vector<int> v{};
    stack<int> snumber;
    vector<int> output;
    
    for(auto a : number)
    {
        cout<<a<<" ";
        snumber.push(a);
    }
    auto getprimes =[](int q){
            deque<int> primes{};
            int num = 2;
            while (static_cast<int>(primes.size()) < q) {
                bool is_prime = true;
                for (int i = 2; i <= std::sqrt(num); ++i) {
                    if (num % i == 0) {
                        is_prime = false;
                        break;
                    }
                }
                if (is_prime) {
                    primes.push_back(num);
                }
                num++;
            }
            return primes;
    };
    deque<int> nprimes = getprimes(q);
    while (!nprimes.empty()) {
        int prime = nprimes.front();
        nprimes.pop_front();
            stack<int> a;
            stack<int> b;
            while(!snumber.empty())
            {
               int top = snumber.top();
               snumber.pop();
               if(top%prime==0)
                    b.push(top);
               else
                    a.push(top);
            }
            while(!b.empty())
            {
                int top = b.top();
                b.pop();
                output.push_back(top);
            }
            snumber=a;
    }
    
    while(!snumber.empty())
    {
        int top = snumber.top();
        snumber.pop();
        output.push_back(top);
    
    }
    return output;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));
    int n = stoi(first_multiple_input[0]);
    int q = stoi(first_multiple_input[1]);

    string number_temp_temp;
    getline(cin, number_temp_temp);

    vector<string> number_temp = split(rtrim(number_temp_temp));
    vector<int> number(n);

    for (int i = 0; i < n; i++) {
        number[i] = stoi(number_temp[i]);
    }

    vector<int> result = waiter(number, q);

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
    s.erase(s.begin(), find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace))));
    return s;
}

string rtrim(const string &str) {
    string s(str);
    s.erase(find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(), s.end());
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
Эхлээд number-ийн бүх элементийг snumber stack-д оруулна.

Prime тоог олж авна.

Prime бүрээр snumber дахь тоог шалгаж, prime-д хуваагдах тоонуудыг b stack-д, бусдыг a stack-д хадгална.

b stack-аас pop хийж гаралт руу нэмнэ.

a-г дараагийн гүйлтэнд зориулан snumber болгож өөрчилнө.

Давталтыг prime тоо бүрээр гүйцэтгэнэ.

Эцэст нь үлдсэн snumber-ийн бүх тоог гаралт руу нэмнэ.

