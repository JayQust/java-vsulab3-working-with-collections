package com.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    
    // Разные уровни нагрузки для тестирования
    private static final int[] N_LEVELS = {500, 20_000, 200_000}; 

    public static void main(String[] args) {
        SimpleTester tester = new SimpleTester();

        System.out.println("Сравнение производительности ArrayList и LinkedList при разной нагрузке");
        
        // Заголовок таблицы
        String headerFormat = "| %-12s | %-12s | %-12s | %-15s | %-15s | %-15s |%n";
        String separator = "+--------------+--------------+--------------+-----------------+-----------------+-----------------+%n";

        System.out.println(separator);
        System.out.printf(headerFormat, 
                "Метод", "Коллекция", "Сложность", 
                "Малый (500 мс)", "Средний (20K мс)", "Большой (200K мс)");
        System.out.println(separator);

        // --- Запуск всех тестов ---
        runComparison(tester, "add(E) (End)", "O(1) amort.", (t, n) -> t.testAdd(new ArrayList<>(), n), (t, n) -> t.testAdd(new LinkedList<>(), n));
        runComparison(tester, "add(index) (Mid)", "O(N) vs O(1)", (t, n) -> t.testInsertMiddle(new ArrayList<>(), n), (t, n) -> t.testInsertMiddle(new LinkedList<>(), n));
        runComparison(tester, "get(index)", "O(1) vs O(N)", (t, n) -> t.testGet(new ArrayList<>(), n), (t, n) -> t.testGet(new LinkedList<>(), n));
        runComparison(tester, "contains(E)", "O(N) vs O(N)", (t, n) -> t.testContains(new ArrayList<>(), n), (t, n) -> t.testContains(new LinkedList<>(), n));
        runComparison(tester, "remove(0)", "O(N) vs O(1)", (t, n) -> t.testRemove(new ArrayList<>(), n), (t, n) -> t.testRemove(new LinkedList<>(), n));

        System.out.println(separator);

        System.out.println("\n**Сложности:**");
        System.out.println("O(1) - Постоянное время. O(N) - Линейное время (зависит от размера N).");
        System.out.println("O(1) amort. - В среднем O(1), но иногда O(N) при расширении массива.");
    }

    // Интерфейс для удобной передачи метода
    @FunctionalInterface
    private interface PerformanceAction {
        long execute(SimpleTester tester, int count);
    }
    
    // Вспомогательный метод для выполнения сравнения
    private static void runComparison(SimpleTester tester, String methodName, String complexity,
                                      PerformanceAction arrayListTest, PerformanceAction linkedListTest) {

        long[] arrTimes = new long[N_LEVELS.length];
        long[] linkTimes = new long[N_LEVELS.length];

        // Выполнение тестов для разных уровней N
        for (int i = 0; i < N_LEVELS.length; i++) {
            int n = N_LEVELS[i];
            arrTimes[i] = arrayListTest.execute(tester, n);
            linkTimes[i] = linkedListTest.execute(tester, n);
        }

        // Вывод результатов для ArrayList
        printRow(methodName, "ArrayList", complexity, arrTimes);
        // Вывод результатов для LinkedList
        printRow("", "LinkedList", "", linkTimes);
    }

    // Вывод строки таблицы
    private static void printRow(String method, String type, String complexity, long[] nanoTimes) {
        String rowFormat = "| %-12s | %-12s | %-12s | %-15.3f | %-15.3f | %-15.3f |%n";
        
        System.out.printf(rowFormat,
                method,
                type,
                complexity,
                nanoTimes[0] / 1_000_000.0, // Малый N
                nanoTimes[1] / 1_000_000.0, // Средний N
                nanoTimes[2] / 1_000_000.0  // Большой N
        );
    }
}