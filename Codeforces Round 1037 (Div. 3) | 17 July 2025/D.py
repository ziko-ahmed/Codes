## Question : https://codeforces.com/contest/2126/problem/D

import sys
import threading
import heapq

def solve():
    input = sys.stdin.readline
    t = int(input())
    for _ in range(t):
        n, k = map(int, input().split())
        casinos = [tuple(map(int, input().split())) for _ in range(n)]
        casinos.sort(key=lambda x: x[0])
        
        cur = k
        idx = 0
        heap = []
        
        while True:
            while idx < n and casinos[idx][0] <= cur:
                l, r, real = casinos[idx]
                heapq.heappush(heap, (-real, r))
                idx += 1
            next_best = None
            while heap:
                neg_real, r = heap[0]
                real = -neg_real
                if r < cur:
                    heapq.heappop(heap)
                elif real <= cur:
                    heap = []  
                    break
                else:
                    next_best = real
                    break
            
            if next_best is None:
                break
            cur = next_best
        
        print(cur)

if __name__ == "__main__":
    solve()