#include <bits/stdc++.h>
using namespace std;
class Power
{
public:
    int power(int n, int pow)
    {
        if (pow == 0)
            return 1;
        return n * power(n, pow - 1);
    }
}

;
int main(int argc, char const *argv[])
{
    Power obj;
    int n, p;
    cout << "Enter a number and the power to raise by : " << endl;
    cin >> n >> p;
    cout << n << " to the power of " << p << " is : " << obj.power(n, p) << endl;
    return 0;
}
