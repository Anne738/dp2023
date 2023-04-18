package com.mit.lab7.controller;


import com.mit.lab7.entity.Element;
import com.mit.lab7.repo.ElementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/elements")
@Slf4j
public class ElementController {
    @Autowired
    ElementRepository elementRepository;

    @GetMapping("/get")
    public List<Element> getAll(){
        List<Element> list;
        log.info("[ELEMENT CONTROLLER] | GET method");
        list = elementRepository.findAll();
        log.info("[ELEMENT CONTROLLER] after GET method: found {} watches", list.size());
        return list;
    }
}
