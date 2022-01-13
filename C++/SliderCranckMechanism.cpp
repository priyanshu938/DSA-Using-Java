#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[])
{
    double L1, L2, angle, w, n, X, V, a;
    cout << "Enter L1 : ";
    cin >> L1;
    cout << "Enter L2 : ";
    cin >> L2;
    cout << "Enter angle : ";
    cin >> angle;
    cout << "Enter w : ";
    cin >> w;
    n = L2 / L1;
    X = L1 * ((1 - cos(angle*3.14/180) + (n - sqrt(n * n - (pow(sin(angle*3.14/180), 2))))));
    V = L1 * w * (sin(angle*3.14/180) + (sin(2 * angle*3.14/180) / (2 * n)));
    a = L1 * w * w * (cos(angle*3.14/180) + (cos(2 * angle*3.14/180) / (2 * n)));
    cout << "\nAngle\tL1\tL2\tw\tX\tV\ta\n"
         << angle << "\t" << L1 << "\t" << L2 << "\t" << w << "\t" << X << "\t" << V << "\t" << a << endl;

    return 0;
}
