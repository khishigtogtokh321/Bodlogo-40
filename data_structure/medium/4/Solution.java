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
