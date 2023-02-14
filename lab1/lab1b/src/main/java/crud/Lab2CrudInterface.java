package crud;

import Elements.Element;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface Lab2CrudInterface {
    public Element readEntity();


    void updateEntity(Element el);

    Element Parse(HttpServletRequest request);
    int getIndexById(int id, List<Element> le);

    int getNextId(List<Element> list);
}

