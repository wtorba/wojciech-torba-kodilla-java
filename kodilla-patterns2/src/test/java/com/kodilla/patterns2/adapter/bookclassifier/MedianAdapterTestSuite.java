package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Auth1","Tit1",2010,"Tit1"));
        bookSet.add(new Book("Auth2", "Tit2", 2012, "Tit2"));
        bookSet.add(new Book("Auth1", "Tit3", 2015, "Tit3"));
        MedianAdapter medianAdapter = new MedianAdapter();
        // When
        int median = medianAdapter.publicationYearMedian(bookSet);
        // Then
        System.out.println(median);
        assertEquals(2012, median);
    }
}
