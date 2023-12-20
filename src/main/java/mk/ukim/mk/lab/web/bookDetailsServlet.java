package mk.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.mk.lab.model.Book;
import mk.ukim.mk.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/bookDetails")
public class bookDetailsServlet extends HttpServlet {
     private final SpringTemplateEngine springTemplateEngine;
     private final BookService bookService;

    public bookDetailsServlet(SpringTemplateEngine springTemplateEngine, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext webContext =new WebContext(webExchange);
        Book knigata = bookService.findBookByIsbn(req.getParameter("Isbn"));
        webContext.setVariable("book",knigata);


        springTemplateEngine.process("bookDetails.html",webContext,resp.getWriter());
    }
}
