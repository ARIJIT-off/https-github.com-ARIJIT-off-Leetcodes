class Solution:
    def findSubstring(self, s, w):
        if not s or not w:
            return []
        l, c, t = len(w[0]), len(w), len(w[0]) * len(w)
        if len(s) < t:
            return []
        
        m = {}
        for x in w:
            m[x] = m.get(x, 0) + 1
            
        r = []
        for i in range(l):
            u = {}
            st, cnt = i, 0
            for j in range(i, len(s) - l + 1, l):
                sub = s[j:j + l]
                if sub in m:
                    u[sub] = u.get(sub, 0) + 1
                    cnt += 1
                    while u[sub] > m[sub]:
                        lt = s[st:st + l]
                        u[lt] -= 1
                        cnt -= 1
                        st += l
                    if cnt == c:
                        r.append(st)
                        lt = s[st:st + l]
                        u[lt] -= 1
                        cnt -= 1
                        st += l
                else:
                    u.clear()
                    cnt = 0
                    st = j + l
        return r