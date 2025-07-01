## Question : https://codeforces.com/contest/2123/problem/B

import sys

def solve():
    data = sys.stdin.read().split()
    t = int(data[0])
    idx = 1
    out_lines = []
    for _ in range(t):
        n = int(data[idx]); idx += 1
        j = int(data[idx]); idx += 1
        k = int(data[idx]); idx += 1
        a = list(map(int, data[idx:idx+n]))
        idx += n
        if k > 1:
            out_lines.append("YES")
        else:
            aj = a[j-1]
            if any(x > aj for x in a):
                out_lines.append("NO")
            else:
                out_lines.append("YES")
    sys.stdout.write("\n".join(out_lines))

if __name__ == "__main__":
    solve()