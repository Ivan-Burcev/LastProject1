package com.javarush.quest.burcev.identification;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "greetingServlet", value = "/greeting-servlet")
public class GreetingServlet extends HttpServlet {

    private static final int correct_answer = 0;
    private static final int incorrect_answer = 0;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(!request.getSession().isNew())
        {
            request.getSession().invalidate();
        }
        HttpSession session = request.getSession(true);


        session.setAttribute("correct_answer", correct_answer);
        session.setAttribute("incorrect_answer", incorrect_answer);
        session.setAttribute("number_user", 0);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/identification/greeting.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);
    }
}
