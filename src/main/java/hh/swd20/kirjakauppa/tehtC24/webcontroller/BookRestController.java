package hh.swd20.kirjakauppa.tehtC24.webcontroller;

import hh.swd20.kirjakauppa.tehtC24.domain.BookRepository;
import hh.swd20.kirjakauppa.tehtC24.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BookRestController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/allbooks")

}