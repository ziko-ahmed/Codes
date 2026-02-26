## Question : https://codeforces.com/contest/2112/problem/E

import sys

def main():
    INF = 10**18
    M = 500000
    F = [INF] * (M + 1)
    G = [INF] * (M + 1)
    F[1] = 1
    G[1] = 0

    divisors_list = [[] for _ in range(M + 1)]
    for i in range(1, M + 1):
        j = i
        while j <= M:
            divisors_list[j].append(i)
            j += i

    for y in range(2, M + 1):
        for d in divisors_list[y]:
            if d < 3:
                continue
            if d - 2 < 1 or d - 2 > M:
                continue
            z = y // d
            if G[z] >= INF:
                continue
            candidate = F[d - 2] + G[z]
            if candidate < G[y]:
                G[y] = candidate
        if G[y] < INF:
            F[y] = 1 + G[y]

    t = int(sys.stdin.readline())
    out_lines = []
    for _ in range(t):
        m = int(sys.stdin.readline())
        if F[m] < INF:
            out_lines.append(str(F[m]))
        else:
            out_lines.append(str(-1))
    sys.stdout.write("\n".join(out_lines))

if __name__ == "__main__":
    main()