package Servlets;

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

@WebServlet("/servlet")
public class ServletOne extends HttpServlet {

    ServletConfigInterface servletConfig;
    Lab2CrudInterface lab2Crud;

    public ServletOne() {
        super();
        this.servletConfig = new ServletConfig();
        this.lab2Crud = servletConfig.getCrud();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Element> data = new ArrayList<Element>();
        data.add(lab2Crud.readElement());

        String mydata = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.print(mydata);
        out.flush();
//        PrintWriter out = response.getWriter();
//        out.println("["+lab2Crud.readElement()+"]");
//        Element entity = new Element( "assets/ja.jpeg", 178000, "JAVELIN" );
//
//        String someJson = new Gson().toJson(entity);
//
//        PrintWriter out = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        out.print("[" + someJson + "]");
//        out.flush();
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String images = request.getParameter("images");
        int price = Integer.parseInt(request.getParameter("price"));
        String name = request.getParameter("name");

        lab2Crud.updateElement(new Element(images, price, name));
    }


}