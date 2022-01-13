#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[])
{

    int n, i, mx = -19999;
    cout << "Enter size of array :" << endl;
    cin >> n;
    int A[n];
    cout << "Enter array elements :" << endl;
    for (i = 0; i < n; i++)
    {
        cin >> A[i];
    }

    for (i = 0; i < n; i++)
    {
        mx = max(mx, A[i]);
        cout << "Max till " << i + 1 << " is : " << mx << endl;
    }
    return 0;
}
