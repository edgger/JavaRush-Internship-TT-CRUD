package guru.optimal.crud.controller;

import guru.optimal.crud.entity.Book;
import guru.optimal.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String index(@RequestParam(value = "page", required = false) Integer page, Model model) {
        long totalCount = bookService.getBooksTotalCount();
        int pageSize = 10;
        int lastPageNumber = (int) (Math.ceil(totalCount / pageSize));
        model.addAttribute("lastPageNumber", lastPageNumber);

        if (page == null) {
            model.addAttribute("books", bookService.getBooksRange(0));
        } else {
            if (lastPageNumber < page) {
                model.addAttribute("books", bookService.getBooksRange((lastPageNumber-1)*10));
            } else {
                model.addAttribute("books", bookService.getBooksRange(page*10));
            }
        }
        return "index";
    }

    @GetMapping("/addBook")
    public String addBookPage() {
        return "editBook";
    }

    @GetMapping("/book/{id}")
    public String getBookById(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "editBook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.removeBook(id);
        return "redirect:/";
    }

    @GetMapping("/read/{id}")
    public String readBook(@PathVariable("id") int id) {
        Book bookById = bookService.getBookById(id);
        if (!bookById.isReadAlready()) {
            bookById.setReadAlready(true);
            bookService.updateBook(bookById);
        }
        return "redirect:/";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("bookData") Book book) {
        bookService.addBook(book);
        return "redirect:/";
    }

    @PostMapping("/editBook")
    public String editBook(@ModelAttribute("bookData") Book book) {
        bookService.updateBook(book);
        return "redirect:/";
    }

    @PostMapping("/searchBook")
    public String searchBook(@RequestParam(value = "field", required = false) String field, @RequestParam(value = "value", required = false) String value, Model model) {
        if (field==null){
            return "redirect:/";
        }
        try {
            List<Book> booksByField = bookService.getBooksByField(field, value);
            model.addAttribute("books", booksByField);
            return "index";
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return index(0,model);
        }
    }
}
