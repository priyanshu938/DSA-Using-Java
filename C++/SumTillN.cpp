#include <bits/stdc++.h>
using namespace std;
class SumTillN
{
public:
    int sum(int n)
    {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }
};
int main(int argc, char const *argv[])
{
    SumTillN obj;
    int n;
    cout << "Enter N : " << endl;
    cin >> n;
    cout << "Sum till " << n << " is : " << obj.sum(n) << endl;
    return 0;
}
