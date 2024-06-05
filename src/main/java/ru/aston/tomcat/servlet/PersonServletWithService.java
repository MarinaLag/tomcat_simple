package ru.aston.tomcat.servlet;

import ru.aston.tomcat.model.Person;
import ru.aston.tomcat.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "personServlet", value = "/person")
public class PersonServletWithService extends HttpServlet {
    private final PersonService personService = PersonService.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init PersonServletWithService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String id = request.getParameter("id");
        Person ivan = personService.getById(Integer.parseInt(id));

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + ivan.getId() + "</h1>");
        out.println("<h2>" + ivan.getEmail() + "</h2>");
        out.println("<h3>" + ivan.getFirstname() + "</h3>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy PersonServletWithService");
    }
}
