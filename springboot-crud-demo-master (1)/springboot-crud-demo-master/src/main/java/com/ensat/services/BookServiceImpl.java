package com.ensat.services;

import com.ensat.entities.Book;
import com.ensat.helper.bean.BookInput;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> listAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(Long id) {

        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;

    }


    @Override
    public Book saveBook(BookInput bookInput) throws Exception {
        if (bookInput == null || bookInput.getAuthor() == null || bookInput.getBookName() == null || bookInput.getIsbn() == null || bookInput.getReleaseDate() == null) {
            throw new Exception("Invalid input");
        }
        Book book = new Book();
        book.setId(System.currentTimeMillis());
        book.setAuthor(bookInput.getAuthor());
        book.setIsbn(bookInput.getIsbn());
        book.setReleaseDate(new SimpleDateFormat("mm/dd/yyyy").parse(bookInput.getReleaseDate()));
        book.setBookName(bookInput.getBookName());
        books.add(book);
        return book;
    }

    public void deleteBook(Long id) {

        for (Book book : books) {
            if (book.getId().equals(id)) books.remove(book);
        }

    }

    public Book findByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> findByAuthorName(String authorName) {
        List<Book> output = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().contains(authorName)) {
                output.add(book);
            }
        }
        return output;
    }

    @Override
    public List<Book> findBooksReleasedBetween(String startDate, String endDate) {
        try {
            Date startDateDate = new SimpleDateFormat("mm/dd/yyyy").parse(startDate);
            Date endDateDate = new SimpleDateFormat("mm/dd/yyyy").parse(endDate);
            List<Book> output = new ArrayList<>();
            for (Book book : books) {
                if (book.getReleaseDate().after(startDateDate) && book.getReleaseDate().before(endDateDate)) {
                    output.add(book);
                }
            }
            return output;
        } catch (ParseException e) {
            System.out.println("Unable to parse date");
            return null;
        }

    }
}

