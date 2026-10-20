package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Задача 1 ===");
        Task1.solve(new String[]{
                "5",
                "1 2 3 4 5"
        });
        System.out.println();

        System.out.println("=== Задача 2 ===");
        Task2.solve(new String[]{
                "5 6",
                "1 1 2",
                "2 1 2",
                "1 3 4",
                "2 2 3",
                "1 2 3",
                "2 1 4"
        });
        System.out.println();

        System.out.println("=== Задача 3 ===");
        Task3.solve(new String[]{
                "5 5",
                "1 2",
                "1 3",
                "2 4",
                "3 4",
                "4 5"
        });
        System.out.println();

        System.out.println("=== Задача 4 ===");
        Task4.solve(new String[]{
                "7 3",
                "1 2 3 4 5 6 7"
        });
        System.out.println();

        System.out.println("=== Задача 5 ===");
        Task5.solve(new String[]{
                "4 5",
                "1 2 0",
                "1 3 1",
                "2 3 0",
                "1 4 1",
                "2 4 1"
        });
        System.out.println();

        System.out.println("=== Задача 6 ===");
        Task6.solve(new String[]{
                "3 3",
                "ba",
                "aa",
                "ab"
        });
    }
}