package mk.ukim.mk.lab.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.service.AuthorService;
import mk.ukim.mk.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/author")
public class AuthorServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
   private final AuthorService authorService;
   private final BookService bookService;

    public AuthorServlet(SpringTemplateEngine springTemplateEngine, AuthorService authorService, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorService = authorService;
        this.bookService = bookService;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
        WebContext webContext =new WebContext(webExchange);

        webContext.setVariable("Authors",authorService.listAuthors());
        webContext.setVariable("book",bookService.findBookByIsbn(req.getParameter("isbn")));

        springTemplateEngine.process("listAuthors.html",webContext,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookIsbn");
        long authorId = Long.parseLong(req.getParameter("authorId"));
        System.out.println("bookId: " + bookId);
        Author avtorott = bookService.addAuthorToBook(authorId,bookId);



        resp.sendRedirect("/bookDetails?Isbn=" + bookId);
    }
}
