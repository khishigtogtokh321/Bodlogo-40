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
