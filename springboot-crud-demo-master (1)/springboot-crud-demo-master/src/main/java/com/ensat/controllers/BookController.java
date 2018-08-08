package com.ensat.controllers;

import com.ensat.entities.Book;
import com.ensat.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService BookService) {
        this.bookService = BookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("books", bookService.listAllBooks());
        System.out.println("Returning books:");
        return "books";
    }
    /*@RequestMapping(value = "/books", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("books", bookService.listAllBooks());
        System.out.println("Returning books:");
        return "books";
    }*/

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("book/{id}")
    public String showBook(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "bookshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("book/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "bookform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("book/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "bookform";
    }

    /**
     * Save product to database.
     *
     * @param book
     * @return
     */
    @RequestMapping(value = "book", method = RequestMethod.POST)
    public String saveProduct(Book book) {
        bookService.saveBook(book);
        return "redirect:/book/" + book.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("book/delete/{id}")
    public String delete(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    /*@RequestMapping(value = "/book/isbn/{id}", method = RequestMethod.GET)
    public String listIsbn(Model model) {
        model.addAttribute("books", bookService.listAllBooksIsbn());
        System.out.println("Returning books:");
        return "books";
    }*/

    /**
     * Search by ISBN.
     *
     * @return
     */
    @RequestMapping("book/isbn")
    public String searchByISBN(Model model) {
        model.addAttribute("book", new Book());
        System.out.println("Search by ISBN Ashwin");
        return "isbnSearch";
    }


    @RequestMapping("book/search/{isbn}")
    public String searchByIsbn(@PathVariable String isbn, Model model) {
        System.out.println("success Inside search isbn : " + isbn);
        model.addAttribute("book", bookService.findByIsbn(isbn));
        return "bookshow";
    }


}


