## Question : https://codeforces.com/contest/2119/problem/C

import sys
import threading

def main():
    input = sys.stdin.readline
    t = int(input())
    out = []
    for _ in range(t):
        n, l, r, k = map(int, input().split())
        if n & 1:
            out.append(str(l))
            continue
        if n == 2:
            out.append("-1")
            continue
        tval = 1 << (l.bit_length())
        if tval > r:
            out.append("-1")
        else:
            if k <= n-2:
                out.append(str(l))
            else:
                out.append(str(tval))
    sys.stdout.write("\n".join(out))

if __name__ == "__main__":
    threading.Thread(target=main).start()