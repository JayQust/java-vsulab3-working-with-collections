package com.example;

import java.util.List;

public class SimpleTester {

    /**
     * Тестируем добавление в конец (add).
     * @param list Список для тестирования.
     * @param count Количество операций.
     * @return Время выполнения в наносекундах.
     */
    public long testAdd(List<Integer> list, int count) {
        list.clear();
        long start = System.nanoTime();
        
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Тестируем вставку в середину списка (add(index, element)).
     * @param list Список для тестирования.
     * @param count Количество операций (должно быть четным).
     * @return Время выполнения в наносекундах.
     */
    public long testInsertMiddle(List<Integer> list, int count) {
        list.clear();
        // Заполним половину коллекции, чтобы была "середина" для вставки
        for (int i = 0; i < count / 2; i++) {
            list.add(i);
        }
        
        int middleIndex = list.size() / 2;
        int operations = count / 2; // Вставим оставшуюся половину элементов
        
        long start = System.nanoTime();
        
        for (int i = 0; i < operations; i++) {
            list.add(middleIndex, i); // Вставка всегда в середину
        }
        
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Тестируем получение элемента по индексу (get(index)).
     * @param list Список для тестирования.
     * @param count Количество операций.
     * @return Время выполнения в наносекундах.
     */
    public long testGet(List<Integer> list, int count) {
        list.clear();
        // Сначала заполним список до нужного размера
        for (int i = 0; i < count; i++) list.add(i);

        long start = System.nanoTime();
        
        for (int i = 0; i < count; i++) {
            list.get(i % list.size()); // Читаем элементы по кругу
        }
        
        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Тестируем поиск элемента по значению (contains(element)).
     * @param list Список для тестирования.
     * @param count Количество операций.
     * @return Время выполнения в наносекундах.
     */
    public long testContains(List<Integer> list, int count) {
        list.clear();
        // Сначала заполним список до нужного размера
        for (int i = 0; i < count; i++) list.add(i);

        long start = System.nanoTime();

        // Ищем элементы, которые точно есть в списке
        for (int i = 0; i < count; i++) {
            list.contains(i);
        }

        long end = System.nanoTime();
        return end - start;
    }

    /**
     * Тестируем удаление из начала (remove(0)).
     * @param list Список для тестирования.
     * @param count Количество операций.
     * @return Время выполнения в наносекундах.
     */
    public long testRemove(List<Integer> list, int count) {
        list.clear();
        // Заполним список, чтобы было что удалять
        for (int i = 0; i < count; i++) {
            list.add(i);
        }

        long start = System.nanoTime();
        
        for (int i = 0; i < count; i++) {
            // Удаляем всегда 0-й элемент
            list.remove(0); 
        }
        
        long end = System.nanoTime();
        return end - start;
    }
}