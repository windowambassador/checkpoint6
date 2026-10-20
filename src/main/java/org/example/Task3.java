package org.example;

import java.util.*;

public class Task3 {
    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        int[] indeg = new int[n + 1];

        for (int i = 0; i < m; i++) {
            String[] p = input[1 + i].trim().split("\\s+");
            int a = Integer.parseInt(p[0]);
            int b = Integer.parseInt(p[1]);
            graph.get(a).add(b);
            indeg[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) if (indeg[i] == 0) pq.add(i);

        int[] order = new int[n];
        int cnt = 0;
        while (!pq.isEmpty()) {
            int v = pq.poll();
            order[cnt++] = v;
            for (int to : graph.get(v)) {
                if (--indeg[to] == 0) pq.add(to);
            }
        }

        if (cnt < n) { System.out.println(-1); return; }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(order[i]);
        }
        System.out.println(sb);
    }
}