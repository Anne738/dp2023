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
import java.util.List;

@WebServlet("/servlet/*")
public class ServletOne extends HttpServlet {
    private List<Element> data = new ElemList().getElemlist();
    ServletConfigInterface servletConfig;
    Lab2CrudInterface crud;

    public ServletOne() {
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getCrud();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String mydata = new Gson().toJson(data);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");

        out.print(mydata);
        out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        String images = request.getParameter("images");
//        int price = Integer.parseInt(request.getParameter("price"));
//        String name = request.getParameter("name");
//        System.out.println(price);

        Element el = crud.Parse(request);
        el.setId(crud.getNextId(data));
        data.add(el);
        doGet(request, response);


    }
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Element el = crud.Parse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = crud.getIndexById(id, data);
        data.set(index,el);
        doGet(request, response);
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = crud.getIndexById(id, data);
        data.remove(index);
        doGet(request, response);
    }


}