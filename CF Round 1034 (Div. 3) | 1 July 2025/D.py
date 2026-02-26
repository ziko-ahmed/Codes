## Question : https://codeforces.com/contest/2123/problem/D

import sys

def main():
    t = int(input().strip())
    for _ in range(t):
        n, k = map(int, input().split())
        s = input().strip()
        
        ones = s.count('1')
        
        if ones == 0:
            print("Alice")
        elif ones <= k:
            print("Alice")
        elif 2 * k > n:
            print("Alice")
        else:
            print("Bob")

if __name__ == "__main__":
    main()