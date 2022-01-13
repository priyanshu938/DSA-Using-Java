#include <bits/stdc++.h>;
using namespace std;
int main(int argc, char const *argv[])
{

    int n, e, i, j;
    cout << "Enter number of nodes and edges in the graph :" << endl;
    cin >> n >> e;
    vector<vector<int>> Adj(n + 1, vector<int>(n + 1, 0));
    cout << "Enter edges in pair :" << endl;
    for (i = 0; i < e; i++)
    {
        int x, y;
        cin >> x >> y;
        Adj[x][y] = 1;
        Adj[y][x] = 1;
    }
    cout << "Graph Adjacency Matrix :" << endl;
    for (i = 1; i < n; i++)
    {
        for (j = 1; j < n; j++)
            cout << Adj[i][j] << " ";
        cout << endl;
    }
    return 0;
}
