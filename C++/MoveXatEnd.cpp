#include <bits/stdc++.h>
using namespace std;
string moveX(string str)
{
    if (str == "")
        return "";
    char ch = str[0];
    string restOfString = moveX(str.substr(1));
    if (ch == 'x')
        return restOfString + ch;
    else
        return ch + restOfString;
}
int main(int argc, char const *argv[])
{
    cout << "Enter a string" << endl;
    string str;
    cin >> str;
    cout << "String after moving all x at the end is : " << moveX(str) << endl;
    return 0;
}
