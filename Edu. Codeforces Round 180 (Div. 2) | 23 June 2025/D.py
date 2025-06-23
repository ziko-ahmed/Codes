## Question : https://codeforces.com/contest/2112/problem/D

import sys
from collections import deque

def main():
    data = sys.stdin.read().split()
    t = int(data[0])
    index = 1
    output_lines = []
    for _ in range(t):
        n = int(data[index])
        index += 1
        graph = [[] for _ in range(n+1)]
        deg = [0] * (n+1)
        for _ in range(n-1):
            u = int(data[index])
            v = int(data[index+1])
            index += 2
            graph[u].append(v)
            graph[v].append(u)
            deg[u] += 1
            deg[v] += 1
        
        special = -1
        for i in range(1, n+1):
            if deg[i] == 2:
                special = i
                break
        
        if special == -1:
            output_lines.append("NO")
            continue
        
        neighbors = graph[special]
        a = neighbors[0]
        b = neighbors[1]
        
        state = [0] * (n+1)
        state[a] = 1
        state[b] = 2
        
        visited = [False] * (n+1)
        visited[special] = True
        visited[a] = True
        visited[b] = True
        
        q = deque([a, b])
        directed_edges = []
        directed_edges.append((a, special))
        directed_edges.append((special, b))
        
        while q:
            u = q.popleft()
            for w in graph[u]:
                if visited[w]:
                    continue
                visited[w] = True
                if state[u] == 1:
                    directed_edges.append((u, w))
                    state[w] = 2
                else:
                    directed_edges.append((w, u))
                    state[w] = 1
                q.append(w)
        
        output_lines.append("YES")
        for edge in directed_edges:
            output_lines.append(f"{edge[0]} {edge[1]}")
    
    print("\n".join(output_lines))

if __name__ == "__main__":
    main()