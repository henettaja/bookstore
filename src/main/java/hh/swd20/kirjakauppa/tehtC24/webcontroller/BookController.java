package hh.swd20.kirjakauppa.tehtC24.webcontroller;

import hh.swd20.kirjakauppa.tehtC24.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @RequestMapping("/index")
    public String bookstore (Model model) {

        List <Book> bookList = new ArrayList<>();

        bookList.add(new Book("Kirja 1", "Kirjailija 1", "2020", "123456789", 16.95));
        bookList.add(new Book("Kirja 2", "Kirjailija 2", "2021", "123456789", 17.95));
        bookList.add(new Book("Kirja 3", "Kirjailija 3", "2022", "123456789", 18.95));
        bookList.add(new Book("Kirja 4", "Kirjailija 4", "2023", "123456789", 19.95));

        model.addAttribute("bookList", bookList);

        return "bookstore"; //bookstore.html

    }

}
