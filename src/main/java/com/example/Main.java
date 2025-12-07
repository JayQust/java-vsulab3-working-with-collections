package com.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    
    // Количество операций
    private static final int N = 20000; 

    public static void main(String[] args) {
        SimpleTester tester = new SimpleTester();

        System.out.printf("Сравнение производительности (Количество операций: %d)%n", N);
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("| %-12s | %-10s | %-15s |%n", "Метод", "Коллекция", "Время (мс)");
        System.out.println("-----------------------------------------------------------------");

        // --- Тест ADD ---
        long timeAddArr = tester.testAdd(new ArrayList<>(), N);
        long timeAddLink = tester.testAdd(new LinkedList<>(), N);
        printRow("add", "ArrayList", timeAddArr);
        printRow("add", "LinkedList", timeAddLink);

        System.out.println("-----------------------------------------------------------------");

        // --- Тест GET ---
        long timeGetArr = tester.testGet(new ArrayList<>(), N);
        long timeGetLink = tester.testGet(new LinkedList<>(), N);
        printRow("get", "ArrayList", timeGetArr);
        printRow("get", "LinkedList", timeGetLink);

        System.out.println("-----------------------------------------------------------------");

        // --- Тест REMOVE (из начала) ---
        long timeRemArr = tester.testRemove(new ArrayList<>(), N);
        long timeRemLink = tester.testRemove(new LinkedList<>(), N);
        printRow("remove(0)", "ArrayList", timeRemArr);
        printRow("remove(0)", "LinkedList", timeRemLink);
        
        System.out.println("-----------------------------------------------------------------");
    }

    // Вспомогательный метод просто для красивого вывода строки
    private static void printRow(String method, String type, long nanoTime) {
        double ms = nanoTime / 1_000_000.0; // Перевод в миллисекунды
        System.out.printf("| %-12s | %-10s | %-15.3f |%n", method, type, ms);
    }
}