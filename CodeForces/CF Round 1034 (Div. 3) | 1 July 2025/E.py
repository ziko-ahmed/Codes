## Question : https://codeforces.com/contest/2123/problem/E

import sys

def main():
    data = sys.stdin.read().split()
    t = int(data[0])
    index = 1
    results = []
    for _ in range(t):
        n = int(data[index])
        index += 1
        a = list(map(int, data[index:index+n]))
        index += n
        
        freq = [0] * (n + 1)
        for x in a:
            if x <= n:
                freq[x] += 1
        
        m0 = 0
        while m0 <= n and freq[m0] > 0:
            m0 += 1
        
        diff = [0] * (n + 2)
        for m in range(0, m0 + 1):
            if m > n:
                continue
            L = freq[m]
            R = n - m
            if L <= R:
                diff[L] += 1
                if R + 1 < len(diff):
                    diff[R + 1] -= 1
        
        cur = 0
        ans_arr = []
        for k in range(0, n + 1):
            cur += diff[k]
            ans_arr.append(str(cur))
        
        results.append(" ".join(ans_arr))
    
    print("\n".join(results))

if __name__ == "__main__":
    main()