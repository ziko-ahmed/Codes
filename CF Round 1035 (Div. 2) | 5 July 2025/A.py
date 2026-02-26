## Question : https://codeforces.com/contest/2119/problem/A

import sys
from collections import deque

def solve():
    t = int(sys.stdin.readline())
    for _ in range(t):
        a, b, x, y = map(int, sys.stdin.readline().split())
        
        if a == b:
            print(0)
            continue
        
        max_limit = max(a, b) + 2
        INF = float('inf')
        cost = [INF] * (max_limit + 2)
        cost[a] = 0
        q = deque()
        q.append(a)
        
        found = False
        while q:
            current = q.popleft()
            if current == b:
                found = True
                break
            # Operation 1: a + 1
            next_val = current + 1
            if next_val <= max_limit and cost[next_val] > cost[current] + x:
                cost[next_val] = cost[current] + x
                q.append(next_val)
            # Operation 2: a XOR 1
            next_val = current ^ 1
            if next_val <= max_limit and cost[next_val] > cost[current] + y:
                cost[next_val] = cost[current] + y
                q.append(next_val)
        
        if found:
            print(cost[b])
        else:
            print(-1)

solve()