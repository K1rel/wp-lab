package mk.ukim.mk.lab.web.controller;


import mk.ukim.mk.lab.model.Book;
import mk.ukim.mk.lab.service.AuthorService;
import mk.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;


    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;

    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        List<Book> books = bookService.listBooks();
        model.addAttribute("books",books);
        model.addAttribute("error",error);

        return "listBooks";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
       Book book =  bookService.findBookById(id);
       if(book == null){
           return "redirect:/books?error=404NotFound";
       }

          model.addAttribute("book",book);
          return "editBook";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam String isbn,@RequestParam String title,@RequestParam String genre,@RequestParam String year){
        Book book = bookService.findBookByIsbn(isbn);
        book.setTitle(title);
        book.setGenre(genre);
        book.setYear(Integer.parseInt(year));

        return "redirect:/books";
    }

}
