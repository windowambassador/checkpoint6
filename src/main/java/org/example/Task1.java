package org.example;

public class Task1 {
    static class Node {
        long val;
        Node next;
        Node(long v) { val = v; }
    }

    public static void solve(String[] input) {
        int n = Integer.parseInt(input[0].trim());
        String[] parts = input[1].trim().split("\\s+");

        // строим список
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(Long.parseLong(parts[i]));
            if (head == null) { head = node; tail = node; }
            else { tail.next = node; tail = node; }
        }

        // разворот: три ссылки prev/cur/next
        Node prev = null, cur = head;
        while (cur != null) {
            Node nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        head = prev;

        StringBuilder sb = new StringBuilder();
        for (Node p = head; p != null; p = p.next) {
            if (sb.length() > 0) sb.append(' ');
            sb.append(p.val);
        }
        System.out.println(sb);
    }
}