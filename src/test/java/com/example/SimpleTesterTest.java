package com.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Юнит-тесты для класса SimpleTester, проверяющие логику и замер времени.
 */
class SimpleTesterTest {

    SimpleTester tester = new SimpleTester();
    private final int TEST_COUNT = 1000;

    @Test
    void testAdd_ShouldIncreaseSizeAndReturnNonNegativeTime() {
        List<Integer> list = new ArrayList<>();
        long time = tester.testAdd(list, TEST_COUNT);

        assertEquals(TEST_COUNT, list.size(), "Размер списка должен стать " + TEST_COUNT);
        assertTrue(time >= 0, "Время не может быть отрицательным");
    }

    @Test
    void testGet_ShouldRunWithoutErrorsAndFillList() {
        List<Integer> list = new ArrayList<>();
        long time = tester.testGet(list, TEST_COUNT);
        
        assertEquals(TEST_COUNT, list.size(), "Список должен быть заполнен для теста get");
        assertTrue(time >= 0);
    }

    @Test
    void testRemove_ShouldClearList() {
        List<Integer> list = new ArrayList<>();
        // Метод сначала заполнит список, потом удалит все элементы
        tester.testRemove(list, TEST_COUNT);

        assertEquals(0, list.size(), "Список должен стать пустым после удаления всех элементов");
    }

    @Test
    void testInsertMiddle_ShouldMaintainCorrectSizeAndReturnNonNegativeTime() {
        List<Integer> arrayList = new ArrayList<>();
        int halfCount = TEST_COUNT / 2;
        
        // Тест выполняет вставку половину раз, после предварительного заполнения половины
        long time = tester.testInsertMiddle(arrayList, TEST_COUNT);

        // Изначально было N/2, вставили N/2, итого N
        assertEquals(TEST_COUNT, arrayList.size(), "Размер ArrayList должен быть равен TEST_COUNT");
        assertTrue(time >= 0, "Время не может быть отрицательным");
        
        // Проверим LinkedList, чтобы убедиться, что логика одинакова
        List<Integer> linkedList = new LinkedList<>();
        tester.testInsertMiddle(linkedList, TEST_COUNT);
        assertEquals(TEST_COUNT, linkedList.size(), "Размер LinkedList должен быть равен TEST_COUNT");
    }

    @Test
    void testContains_ShouldCheckElementsAndReturnNonNegativeTime() {
        List<Integer> arrayList = new ArrayList<>();
        
        // Запускаем тест. Метод заполняет список сам.
        long time = tester.testContains(arrayList, TEST_COUNT);

        // Проверим, что список заполнен
        assertEquals(TEST_COUNT, arrayList.size());
        
        // Дополнительная проверка, чтобы убедиться, что метод не сломался
        assertTrue(arrayList.contains(0), "Список должен содержать элемент 0");
        assertTrue(arrayList.contains(TEST_COUNT - 1), "Список должен содержать последний элемент");
        assertTrue(time >= 0, "Время не может быть отрицательным");
    }
}