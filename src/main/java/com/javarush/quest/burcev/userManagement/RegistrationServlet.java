package com.javarush.quest.burcev.userManagement;

import com.javarush.quest.burcev.enums.Manager;
import com.javarush.quest.burcev.models.User;
import com.javarush.quest.burcev.models.UserController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "registrationServlet", value = "/registration-servlet")
public class RegistrationServlet extends HttpServlet {
    private static int number = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/userControllers/registration.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User(number, name, password);
        number++;
        if(UserController.addUser(user)){

            HttpSession session = request.getSession();
            session.setAttribute("number_user", user.getId());
            request.setAttribute("query", Manager.START);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/questController/manager.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("incorrect", Manager.INCORRECT_ANSWER);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/userControllers/registration.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
