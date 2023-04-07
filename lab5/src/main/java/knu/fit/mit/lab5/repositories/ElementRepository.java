package knu.fit.mit.lab5.repositories;

import knu.fit.mit.lab5.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {

}
