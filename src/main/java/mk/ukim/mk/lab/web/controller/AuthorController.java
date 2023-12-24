package mk.ukim.mk.lab.web.controller;


import mk.ukim.mk.lab.service.AuthorService;
import mk.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;


    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

   @GetMapping
    public String addAuthor(@RequestParam String bookIsbn, Model model){
        model.addAttribute("Authors",authorService.listAuthors());
        model.addAttribute("book",bookService.findBookByIsbn(bookIsbn));

        return "listAuthors";
   }

   @PostMapping
    public String addAuthor(@RequestParam String bookIsbn,@RequestParam String authorId,Model model){

        bookService.findBookByIsbn(bookIsbn).getAuthors().add(authorService.findById(Long.valueOf(authorId)));

        bookService.addBook(bookService.findBookByIsbn(bookIsbn));
        model.addAttribute("book",bookService.findBookByIsbn(bookIsbn));

        return "bookDetails";

   }
}
