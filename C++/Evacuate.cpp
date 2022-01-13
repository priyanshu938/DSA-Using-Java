#include <bits/stdc++.h>
using namespace std;
int main()
{
    int T, Z, N, i, j, c, x, y;
    vector<int> A;
    cin >> T;
    for (i = 1; i <= T; i++)
    {
        c=0;y=0;
        cin >> N;
        cin >> Z;
        for (j = 1; j <= N; j++)
        {
            cin >> x;
            A.push_back(x);
        }

        while (Z > 0)
        {
            auto max = max_element(A.begin(), A.end());
            Z -= *max;
            int k = max - A.begin();
            A[k] = A[k] / 2;
            c++;
           if(A[k]==0)
           {
               y=1;
               cout<<"Evacuate";
               break;
           }
        }
        if (y == 0)
            cout << c<<endl;
            A.clear();
    }
    return 0;
}