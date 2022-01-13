#include <bits/stdc++.h>
using namespace std;
class Map_Demo
{
public:
    void display(map<char, int> &v)
    {
        for (auto x : v)
        {
            cout << x.first << " " << x.second << endl;
        }
        cout << endl;
    }
};
int main()
{
    int i, x;
    map<char, int> mp;
    Map_Demo obj;
    cout << "Enter 3 values and key pairs:" << endl;
    for (int i = 0; i < 3; i++)
    {
        char a;
        int j;
        cin >> a;
        cin >> j;
        mp[a] = j;
    }
    cout << "Elements of map are :" << endl;
    obj.display(mp);
    mp.insert(pair<char, int>('x', 1));
    mp.insert(pair<char, int>('y', 2));

    cout << "Elements of map after insertion are :" << endl;
    obj.display(mp);
    return 0;
}