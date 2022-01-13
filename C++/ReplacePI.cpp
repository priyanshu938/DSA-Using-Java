#include <bits/stdc++.h>
using namespace std;
class ReplacePi
{
public:
    void replace(string str)
    {
        if (str == "")
            return;
        if (str[0] == 'p' && str[1] == 'i')
        {
            cout << "3.14";
            replace(str.substr(2));
        }
        else
        {
            cout << str[0];
            replace(str.substr(1));
        }
    }
};
int main(int argc, char const *argv[])
{
    ReplacePi obj;
    string str;
    cout << "Enter a string :" << endl;
    cin >> str;
    cout << "Replaced string is :" << endl;
    obj.replace(str);
    return 0;
}
