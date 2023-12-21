package mk.ukim.mk.lab.web.controller;


import mk.ukim.mk.lab.model.Book;
import mk.ukim.mk.lab.service.AuthorService;
import mk.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;


    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        List<Book> books = bookService.listBooks();
        model.addAttribute("books",books);
        model.addAttribute("error",error);

        return "listBooks";
    }

    @GetMapping("/edit-book/{id}")
    public String edit(@PathVariable Long id, Model model){
       Book book =  bookService.findBookById(id);
       if(book == null){
           return "redirect:/books?error=404NotFound";
       }

          model.addAttribute("book",book);
          return "addBook";
    }

}
