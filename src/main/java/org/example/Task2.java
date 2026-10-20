package org.example;

public class Task2 {
    static int[] parent, rank;

    static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // сжатие путей (path halving)
            x = parent[x];
        }
        return x;
    }

    static void union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return;
        if (rank[a] < rank[b]) { int t = a; a = b; b = t; }
        parent[b] = a;
        if (rank[a] == rank[b]) rank[a]++;
    }

    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int q = Integer.parseInt(first[1]);

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= q; i++) {
            String[] p = input[i].trim().split("\\s+");
            int type = Integer.parseInt(p[0]);
            int u = Integer.parseInt(p[1]);
            int v = Integer.parseInt(p[2]);
            if (type == 1) {
                union(u, v);
            } else {
                out.append(find(u) == find(v) ? "YES" : "NO").append('\n');
            }
        }
        System.out.print(out);
    }
}