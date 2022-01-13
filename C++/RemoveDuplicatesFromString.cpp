#include <bits/stdc++.h>
using namespace std;
string remove(string str)
{
    if (str == "")
        return "";
    char ch = str[0];
    string restOfString = remove(str.substr(1));
    if (restOfString[0] == ch)
    {
        return restOfString;
    }
    else
    {
        return ch + restOfString;
    }
}
int main(int argc, char const *argv[])
{
    cout << "Enter a string" << endl;
    string str;
    cin >> str;
    cout << "String after removal of duplicates is : " << remove(str) << endl;
    return 0;
}
