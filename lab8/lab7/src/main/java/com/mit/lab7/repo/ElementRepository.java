package com.mit.lab7.repo;

import com.mit.lab7.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "elements", path = "elements")
public interface ElementRepository extends JpaRepository<Element, Long> {

}