package com.ensat.services;


import com.ensat.entities.Book;
import com.ensat.helper.bean.BookInput;

import java.util.List;

public interface BookService {

    List<Book> listAllBooks();
    /*List<Object> listAllBooksIsbn();*/

    Book getBookById(Long id);

    Book saveBook(BookInput bookInput) throws Exception;

    void deleteBook(Long id);

    Book findByIsbn(String isbn);

    List<Book> findByAuthorName(String authorName);

    List<Book> findBooksReleasedBetween(String startDate, String endDate);
}