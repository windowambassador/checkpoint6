package org.example;

import java.util.*;

public class Task6 {
    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);

        String[] words = new String[n];
        for (int i = 0; i < n; i++) words[i] = input[1 + i].trim();

        // граф из k символов 'a'..'a'+k-1
        List<Set<Integer>> graphSet = new ArrayList<>();
        for (int i = 0; i < k; i++) graphSet.add(new HashSet<>());
        boolean impossible = false;

        for (int i = 0; i + 1 < n; i++) {
            String a = words[i], b = words[i + 1];
            int len = Math.min(a.length(), b.length());
            int j = 0;
            while (j < len && a.charAt(j) == b.charAt(j)) j++;
            if (j == len) {
                // одно префикс другого
                if (a.length() > b.length()) { impossible = true; break; }
            } else {
                int ca = a.charAt(j) - 'a';
                int cb = b.charAt(j) - 'a';
                graphSet.get(ca).add(cb);
            }
        }

        if (impossible) { System.out.println("IMPOSSIBLE"); return; }

        // строим список смежности и входные степени
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++) graph.add(new ArrayList<>(graphSet.get(i)));
        int[] indeg = new int[k];
        for (int u = 0; u < k; u++) {
            for (int v : graph.get(u)) indeg[v]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) if (indeg[i] == 0) pq.add(i);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!pq.isEmpty()) {
            int c = pq.poll();
            sb.append((char) ('a' + c));
            cnt++;
            for (int to : graph.get(c)) {
                if (--indeg[to] == 0) pq.add(to);
            }
        }

        if (cnt < k) { System.out.println("IMPOSSIBLE"); return; }
        System.out.println(sb);
    }
}