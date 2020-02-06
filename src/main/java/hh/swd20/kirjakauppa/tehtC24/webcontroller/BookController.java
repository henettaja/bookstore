package hh.swd20.kirjakauppa.tehtC24.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping("/index")
    public String bookstore () {

        return "bookstore"; //bookstore.html

    }

}
