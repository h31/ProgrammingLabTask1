package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private PhoneBook phoneBook = new PhoneBook();

    @Test
    void addPerson() {
        phoneBook.addPerson("Tony", new String[]{"+79215466775", "89214855645"});
        phoneBook.addPerson("Daniel", new String[]{"895464664543", "8563956375"});
        phoneBook.addPerson("Tonya", new String[]{});

        ArrayList<String> phoneList = new ArrayList<>();
        phoneList.add("+79215466775");
        phoneList.add("89214855645");

        assertEquals(phoneList, phoneBook.book.get("Tony"));
        assertTrue(phoneBook.book.containsKey("Daniel"));
        assertTrue(phoneBook.book.get("Tonya").isEmpty());
    }

    @Test
    void delPerson() {
        phoneBook.addPerson("Daniel", new String[]{"895464664543", "8563956375"});
        phoneBook.addPerson("Tony", new String[]{"+79215466775", "89214855645"});
        phoneBook.addPerson("Kate", new String[]{"+79215466775", "89214855645"});

        phoneBook.delPerson("Daniel");
        phoneBook.delPerson("Kate");
        assertTrue(phoneBook.book.containsKey("Tony"));
        assertFalse(phoneBook.book.containsKey("Kate"));
        assertTrue(!phoneBook.book.containsKey("Daniel"));
    }

    @Test
    void addNumber() {
        phoneBook.addPerson("Daniel", new String[]{"895464664543", "8563956375"});
        phoneBook.addPerson("Tony", new String[]{"+79215466775", "89214855645"});
        phoneBook.addPerson("Tonya", new String[]{});

        phoneBook.addNumber("Daniel", "+79215944756");
        phoneBook.addNumber("Tony", "#8-999-5463275");
        phoneBook.addNumber("Tonya", "*89215649364");
        assertEquals(3, phoneBook.book.get("Daniel").size());
        assertTrue(phoneBook.book.get("Daniel").contains("+79215944756"));
        assertEquals("#8-999-5463275", phoneBook.book.get("Tony").get(2));
    }

    @Test
    void delNumber() {
        phoneBook.addPerson("Daniel", new String[]{"895464664543", "8563956375", "+86584527364"});
        phoneBook.addPerson("Tony", new String[]{"+79215466775", "89214855645"});

        phoneBook.delNumber("Tony", "89214855645");
        phoneBook.delNumber("Daniel", "8563956375");

        ArrayList<String> phoneList = new ArrayList<>();
        phoneList.add("+79215466775");

        assertEquals(phoneList, phoneBook.book.get("Tony"));
        assertEquals(2, phoneBook.book.get("Daniel").size());
    }

    @Test
    void searchByPerson() {
        phoneBook.addPerson("Daniel", new String[]{"895464664543", "8563956375", "+86584527364"});
        phoneBook.addPerson("Tony", new String[]{"+79215466775", "89214855645"});

        assertEquals(phoneBook.book.get("Daniel"), phoneBook.searchByPerson("Daniel"));
        assertEquals(phoneBook.book.get("Tony"), phoneBook.searchByPerson("Tony"));
    }

    @Test
    void searchByNum() {
        phoneBook.addPerson("Daniel", new String[]{"895464664543", "8563956375", "+86584527364"});
        phoneBook.addPerson("Tony", new String[]{"+79215466775", "89214855645"});

        assertEquals("Tony", phoneBook.searchByNum("89214855645"));
        assertEquals("Daniel", phoneBook.searchByNum("8563956375"));
    }
}
