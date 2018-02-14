package guru.optimal.crud.controller;

import guru.optimal.crud.entity.Book;
import guru.optimal.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("books", bookService.listBooks());
        return "index";
    }

    @GetMapping("/addBook")
    public String addBookPage(){
        return "editBook";
    }

    @GetMapping("/book/{id}")
    public String getBookById(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "editBook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.removeBook(id);
        return "redirect:/";
    }
    
    @GetMapping("/read/{id}")
    public String readBook(@PathVariable("id") int id){
        Book bookById = bookService.getBookById(id);
        if (!bookById.isReadAlready()){
            bookById.setReadAlready(true);
            bookService.updateBook(bookById);
        }
        return "redirect:/";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);
        return "redirect:/";
    }

    @PostMapping("/editBook")
    public String editBook(@ModelAttribute("book") Book book){
        bookService.updateBook(book);
        return "redirect:/";
    }
}
