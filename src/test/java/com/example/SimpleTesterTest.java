package com.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SimpleTesterTest {

    SimpleTester tester = new SimpleTester();

    @Test
    void testAdd_ShouldIncreaseSize() {
        List<Integer> list = new ArrayList<>();
        long time = tester.testAdd(list, 1000);

        assertEquals(1000, list.size(), "Размер списка должен стать 1000");
        assertTrue(time >= 0, "Время не может быть отрицательным");
    }

    @Test
    void testGet_ShouldRunWithoutErrors() {
        List<Integer> list = new ArrayList<>();
        // Метод сам заполнит список, если он пуст
        long time = tester.testGet(list, 1000);
        
        assertTrue(time >= 0);
        assertFalse(list.isEmpty());
    }

    @Test
    void testRemove_ShouldClearList() {
        List<Integer> list = new ArrayList<>();
        // Метод сначала заполнит список 1000 элементами, потом удалит 1000 раз
        tester.testRemove(list, 1000);

        assertEquals(0, list.size(), "Список должен стать пустым после удаления всех элементов");
    }
}