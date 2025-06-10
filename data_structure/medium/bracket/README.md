# Bracket

---Асуулт---"english" :
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.

Function Description

Complete the function isBalanced in the editor below.

isBalanced has the following parameter(s):

string s: a string of brackets
Returns

string: either YES or NO
Input Format

The first line contains a single integer , the number of strings.
Each of the next  lines contains a single string , a sequence of brackets.

Constraints

, where  is the length of the sequence.
All chracters in the sequences ∈ { {, }, (, ), [, ] }.
Output Format

For each string, return YES or NO.

Sample Input

STDIN           Function
-----           --------
3               n = 3
{[()]}          first s = '{[()]}'
{[(])}          second s = '{[(])}'
{{[[(())]]}}    third s ='{{[[(())]]}}'
Sample Output

YES
NO
YES
Explanation

The string {[()]} meets both criteria for being a balanced string.
The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
The string {{[[(())]]}} meets both criteria for being a balanced string.

---Асуулт---"Монголоор" :
Тасалгааны хаалтын тэмдэгт гэдэг нь дараах аль нэг тэмдэгтүүд байж болно: (, ), {, }, [, эсвэл ].

Хоёр тасалгааны хаалтын тэмдэгт нь таарч байгаа хос гэж үздэг бол нээлттэй тасалгааны хаалтын тэмдэгт ( (, [, { ) баруун талд яг адилхан хаалтын тэмдэгттэй ( ), ], } ) байгаа тохиолдол юм. Ийм таарч байгаа гурван төрлийн хос байна: [], {}, ().

Гэхдээ таарч байгаа хос тасалгааны хаалт бүрэн тэнцвэртэй гэж тооцогдохгүй, учир нь түүний доторх тасалгааны хаалт таарч байгаа эсэхийг ч мөн шалгана. Жишээ нь, {[(])} гэдэг нь тэнцвэргүй, учир нь дотор нь байгаа тасалгааны хаалтууд таарч, зөв дарааллаар байрлаагүй байна. Талын тасалгааны хаалт дотор нэг нээлттэй тасалгааны хаалт (() байна, мөн тасалгааны хаалтны дотор хаалттай тасалгааны хаалт (]) байна.

Иймээс тасалгааны хаалтын дараалал тэнцвэртэй байх нөхцөл нь:

Ямар ч таараагүй тасалгааны хаалт байхгүй байх.

Тэнцвэртэй байгаа хосын доторх тасалгааны хаалт бас тэнцвэртэй байх.

Тэгэхээр, n тооны тасалгааны хаалтын дараалал өгөгдсөн байхад тус бүрийн тэнцвэртэй эсэхийг шалгаад, тэнцвэртэй бол "YES", тэнцвэргүй бол "NO" гэж хэвлэнэ.

Функцийн тайлбар

isBalanced функцэд нэг параметр орно:

s — тасалгааны хаалтын тэмдэгтүүдийн дараалал.

Функц нь "YES" эсвэл "NO" гэсэн тэмдэгт буцаана.

Оролтын формат

Эхний мөрөнд n — дарааллуудын тоо байна.

Дараагийн n мөрөнд тасалгааны хаалтын дараалал өгөгдөнө.

Жишээ оролт

3
{[()]}
{[(])}
{{[[(())]]}}

Жишээ гаралт

YES
NO
YES

Энэ нь ямар учиртай вэ гэвэл:

{[()]} — бүх тасалгааны хаалтууд зөв хослоод, доторх тасалгаанууд нь ч мөн зөв тэнцвэртэй байна.

{[(])} — доторх тасалгааны хаалтууд таарахгүй байгаа тул тэнцвэргүй.

{{[[(())]]}} — бүгд зөв дарааллаар таарч тэнцвэртэй.
---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

/*
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

string isBalanced(string s) {
    stack<char> st;
    for (char c : s) {
     
        if (c == '(' || c == '[' || c == '{') {
            st.push(c);
        } else {
            if (st.empty()) return "NO";
            
            char top = st.top();
            st.pop();
            if ((c == ')' && top != '(') ||
                (c == ']' && top != '[') ||
                (c == '}' && top != '{')) {
                return "NO";
            }
        }
    }
   
    return st.empty() ? "YES" : "NO";
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string t_temp;
    getline(cin, t_temp);

    int t = stoi(ltrim(rtrim(t_temp)));

    for (int t_itr = 0; t_itr < t; t_itr++) {
        string s;
        getline(cin, s);

        string result = isBalanced(s);

        fout << result << "\n";
    }

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

---Тайлбар--- 
Стек (stack) ашигласан нь учиртай:
Тасалгааны хаалтууд нь хамгийн сүүлд нээгдсэн нь хамгийн түрүүнд хаагдах ёстой тул LIFO (Last-In-First-Out) буюу сүүлд орсон нь эхэнд гарна гэсэн шинж чанартай байдаг. Стек энэ зарчмыг яг тохирохуйц өгөгдлийн бүтэц юм.

for (char c : s) — мөрний бүх тэмдэгтийг нэг нэгээр нь авч шалгана.

Хэрвээ c нь нээлттэй хаалт байвал st.push(c) гэж стек дээр хадгална.

Харин хаалтын хаалт байвал:

Стек хоосон бол шууд буцаана (тэнцвэргүй).

Стекнээс хамгийн сүүлд хадгалсан нээлттэй хаалтыг авна.

Тохирох хаалт эсэхийг шалгана.

Тохирохгүй бол буцаана (тэнцвэргүй).

Эцэст нь стек хоосон байвал бүх тасалгааны хаалт таарсан байна, "YES" гэж буцаана. Үгүй бол "NO".