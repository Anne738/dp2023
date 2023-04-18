package com.mit.lab7.controller;


import com.mit.lab7.entity.Element;
import com.mit.lab7.repo.ElementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api/elements")
@Slf4j
public class ElementController {
    @Autowired
    ElementRepository elementRepository;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Element postElement(@RequestBody Element element){
        log.info("[ELEMENT CONTROLLER] | POST method");
        elementRepository.save(element);
        log.info("[ELEMENT CONTROLLER] after POST method: added {} element", element.getName());
        return element;
    }

    @GetMapping("/get")
    public List<Element> getAll(){
        List<Element> list;
        log.info("[ELEMENT CONTROLLER] | GET method");
        list = elementRepository.findAll();
        log.info("[ELEMENT CONTROLLER] after GET method: found {} elements", list.size());
        return list;
    }

    @PutMapping ("/update/{id}")
    public Element putElement(@PathVariable(name = "id") long id, @RequestBody Element newElement){
        log.info("[ELEMENT CONTROLLER] | PUT method");
        Element updateElement = elementRepository.findById(id)
                .orElseThrow(()->{
                    log.error("[ELEMENT CONTROLLER] | PUT method was failed: not found element with such id - {}", id);
                    return new ResourceAccessException("Not found element with such id: " + id);
                });
        updateElement.setImages(updateElement.getImages());
        updateElement.setPrice(updateElement.getPrice());
        updateElement.setName(updateElement.getName());
        elementRepository.save(updateElement);
        log.info("[ELEMENT CONTROLLER] after PUT method: element with {} id was changed", id);
        return updateElement;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteElement(@PathVariable(name = "id") long id){
        log.info("[ELEMENT CONTROLLER] | DELETE method");
        Element delete_element = elementRepository.findById(id).orElseThrow(()->{
                    log.error("[ELEMENT CONTROLLER] | DELETE method was failed: not found element with such id - {}", id);
                    return new ResourceAccessException("Not found element with such id: " + id);
                });
        elementRepository.deleteById(id);
        log.info("[ELEMENT CONTROLLER] after DELETE method: {} element with {} id was deleted", delete_element.getName(), id);
    }
}
