package mk.ukim.mk.lab.web.controller;


import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.model.Book;
import mk.ukim.mk.lab.service.AuthorService;
import mk.ukim.mk.lab.service.BookService;
import mk.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;
    private final AuthorService authorService;


    public BookController(BookService bookService, AuthorService authorService, BookStoreService bookStoreService, AuthorService authorService1) {
        this.bookService = bookService;

        this.bookStoreService = bookStoreService;
        this.authorService = authorService1;
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

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,Model model){
        bookService.listBooks().remove(bookService.findBookById(id));
        model.addAttribute("books",bookService.listBooks());

        return "redirect:/books";
    }

    @GetMapping("/add")
    public String save(@RequestParam(required = false) String error,Model model){

        model.addAttribute("bookStores",bookStoreService.findAll());
        model.addAttribute("book",new Book());

        return "addBook";
    }

    @PostMapping("/add")
    public String save(@RequestParam String isbn,@RequestParam String title,@RequestParam String genre,@RequestParam Integer year,@RequestParam Long bookStoreId,Model model){
        List<Author> avtori = new ArrayList<>();
        Random random = new Random();
        avtori.add(authorService.listAuthors().get(random.nextInt(authorService.listAuthors().size())));
        Book book = new Book(isbn,title,genre,year,avtori,bookStoreService.findAll().stream().filter(i->i.getId().equals(bookStoreId)).findFirst().orElse(null));
        bookService.listBooks().add(book);
        model.addAttribute("books",bookService.listBooks());

        return "listBooks";

    }

}
