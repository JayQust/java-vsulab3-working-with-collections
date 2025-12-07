package com.example;

import java.util.List;

public class SimpleTester {

    /**
     * Тестируем добавление (add).
     * Возвращает время выполнения в наносекундах.
     */
    public long testAdd(List<Integer> list, int count) {
        long start = System.nanoTime();
        
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Тестируем получение элемента (get).
     * Читаем элементы из середины (или по порядку).
     */
    public long testGet(List<Integer> list, int count) {
        // Сначала заполним список, если он пуст, иначе нечего читать
        if (list.isEmpty()) {
            for (int i = 0; i < count; i++) list.add(i);
        }

        long start = System.nanoTime();
        
        for (int i = 0; i < count; i++) {
            list.get(i % list.size()); // Читаем элементы по кругу
        }
        
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Тестируем удаление (remove).
     * Будем удалять всегда первый элемент (индекс 0), это самая показательная операция.
     */
    public long testRemove(List<Integer> list, int count) {
        // Заполним список, чтобы было что удалять
        list.clear();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }

        long start = System.nanoTime();
        
        for (int i = 0; i < count; i++) {
            // Удаляем всегда 0-й элемент (сдвиг массива в ArrayList vs смена ссылок в LinkedList)
            list.remove(0); 
        }
        
        long end = System.nanoTime();
        return end - start;
    }
}