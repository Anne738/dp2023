package crud;

import Elements.Element;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface Lab2CrudInterface {
    public Element readElement();
    public void updateElement(Element element);


}
