package Servlets;

import Elements.ElemList;
import Elements.Element;
import com.google.gson.Gson;
import crud.Lab2CrudInterface;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet/*")
public class ServletOne extends HttpServlet {

    ServletConfigInterface servletConfig;
    Lab2CrudInterface lab2Crud;

    FjsonInterface fjs;

    public ServletOne() {
        super();
        this.servletConfig = new ServletConfig();
        this.lab2Crud = servletConfig.getCrud();
    }

    private List<Element> data = new ElemList().getElemlist();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String mydata = new Gson().toJson(data);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(mydata);
        out.flush();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Element el = fjs.Parse(request);
        el.setId(fjs.getNextId(data));
        data.add(el);
        doGet(request, response);

    }
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Element el = fjs.Parse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = fjs.getIndexById(id, data);
        data.set(index,el);
        doGet(request, response);
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = fjs.getIndexById(id, data);
        data.remove(index);
        doGet(request, response);
    }


}