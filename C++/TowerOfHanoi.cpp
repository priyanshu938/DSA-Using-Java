#include <bits/stdc++.h>
using namespace std;
void TOH(char source, char destination, char helper, int n)
{
    if (n == 0)
        return;
    TOH(source, helper, destination, n - 1);
    cout << "Move " << source << " to " << destination << endl;
    TOH(helper, destination, source, n - 1);
}

int main(int argc, char const *argv[])
{
    int n;
    cout << "Enter number of tiles : " << endl;
    cin >> n;
    if (n == 0)
    {
        cout << "No Tiles.";
    }
    else if (n == 1)
    {
        cout << "Move A to B." << endl;
    }
    else
    {
        TOH('A', 'C', 'B', n);
    }
    return 0;
}
