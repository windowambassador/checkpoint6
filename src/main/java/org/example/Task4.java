package org.example;

public class Task4 {
    static class Node {
        long val;
        Node next;
        Node(long v) { val = v; }
    }

    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);
        String[] parts = input[1].trim().split("\\s+");

        Node dummy = new Node(0);
        Node tail = dummy;
        for (int i = 0; i < n; i++) {
            tail.next = new Node(Long.parseLong(parts[i]));
            tail = tail.next;
        }

        if (k > 1 && k <= n) {
            Node prevGroupEnd = dummy;
            Node cur = dummy.next;

            while (cur != null) {
                // проверим, есть ли k узлов
                Node check = cur;
                int cnt = 0;
                while (check != null && cnt < k) { check = check.next; cnt++; }
                if (cnt < k) break; // неполный блок — оставляем

                // разворачиваем k узлов: cur .. groupEnd
                Node prev = null, node = cur;
                Node groupStart = cur;
                for (int i = 0; i < k; i++) {
                    Node nxt = node.next;
                    node.next = prev;
                    prev = node;
                    node = nxt;
                }
                // prev — новая голова блока, groupStart — новый хвост
                prevGroupEnd.next = prev;
                groupStart.next = node;
                prevGroupEnd = groupStart;
                cur = node;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Node p = dummy.next; p != null; p = p.next) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(p.val);
        }
        System.out.println(sb);
    }
}