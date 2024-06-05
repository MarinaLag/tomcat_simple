package ru.aston.tomcat.servlet;

import ru.aston.tomcat.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "personServletWithJsp", value = "/person/jsp")
public class PersonServletWithJsp extends HttpServlet {
    private final PersonService personService = PersonService.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String id = request.getParameter("id");

        request.setAttribute("person", personService.getById(Integer.parseInt(id)));

        request.getRequestDispatcher("/WEB-INF/jsp/person.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
