# min-penalty-path

---Асуулт---"english" :
Consider an undirected graph containing  nodes and  edges. Each edge  has an integer cost, , associated with it.

The penalty of a path is the bitwise OR of every edge cost in the path between a pair of nodes,  and . In other words, if a path contains edges , then the penalty for this path is  OR  OR ... OR .

Given a graph and two nodes,  and , find the path between  and  having the minimal possible penalty and print its penalty; if no such path exists, print  to indicate that there is no path from  to .

Note: Loops and multiple edges are allowed. The bitwise OR operation is known as or in Pascal and as | in C++ and Java.

Input Format

The first line contains two space-separated integers,  (the number of nodes) and  (the number of edges), respectively.

Each line  of the  subsequent lines contains three space-separated integers , , and , respectively, describing edge  connecting the nodes  and  and its associated penalty ().

The last line contains two space-separated integers,  (the starting node) and  (the ending node), respectively.

Constraints

Output Format

Print the minimal penalty for the optimal path from node  to node ; if no path exists from node  to node , print .

Sample Input

3 4
1 2 1
1 2 1000
2 3 3
1 3 100
1 3
Sample Output

3
Explanation

The optimal path is .
 and .
The penalty for this path is:  OR , so we print .

---Асуулт---"Монголоор" :
Хамгийн бага торгуульт замыг олох зорилготойгоор, нодууд ба ирмэгүүдээс тогтсон чиглэлгүй граф өгөгджээ. Граф дахь бүх ирмэг бүр тодорхой бүхэл тоон зардал (торгууль) агуулна.
Нэг замын торгууль нь тухайн замд багтсан бүх ирмэгийн торгуулийн битийн "OR" үйлдлийн нийлбэр юм. Өөрөөр хэлбэл, хэрэв зам нь ирмэгүүдийн дарааллаар явбал, түүний торгууль нь w1 OR w2 OR ... OR wn байна.
Танд нэг граф болон хоёр орой (нодууд) өгөгдөх ба, энэ хоёр оройн хоорондын хамгийн бага торгуульт замыг олоорой. Хэрэв ийм зам байхгүй бол -1 гэж хэвлэнэ үү.
Тайлбар: Граф нь давхардсан ирмэг болон өөр дээрээ буцдаг ирмэг (loop) агуулж болно. Bitwise OR үйлдлийг Pascal хэл дээр or, харин C++ ба Java дээр | гэж бичдэг.
Оролтын формат:
Эхний мөрөнд хоёр бүхэл тоо: n (нодуудын тоо) болон m (ирмэгийн тоо)
Дараагийн m мөр бүрд гурван бүхэл тоо: u v w — u болон v нодуудыг холбосон ирмэг ба торгууль w
Сүүлийн мөрөнд хоёр бүхэл тоо: s болон t — эхлэл ба төгсгөлийн нодууд
Хязгаарлалт:
Тусгай хязгаарлалт заагаагүй боловч, граф нь өөр дээрээ ирмэгтэй болон олон ирмэгтэй байж болно.
Гаралтын формат:
Хамгийн бага боломжит торгуульт замыг хэвлэнэ. Хэрвээ зам байхгүй бол -1 гэж хэвлэнэ үү.
Жишээ оролт:
3 4  
1 2 1  
1 2 1000  
2 3 3  
1 3 100  
1 3
Жишээ гаралт:
3
Тайлбар:
Хамгийн бага торгуульт зам нь:
1 → 2 → 3
Торгууль нь:
1 OR 3 = 3
Тиймээс хариу нь 3 болно.
---Код---" "
#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

/*
 * Complete the 'beautifulPath' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. 2D_INTEGER_ARRAY edges
 *  2. INTEGER A
 *  3. INTEGER B
 */

int beautifulPath(vector<vector<int>> edges, int A, int B) {
 vector<vector<pair<int, int>>> graph(10e4 + 1); // {node, {child, weight}}
    vector<vector<bool>> seen(10e4 + 1, vector<bool>(1024, false)); // {node, {with what weight we came}}
    for (vector<int> &edge : edges) {
        graph[edge[0]].push_back({edge[1], edge[2]});
        graph[edge[1]].push_back({edge[0], edge[2]});
    }
    int penaltyCost = INT_MAX;
    queue<vector<int>> todo; // {weight, node} minHeap
    todo.push({0, A});
    seen[A][0] = true; // Assume we reached node A with 0 total weight
    while (!todo.empty()) {
        vector<int> cur = todo.front();
        todo.pop();
        // If we reach target, save min penalty
        if (cur[1] == B) {
            penaltyCost = min(penaltyCost, cur[0]);
        }
        for (pair<int, int> &child : graph[cur[1]]) {
            if (seen[child.first][cur[0] | child.second] == false) {
                // Update new weight by OR'ing with parent's weight
                todo.push({cur[0] | child.second, child.first});
                seen[child.first][cur[0] | child.second] = true;
            }
        }
    }
    return (penaltyCost == INT_MAX ? -1 : penaltyCost);
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int n = stoi(first_multiple_input[0]);

    int m = stoi(first_multiple_input[1]);

    vector<vector<int>> edges(m);

    for (int i = 0; i < m; i++) {
        edges[i].resize(3);

        string edges_row_temp_temp;
        getline(cin, edges_row_temp_temp);

        vector<string> edges_row_temp = split(rtrim(edges_row_temp_temp));

        for (int j = 0; j < 3; j++) {
            int edges_row_item = stoi(edges_row_temp[j]);

            edges[i][j] = edges_row_item;
        }
    }

    string second_multiple_input_temp;
    getline(cin, second_multiple_input_temp);

    vector<string> second_multiple_input = split(rtrim(second_multiple_input_temp));

    int A = stoi(second_multiple_input[0]);

    int B = stoi(second_multiple_input[1]);

    int result = beautifulPath(edges, A, B);

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
![min-penalty](https://github.com/user-attachments/assets/0ffa93df-596a-4f3c-af17-4a4e61bb2d3c)
