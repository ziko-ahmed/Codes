## Question : https://codeforces.com/contest/2126/problem/B

import sys
import threading
def main():
    import sys
    input = sys.stdin.readline

    t = int(input())
    for _ in range(t):
        n, k = map(int, input().split())
        a = list(map(int, input().split()))
        pre = [0] * (n+1)
        for i in range(n):
            pre[i+1] = pre[i] + a[i]
        ans = 0
        i = 0
        while i <= n - k:
            if pre[i+k] - pre[i] == 0:
                ans += 1
                i += k + 1
            else:
                i += 1
        print(ans)

if __name__ == "__main__":
    main()