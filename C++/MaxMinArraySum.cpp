#include <bits/stdc++.h>
using namespace std;
void miniMaxSum(vector<int> arr)
{
    int sum, i, j, n = arr.size();
    vector<int> sum_arr(n);
    int min = *min_element(arr.begin(), arr.end());
    int max = *max_element(arr.begin(), arr.end());
    int minSum = 0, maxSum = 0;
    for (i = 0; i < n; i++)
    {

        if (arr[i] != min)
            maxSum += arr[i];
        if (arr[i] != max)
            minSum += arr[i];
    }

    cout << minSum << " " << maxSum;
}

int main(int argc, char const *argv[])
{
    vector<int> v = {1, 2, 3, 4, 5};

    miniMaxSum(v);
    return 0;
}
