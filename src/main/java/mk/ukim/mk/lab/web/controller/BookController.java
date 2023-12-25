package mk.ukim.mk.lab.web.controller;


import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.model.Book;
import mk.ukim.mk.lab.model.Review;
import mk.ukim.mk.lab.repository.ReviewRepository;
import mk.ukim.mk.lab.service.AuthorService;
import mk.ukim.mk.lab.service.BookService;
import mk.ukim.mk.lab.service.BookStoreService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;
    private final AuthorService authorService;

    private final ReviewRepository reviewRepository;


    public BookController(BookService bookService, AuthorService authorService, BookStoreService bookStoreService, AuthorService authorService1, ReviewRepository reviewRepository) {
        this.bookService = bookService;

        this.bookStoreService = bookStoreService;
        this.authorService = authorService1;

        this.reviewRepository = reviewRepository;
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
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,Model model){
        bookService.deleteBook(bookService.findBookById(id));
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
        bookService.addBook(book);
        model.addAttribute("books",bookService.listBooks());

        return "listBooks";

    }

    @GetMapping("/review/{id}")
    public String review(@PathVariable Long id,Model model){
        Book kniga = bookService.findBookById(id);
        model.addAttribute("book",kniga);

        return "reviewBook";
    }

    @PostMapping("/review/{id}")
    public String review(@PathVariable Long id, @RequestParam int score, @RequestParam String description,
                         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime reviewDate,Model model){
        Book kniga = bookService.findBookById(id);
        Review review = new Review();
        review.setDescription(description);
        review.setScore(score);
        review.setTimestamp(reviewDate);
        review.setBook(kniga);
        kniga.getReviews().add(review);
        bookService.addBook(kniga);
        reviewRepository.save(review);
        bookService.listBooks().add(kniga);
        model.addAttribute("books",bookService.listBooks());
        return "listBooks";

    }




}
