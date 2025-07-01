## Question : https://codeforces.com/contest/2123/problem/A

import sys

def main():
    data = sys.stdin.read().split()
    t = int(data[0])
    ans = []
    idx = 1
    for _ in range(t):
        n = int(data[idx]); idx += 1
        if n % 4 == 0:
            ans.append("Bob")
        else:
            ans.append("Alice")
    print("\n".join(ans))

if __name__ == "__main__":
    main()