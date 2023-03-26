package knu.fit.mit.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementService {
    @Autowired
    private ElementRepository repo;

    public List<Element> listAll(){
        return repo.findAll();
    }

    public void save(Element element){
        repo.save(element);
    }

    public Element get(Long id){
        return repo.findById(id).get();
    }
    public void delete(Long id){
        repo.findById(id);
    }
}
