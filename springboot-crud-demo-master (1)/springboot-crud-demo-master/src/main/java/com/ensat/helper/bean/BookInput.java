package com.ensat.helper.bean;

import java.util.Date;
import java.util.List;

/**
 * @author sandesha 8/8/18 5:48 PM
 **/
public class BookInput {

    private Integer version;

    private String isbn;
    private String bookName;
    private String releaseDate;
    private List<String> author;




    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }
}
