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

        model.addAttribute("bookList", bookList);

        return "bookstore"; //bookstore.html

    }

}
