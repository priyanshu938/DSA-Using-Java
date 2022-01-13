#include <bits/stdc++.h>
using namespace std;
class Vector_Demo
{
public:
    void display(vector<int> &v)
    {
        for (auto x : v)
        {
            cout << x << " ";
        }
        cout << endl;
    }
};
int main()
{
    int i, x;
    vector<int> v;
    Vector_Demo obj;
    cout << "Enter five values:" << endl;
    for (i = 0; i < 5; i++)
    {
        cin >> x;
        v.push_back(x);
    }
    cout << "Current Elements are :" << endl;
    obj.display(v);
    v.push_back(6.6);
    cout<<"Size of the vector after inserting 6.6 is "<<v.size()<<endl;

    //Inserting elements
    auto itr=v.begin();
    itr+=3;
    v.insert(itr,9);
    cout<<"Vector after inserting 9 is "<<endl;
    obj.display(v);
    
    //Deleting elements
    v.erase(v.begin()+3,v.begin()+5);
    cout<<"Vector after deletion is "<<endl;
    obj.display(v);

    auto itr1=lower_bound(v.begin(),v.end(),4);
    cout<<"Lower bound 4 is "<<*itr1<<endl;
    
    auto itr2=upper_bound(v.begin(),v.end(),4);
    cout<<"Upper bound 4 is "<<*itr2<<endl;
    //Sorting
    cout<<"Vector after sorting in ascending order:"<<endl;
    sort(v.begin(),v.end());
    obj.display(v);

    cout<<"Vector after sorting in descending order:"<<endl;
    sort(v.begin(),v.end(),greater<int>());
    obj.display(v);
    return 0;
}