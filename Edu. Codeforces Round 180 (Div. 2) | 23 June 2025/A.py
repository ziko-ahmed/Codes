## Question : https://codeforces.com/contest/2112/problem/A

def main():
    t = int(input())
    for _ in range(t):
        a, x, y = map(int, input().split())
        dx = abs(a - x)
        dy = abs(a - y)
        
        found = False
        for b in range(a - 100, a + 101):
            if b == a:
                continue
            if abs(b - x) < dx and abs(b - y) < dy:
                found = True
                break
        
        print("YES" if found else "NO")

if __name__ == "__main__":
    main()