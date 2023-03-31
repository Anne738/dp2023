package ua.fit.mit.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import ua.fit.mit.lab6.entity.Element;
import ua.fit.mit.lab6.repo.ElementRepository;

import java.util.List;

@RestController
@RequestMapping("lab6/api/element")
public class ElementController {

    @Autowired
    ElementRepository elementRepository;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Element postElement(@RequestBody Element element){
        return elementRepository.save(element);
    }

    @GetMapping("/get")
    public List<Element> getElement(){
        return elementRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Element putElement(@PathVariable long id, @RequestBody Element updateElem){
        Element updateElement = elementRepository.findById(id)
                .orElseThrow(()->new ResourceAccessException("Not found Watch with such id: " + id));
        updateElement.setImages(updateElem.getImages());
        updateElement.setPrice(updateElem.getPrice());
        updateElement.setName(updateElem.getName());
        return elementRepository.save(updateElement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable long id){
        elementRepository.deleteById(id);
    }
}
