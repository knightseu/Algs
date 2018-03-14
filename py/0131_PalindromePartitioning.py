def partition(s):
    res = []
    dfs(s, [], res)
    return res


def dfs(s, path, res):
    if not s:
        res.append(path)
        return
    for i in range(1, len(s) + 1):
        if isPal(s[:i]):
            dfs(s[i:], path + [s[:i]], res)


def isPal(s):
    return s == s[::-1]

import pdb; pdb.set_trace()
s = "abcbad"
rst = partition(s)
print rst