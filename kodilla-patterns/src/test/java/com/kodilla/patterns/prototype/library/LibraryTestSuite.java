package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("Biblioteka");
        IntStream.iterate(1, n -> n + 1)
            .limit(3)
            .forEach(n -> library.getBooks().add(new Book("Author "+n, "Title "+n, LocalDate.ofYearDay(2020, n))));

        Library shallowLibrary = null;
        Library deepLibrary = null;
        try {
            shallowLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        try {
             deepLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }


        //When
        library.getBooks().add(new Book("Brzechwa","Bajki",LocalDate.of(1970, 1, 2)));
        shallowLibrary.setName("Plytko");
        deepLibrary.setName("Gleboko");

        //Then
        System.out.println(library);
        System.out.println(shallowLibrary);
        System.out.println(deepLibrary);

        assertEquals(4,library.getBooks().size());
        assertEquals(4, shallowLibrary.getBooks().size());
        assertEquals(3, deepLibrary.getBooks().size());
        assertNotEquals(library.getName(),shallowLibrary.getName());
        assertNotEquals(library.getName(),deepLibrary.getName());
        assertEquals(library.getBooks(), shallowLibrary.getBooks());
        assertNotEquals(library.getBooks(),deepLibrary.getBooks());
    }
}