package com.javarush.quest.burcev.identification;

import com.javarush.quest.burcev.enums.Manager;
import com.javarush.quest.burcev.models.User;
import com.javarush.quest.burcev.controller.UserController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "authenticationServlet", value = "/authentication-servlet")
public class AuthenticationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/identification/authentication.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name==null||password==null||name.isEmpty()||password.isEmpty()){
            request.setAttribute("incorrect", Manager.ANSWER_IS_NULL);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/identification/authentication.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        User user = new User(0, name, password);

        if(UserController.checkUser(user)){
            HttpSession session = request.getSession();
            session.setAttribute("number_user", user.getId());
            request.setAttribute("query", Manager.START);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/questController/manager.jsp");
            requestDispatcher.forward(request, response);
        } else {

            request.setAttribute("incorrect", Manager.INCORRECT_ANSWER);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/identification/authentication.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
