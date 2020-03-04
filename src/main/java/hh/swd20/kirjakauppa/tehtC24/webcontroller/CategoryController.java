package hh.swd20.kirjakauppa.tehtC24.webcontroller;

import hh.swd20.kirjakauppa.tehtC24.domain.Book;
import hh.swd20.kirjakauppa.tehtC24.domain.BookRepository;
import hh.swd20.kirjakauppa.tehtC24.domain.Category;
import hh.swd20.kirjakauppa.tehtC24.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public String showCategories(Model model) {

        model.addAttribute("categoryList", categoryRepository.findAll());

        return "categorylist"; //categorylist.html

    }

    @RequestMapping(value = "/addcategory")
    public String addbook (Model model) {

        model.addAttribute("category", new Category());
        model.addAttribute("books", bookRepository.findAll());

        return "addcategory"; //addbook.html
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String savecategory (Category category) {

        categoryRepository.save(category);

        return "redirect:categorylist"; //booklist.html
    }

    @RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
    public String deletecategory (@PathVariable("id") Long categoryid) {

        categoryRepository.deleteById(categoryid);

        return "redirect:../categorylist"; //booklist.html
    }


}
