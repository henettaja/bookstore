package hh.swd20.kirjakauppa.tehtC24.webcontroller;

import hh.swd20.kirjakauppa.tehtC24.domain.Book;
import hh.swd20.kirjakauppa.tehtC24.domain.BookRepository;
import hh.swd20.kirjakauppa.tehtC24.domain.Category;
import hh.swd20.kirjakauppa.tehtC24.domain.CategoryRepository;
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
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/index")
    public String bookstore () {

        return "bookstore"; //bookstore.html

    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String showBooks (Model model) {

        model.addAttribute("bookList", bookRepository.findAll());

        return "booklist"; //booklist.html

    }

    @RequestMapping(value = "/addbook")
    public String addbook (Model model) {

        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());

        return "addbook"; //addbook.html
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savebook (Book book) {

        bookRepository.save(book);

        return "redirect:booklist"; //booklist.html
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletebook (@PathVariable ("id") Long bookid) {

        bookRepository.deleteById(bookid);

        return "redirect:../booklist"; //booklist.html
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editbook (@PathVariable ("id") Long bookid, Model model) {

        model.addAttribute("book", bookRepository.findById(bookid));
        model.addAttribute("categories", categoryRepository.findAll());

        return "editbook"; //booklist.html
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updatebook (@PathVariable("id") Long id, Book book, Model model) {

        bookRepository.save(book);

        return "redirect:../booklist";
    }

}
