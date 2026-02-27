## Question : https://codeforces.com/contest/2112/problem/C

import sys
input = sys.stdin.readline

def count_winning_triples(a):
    n = len(a)
    a.sort()
    M = a[-1]
    ans = 0
    for k in range(2, n):
        T = max(M - a[k], a[k])
        total_pairs = k * (k - 1) // 2

        cnt_le = 0
        i, j = 0, k - 1
        while i < j:
            if a[i] + a[j] <= T:
                cnt_le += (j - i)
                i += 1
            else:
                j -= 1

        ans += (total_pairs - cnt_le)

    return ans

def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        a = list(map(int, input().split()))
        print(count_winning_triples(a))

if __name__ == "__main__":
    main()