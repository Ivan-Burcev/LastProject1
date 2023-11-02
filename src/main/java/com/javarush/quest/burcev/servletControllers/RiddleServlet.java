package com.javarush.quest.burcev.servletControllers;

import com.javarush.quest.burcev.enums.*;
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

@WebServlet(name = "riddleServlet", value = "/riddle-servlet")
public class RiddleServlet extends HttpServlet {
    public static RequestDispatcher dispatcher_riddles;
    public static RequestDispatcher dispatcher_manager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatcher_riddles = request.getRequestDispatcher("views/questController/riddles.jsp");
        dispatcher_manager = request.getRequestDispatcher("views/questController/manager.jsp");
        HttpSession session = request.getSession();
        int correct_answer;
        int incorrect_answer;

        String answer = request.getParameter("answer");
        String [] riddles = PreparedValues.getRiddles();
        Riddles [] enumRiddles = PreparedValues.getRiddlesEnum();

        for (int i = 0; i <4 ; i++) {
            if(answer.equals(riddles[i])){
                request.setAttribute("title", enumRiddles[i+1]);
                session.setAttribute("title", enumRiddles[i+1]);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                dispatcher_riddles.forward(request, response);
                return;
            }
        }

                request.setAttribute("query", Manager.FINAL);
                correct_answer = (int) session.getAttribute("correct_answer");
                incorrect_answer = (int) session.getAttribute("incorrect_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                int id =(int)session.getAttribute("number_user");
                User user = UserController.getUser(id);
                session.setAttribute("name_of_user", user.getName());
                dispatcher_manager.forward(request, response);

    }
}
