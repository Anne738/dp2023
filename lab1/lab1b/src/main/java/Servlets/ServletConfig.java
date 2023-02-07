package Servlets;

import crud.FileCrud;
import crud.Lab2CrudInterface;

public class ServletConfig implements ServletConfigInterface {

    public ServletConfig(){
        this.l2ci = new FileCrud();
    }
    public void setL2ci(Lab2CrudInterface l2ci) {
        this.l2ci = l2ci;
    }

    Lab2CrudInterface l2ci;
    @Override
    public Lab2CrudInterface getCrud(){
        return l2ci;
    }
}