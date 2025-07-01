## Question : https://codeforces.com/contest/2123/problem/F

import math

def build_spf(n):
    spf = list(range(n + 1))
    for i in range(2, int(math.isqrt(n)) + 1):
        if spf[i] == i:
            for j in range(i * i, n + 1, i):
                if spf[j] == j:
                    spf[j] = i
    return spf

max_n = 100000
spf_global = build_spf(max_n)

t = int(input().strip())
out_lines = []

for _ in range(t):
    n = int(input().strip())
    fixed_points = set()
    fixed_points.add(1)
    low = (n // 2) + 1
    for num in range(low, n + 1):
        if num < 2:
            continue
        if spf_global[num] == num:
            fixed_points.add(num)
    
    res = [0] * (n + 1)
    visited = [False] * (n + 1)
    for pos in fixed_points:
        res[pos] = pos
        visited[pos] = True
    
    primes = []
    for p in range(2, (n // 2) + 1):
        if spf_global[p] == p:
            primes.append(p)
    primes.sort(reverse=True)
    
    for p in primes:
        multiples = []
        x = p
        while x <= n:
            if not visited[x]:
                multiples.append(x)
            x += p
        if len(multiples) < 2:
            continue
        for x in multiples:
            visited[x] = True
        k = len(multiples)
        for idx in range(k):
            next_index = (idx + 1) % k
            res[multiples[idx]] = multiples[next_index]
    
    for i in range(1, n + 1):
        if res[i] == 0:
            res[i] = i
    
    line = ' '.join(str(res[i]) for i in range(1, n + 1))
    out_lines.append(line)

for line in out_lines:
    print(line)