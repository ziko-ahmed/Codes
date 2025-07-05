## Question : https://codeforces.com/contest/2119/problem/B

import sys

def main():
    t = int(sys.stdin.readline().strip())
    for _ in range(t):
        n = int(sys.stdin.readline().strip())
        data = sys.stdin.readline().split()
        px = int(data[0])
        py = int(data[1])
        qx = int(data[2])
        qy = int(data[3])
        a_list = list(map(int, sys.stdin.readline().split()))
        total = sum(a_list)
        max_a = max(a_list) if n > 0 else 0
        
        dx = qx - px
        dy = qy - py
        D_sq = dx * dx + dy * dy
        
        if total * total < D_sq:
            print("NO")
        else:
            if total < 2 * max_a:
                X = 2 * max_a - total
                if D_sq < X * X:
                    print("NO")
                else:
                    print("YES")
            else:
                print("YES")

if __name__ == "__main__":
    main()