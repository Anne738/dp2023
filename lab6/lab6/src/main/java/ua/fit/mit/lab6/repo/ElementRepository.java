package ua.fit.mit.lab6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.fit.mit.lab6.entity.Element;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {

}