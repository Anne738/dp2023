package knu.fit.mit.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ElementService service;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Element> listElement = service.listAll();
        model.addAttribute("listElement",listElement);
        return "index";
    }
    @GetMapping("/new")
    public String AddElem(Model model){
        Element element = new Element();
        model.addAttribute("element", element);
        return "new_elem";
    }
    @PostMapping("/new")
    public String saveElem(@ModelAttribute("element") Element element) {
        service.save(element);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public ModelAndView UpdateForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_elem");
        Element element = service.get(id);
        mav.addObject("element", element);

        return mav;
    }

    @GetMapping("/delete/{id}")
    public String DeleteElem(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }
}
