class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> r = new ArrayList<>();
        char[][] b = new char[n][n];
        for (char[] x : b) Arrays.fill(x, '.');
        f(0, n, b, r, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return r;
    }
    private void f(int c, int n, char[][] b, List<List<String>> r, boolean[] col, boolean[] d1, boolean[] d2) {
        if (c == n) {
            List<String> l = new ArrayList<>();
            for (char[] x : b) l.add(new String(x));
            r.add(l);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !d1[i - c + n] && !d2[i + c]) {
                col[i] = d1[i - c + n] = d2[i + c] = true;
                b[i][c] = 'Q';
                f(c + 1, n, b, r, col, d1, d2);
                b[i][c] = '.';
                col[i] = d1[i - c + n] = d2[i + c] = false;
            }
        }
    }
}