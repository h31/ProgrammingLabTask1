package ru.spbstu.kspt.task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private PhoneBook phoneBook = new PhoneBook();

    @Test
    void addPerson() {
        phoneBook.addPerson("Tony", Arrays.asList("+79215466775", "89214855645"));
        phoneBook.addPerson("Daniel", Arrays.asList("895464664543", "8563956375"));
        phoneBook.addPerson("Tonya", Arrays.asList(new String[]{}));

        ArrayList<String> phoneList = new ArrayList<>();
        phoneList.add("+79215466775");
        phoneList.add("89214855645");

        assertEquals(phoneList, phoneBook.book.get("Tony")); 
        assertTrue(phoneBook.book.containsKey("Daniel"));
        assertTrue(phoneBook.book.get("Tonya").isEmpty());
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.addPerson("Antony", Arrays.asList("!77777777777", "beep")));
    }

    @Test
    void delPerson() {
        phoneBook.addPerson("Daniel", Arrays.asList("895464664543", "8563956375"));
        phoneBook.addPerson("Tony", Arrays.asList("+79215466775", "89214855645"));
        phoneBook.addPerson("Kate", Arrays.asList("+79215466775", "89214855645"));

        phoneBook.delPerson("Daniel");
        phoneBook.delPerson("Kate");
        assertTrue(phoneBook.book.containsKey("Tony"));
        assertFalse(phoneBook.book.containsKey("Kate"));
        assertTrue(!phoneBook.book.containsKey("Daniel"));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.delPerson("Antony"));
    }

    @Test
    void addNumber() {
        phoneBook.addPerson("Daniel", Arrays.asList("895464664543", "8563956375"));
        phoneBook.addPerson("Tony", Arrays.asList("+79215466775", "89214855645"));
        phoneBook.addPerson("Tonya", Arrays.asList(new String[]{}));

        phoneBook.addNumber("Daniel", "+79215944756");
        phoneBook.addNumber("Tony", "#8-999-5463275");
        phoneBook.addNumber("Tonya", "*89215649364");
        assertEquals(3, phoneBook.book.get("Daniel").size());
        assertTrue(phoneBook.book.get("Daniel").contains("+79215944756"));
        assertEquals("#8-999-5463275", phoneBook.book.get("Tony").get(2));
        assertTrue(phoneBook.book.get("Tonya").contains("*89215649364"));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.addNumber("Antony", ""));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.addNumber("Tony", "beep"));
    }

    @Test
    void delNumber() {
        phoneBook.addPerson("Daniel", Arrays.asList("895464664543", "8563956375", "+86584527364"));
        phoneBook.addPerson("Tony", Arrays.asList("+79215466775", "89214855645"));

        phoneBook.delNumber("Tony", "89214855645");
        phoneBook.delNumber("Daniel", "8563956375");

        ArrayList<String> phoneList = new ArrayList<>();
        phoneList.add("+79215466775");

        assertEquals(phoneList, phoneBook.book.get("Tony"));
        assertEquals(2, phoneBook.book.get("Daniel").size());
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.delNumber("", ""));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.delNumber("Antony", ""));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.delNumber("Tony", "+77777777777"));
    }

    @Test
    void searchByPerson() {
        phoneBook.addPerson("Daniel", Arrays.asList("895464664543", "8563956375", "+86584527364"));
        phoneBook.addPerson("Tony", Arrays.asList("+79215466775", "89214855645"));

        assertEquals(phoneBook.book.get("Daniel"), phoneBook.searchByPerson("Daniel"));
        assertEquals(phoneBook.book.get("Tony"), phoneBook.searchByPerson("Tony"));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.searchByPerson("Antony"));
    }

    @Test
    void searchByNum() {
        phoneBook.addPerson("Daniel", Arrays.asList("895464664543", "8563956375", "+86584527364"));
        phoneBook.addPerson("Tony", Arrays.asList("+79215466775", "89214855645"));

        assertEquals("Tony", phoneBook.searchByNum("89214855645"));
        assertEquals("Daniel", phoneBook.searchByNum("8563956375"));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.searchByNum("!77"));
        assertThrows(IllegalArgumentException.class, () ->
                phoneBook.searchByNum("+79216844658"));
    }
}
