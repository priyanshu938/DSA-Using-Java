#include <bits/stdc++.h>
using namespace std;
void substring(string str, string ans)
{
    if (str == "")
    {
        cout << ans << endl;
        return;
    }
    char ch = str[0];
    string rest = str.substr(1);
    substring(rest, ans);
    substring(rest, ans + ch);
}
int main(int argc, char const *argv[])
{
    cout << "Enter a string" << endl;
    string str;
    cin >> str;
    cout << endl;
    cout << "Substrings of " << str << " are : " << endl;
    substring(str, "");
    return 0;
}
