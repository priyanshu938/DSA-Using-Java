#include <bits/stdc++.h>
using namespace std;
class ReverseAString
{
public:
    void reverse(string str)
    {
        if (str=="")
            return;
        reverse(str.substr(1));
        cout << str[0];
    }
};
int main(int argc, char const *argv[])
{
    cout << "Enter a string" << endl;
    string str;
    cin >> str;
    ReverseAString obj;
    cout << "Reverse of " << str << " is : " << endl;
    obj.reverse(str);
    return 0;
}
