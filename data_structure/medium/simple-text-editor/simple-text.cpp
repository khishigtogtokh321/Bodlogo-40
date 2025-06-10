#include <iostream>
#include <stack>
using namespace std;

int main() {
    int Q;
    cin >> Q;
    string current = "";
    stack<string> history;

    while (Q--) {
        int type;
        cin >> type;

        if (type == 1) {
            string s;
            cin >> s;
            history.push(current);
            current += s;
        } 
        else if (type == 2) {
            int k;
            cin >> k;
            history.push(current);
            current.erase(current.size() - k);
        } 
        else if (type == 3) {
            int k;
            cin >> k;
            cout << current[k - 1] << endl;
        } 
        else if (type == 4) {
            if (!history.empty()) {
                current = history.top();
                history.pop();
            }
        }
    }
    return 0;
}