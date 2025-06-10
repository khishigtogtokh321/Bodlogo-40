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

