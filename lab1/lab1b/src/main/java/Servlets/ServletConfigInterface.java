package Servlets;

import Elements.Element;
import crud.Lab2CrudInterface;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface ServletConfigInterface {
    public Lab2CrudInterface getCrud();

}
