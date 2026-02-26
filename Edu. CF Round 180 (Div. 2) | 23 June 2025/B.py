#3 Question : https://codeforces.com/contest/2112/problem/B

import sys
def solve():
    input = sys.stdin.readline

    t = int(input())
    for _ in range(t):
        n = int(input())
        a = list(map(int, input().split()))
        for i in range(n-1):
            if abs(a[i] - a[i+1]) <= 1:
                print(0)
                break
        else:
            one_ok = False
            for k in range(n-1):
                lo, hi = min(a[k], a[k+1]), max(a[k], a[k+1])
                if k > 0:
                    L = a[k-1]
                    if not (hi < L-1 or lo > L+1):
                        one_ok = True
                        break
                if k+2 < n:
                    R = a[k+2]
                    if not (hi < R-1 or lo > R+1):
                        one_ok = True
                        break

            print(1 if one_ok else -1)

if __name__ == "__main__":
    solve()