## Question : https://codeforces.com/contest/2123/problem/C

import sys

def solve():
    input = sys.stdin.read().split()
    ptr = 0
    t = int(input[ptr])
    ptr += 1
    out_lines = []
    for _ in range(t):
        n = int(input[ptr])
        ptr += 1
        a = list(map(int, input[ptr:ptr + n]))
        ptr += n
        prefix_min = [0] * n
        suffix_max = [0] * n
        prefix_min[0] = a[0]
        for i in range(1, n):
            prefix_min[i] = min(prefix_min[i-1], a[i])
        
        suffix_max[n-1] = a[n-1]
        for i in range(n-2, -1, -1):
            suffix_max[i] = max(suffix_max[i+1], a[i])
        
        res = []
        for i in range(n):
            if a[i] == prefix_min[i] or a[i] == suffix_max[i]:
                res.append('1')
            else:
                res.append('0')
        out_lines.append(''.join(res))
    
    print('\n'.join(out_lines))

solve()