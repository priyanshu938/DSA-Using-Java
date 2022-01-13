#include <bits/stdc++.h>
using namespace std;
class NthFibonacci
{
public:
    int fibonacci(int n)
    {
        if (n == 1 || n == 2)
            return n - 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
};
int main(int argc, char const *argv[])
{
    NthFibonacci obj;
    cout << "Enter N :" << endl;
    int n;
    cin >> n;
    cout << n << "th Fibonacci Number is : " << obj.fibonacci(n) << endl;
    return 0;
}
