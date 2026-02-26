## Question : https://codeforces.com/contest/2126/problem/E

import sys
import math
def solve():
    input = sys.stdin.readline
    t = int(input())
    for _ in range(t):
        n = int(input())
        p = list(map(int, input().split()))
        s = list(map(int, input().split()))
        ok = True
        for i in range(n-1):
            if p[i] % p[i+1] != 0:
                ok = False
                break
        if ok:
            for i in range(n-1):
                if s[i+1] % s[i] != 0:
                    ok = False
                    break
        if not ok:
            print("No")
            continue
        a = [ (p[i] // math.gcd(p[i], s[i])) * s[i] for i in range(n) ]
        g = a[0]
        if g != p[0]:
            print("No")
            continue
        for i in range(1, n):
            g = math.gcd(g, a[i])
            if g != p[i]:
                ok = False
                break
        if not ok:
            print("No")
            continue
        g = a[-1]
        if g != s[-1]:
            print("No")
            continue
        for i in range(n-2, -1, -1):
            g = math.gcd(g, a[i])
            if g != s[i]:
                ok = False
                break

        print("Yes" if ok else "No")

if __name__ == "__main__":
    solve()