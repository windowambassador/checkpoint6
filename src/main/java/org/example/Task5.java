package org.example;

public class Task5 {
    static int[] parent, rank;
    static int[] parity; // 0 или 1 — отличие от родителя (до сжатия)

    static int find(int x) {
        if (parent[x] != x) {
            int root = find(parent[x]);
            parity[x] ^= parity[parent[x]];
            parent[x] = root;
        }
        return parent[x];
    }

    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int q = Integer.parseInt(first[1]);

        parent = new int[n + 1];
        rank = new int[n + 1];
        parity = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        boolean broken = false;
        StringBuilder out = new StringBuilder();

        for (int i = 1; i <= q; i++) {
            String[] p = input[i].trim().split("\\s+");
            int u = Integer.parseInt(p[0]);
            int v = Integer.parseInt(p[1]);
            int r = Integer.parseInt(p[2]);

            if (broken) { out.append("NO\n"); continue; }

            int ru = find(u);
            int rv = find(v);
            if (ru == rv) {
                int pu = parity[u], pv = parity[v];
                boolean ok = ((pu ^ pv) == r);
                if (!ok) { broken = true; out.append("NO\n"); }
                else out.append("YES\n");
            } else {
                // объединяем
                int pu = parity[u], pv = parity[v];
                // хотим: pu ^ pv ^ (newParity) = r, т.е. между корнями разница = r ^ pu ^ pv
                int diff = pu ^ pv ^ r;
                if (rank[ru] < rank[rv]) {
                    parent[ru] = rv;
                    parity[ru] = diff;
                } else {
                    parent[rv] = ru;
                    parity[rv] = diff;
                    if (rank[ru] == rank[rv]) rank[ru]++;
                }
                out.append("YES\n");
            }
        }
        System.out.print(out);
    }
}