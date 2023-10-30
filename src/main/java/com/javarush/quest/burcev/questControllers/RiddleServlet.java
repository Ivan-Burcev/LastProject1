package com.javarush.quest.burcev.questControllers;

import com.javarush.quest.burcev.enums.Manager;
import com.javarush.quest.burcev.enums.Riddles;
import com.javarush.quest.burcev.models.Quest;
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

@WebServlet(name = "riddleServlet", value = "/riddle-servlet")
public class RiddleServlet extends HttpServlet {
    public static RequestDispatcher dispatcher_riddles;
    public static RequestDispatcher dispatcher_manager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatcher_riddles = request.getRequestDispatcher("WEB-INF/questController/riddles.jsp");
        dispatcher_manager = request.getRequestDispatcher("WEB-INF/questController/manager.jsp");
        HttpSession session = request.getSession();
        int correct_answer;
        int incorrect_answer;

        String answer = request.getParameter("answer");

        switch (answer) {

            case "girl":
                request.setAttribute("title", Riddles.SECOND_RIDDLE);
                session.setAttribute("title", Riddles.SECOND_RIDDLE);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                dispatcher_riddles.forward(request, response);
                break;
            case "water":
                request.setAttribute("title", Riddles.THIRD_RIDDLE);
                session.setAttribute("title", Riddles.THIRD_RIDDLE);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                dispatcher_riddles.forward(request, response);
                break;
            case "ice":
                request.setAttribute("title", Riddles.FOURTH_RIDDLE);
                session.setAttribute("title", Riddles.FOURTH_RIDDLE);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                dispatcher_riddles.forward(request, response);
                break;
            case "newspaper":
                request.setAttribute("title", Riddles.FIFTH_RIDDLE);
                session.setAttribute("title", Riddles.FIFTH_RIDDLE);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                dispatcher_riddles.forward(request, response);
                break;
            case "knife":
                request.setAttribute("query", Manager.FINAL);
                correct_answer = (int) session.getAttribute("correct_answer");
                incorrect_answer = (int) session.getAttribute("incorrect_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                int id =(int)session.getAttribute("number_user");
                User user = new UserController().getUsers().get(id);
                UserController.addQuest(user.getId(), new Quest("Riddle", correct_answer, incorrect_answer));
                session.setAttribute("name_of_user", user.getName());
                dispatcher_manager.forward(request, response);
                break;
        }
    }
}
