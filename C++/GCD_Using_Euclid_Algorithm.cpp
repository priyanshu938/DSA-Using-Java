#include <bits/stdc++.h>
using namespace std;
class GCD_Using_Euclid
{
public:
    int gcd(int a, int b)
    {
        if (a % b == 0)
        {
            return b;
        }
        else
        {
          return  gcd(b, a % b);
        }
    }
};
int main()
{
    int a, b;
    GCD_Using_Euclid obj;
    cout << "Enter two numbers :" << endl;
    cin >> a >> b;
    cout << "GCD of " << a << " and " << b << " is : " << obj.gcd(a, b) << endl;
    return 0;
}
