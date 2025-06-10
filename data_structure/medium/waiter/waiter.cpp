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

