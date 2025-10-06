// Question : https://codeforces.com/contest/2145/problem/A

#include <iostream>
using namespace std;

int main() {
    int t; 
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int r = n % 3;
        if (r == 0) cout << 0 << "\n";
        else cout << 3 - r << "\n";
    }
    return 0;
}