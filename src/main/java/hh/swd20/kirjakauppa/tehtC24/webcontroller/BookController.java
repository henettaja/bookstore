package hh.swd20.kirjakauppa.tehtC24.webcontroller;

import hh.swd20.kirjakauppa.tehtC24.domain.Book;
import hh.swd20.kirjakauppa.tehtC24.domain.BookRepository;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @RequestMapping("/index")
    public String bookstore () {

        return "bookstore"; //bookstore.html

    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String showBooks (Model model) {

        model.addAttribute("bookList", repository.findAll());

        return "booklist"; //booklist.html

    }

    @RequestMapping(value = "/addbook")
    public String addbook (Model model) {

        model.addAttribute("book", new Book());

        return "addbook"; //addbook.html
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savebook (Book book) {

        repository.save(book);

        return "redirect:booklist"; //booklist.html
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletebook (@PathVariable ("id") Long bookid, Model model) {

        repository.deleteById(bookid);

        return "redirect:../booklist"; //booklist.html
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editbook (@PathVariable ("id") Long bookid, Model model) {

        model.addAttribute("book", repository.findById(bookid));

        return "editbook"; //booklist.html
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updatebook (@PathVariable("id") Long id, Book book, Model model) {

        repository.save(book);

        return "redirect:../booklist";
    }

}
