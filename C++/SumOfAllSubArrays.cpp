#include <bits/stdc++.h>
using namespace std;
#define f()
vector<int> A;
int main(int argc, char const *argv[])
{
    int i, j, k, sum, n, x;
    cout << "Enter size of array :" << endl;
    cin >> n;
    cout << "Enter array elements :" << endl;
    for (i = 0; i < n; i++)
    {
        cin >> x;
        A.push_back(x);
    }
    for (i = 0; i < n; i++)
    {
        sum = 0;
        for (j = i; j < n; j++)
        {
            sum += A[j];
            cout << sum << " ";
        }
    }
    return 0;
}
