package Servlets;

import Elements.Element;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface FjsonInterface {
    Element Parse(HttpServletRequest request);
    int getIndexById(int id, List<Element> le);
    int getNextId(List<Element> le);
}
