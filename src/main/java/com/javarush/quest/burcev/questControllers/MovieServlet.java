package com.javarush.quest.burcev.questControllers;

import com.javarush.quest.burcev.enums.Manager;
import com.javarush.quest.burcev.enums.Movie;
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

@WebServlet(name = "movieServlet", value = "/movie-servlet")
public class MovieServlet extends HttpServlet {
    public static RequestDispatcher dispatcher_movies;
    public static RequestDispatcher dispatcher_manager;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatcher_manager = request.getRequestDispatcher("WEB-INF/questController/manager.jsp");
        dispatcher_movies = request.getRequestDispatcher("WEB-INF/questController/movie.jsp");
        HttpSession session = request.getSession();
        int correct_answer;
        int incorrect_answer;
        String answer = request.getParameter("answer");
        switch (answer) {
            case "terminator":
                request.setAttribute("title", Movie.SECOND_MOVIE);
                session.setAttribute("title", Movie.SECOND_MOVIE);
                dispatcher_movies.forward(request, response);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                break;
            case "men_in_black":
                request.setAttribute("title", Movie.THIRD_MOVIE);
                session.setAttribute("title", Movie.THIRD_MOVIE);
                dispatcher_movies.forward(request, response);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                break;
            case "brother":
                request.setAttribute("title", Movie.FOURTH_MOVIE);
                session.setAttribute("title", Movie.FOURTH_MOVIE);
                dispatcher_movies.forward(request, response);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                break;
            case "matrix":
                request.setAttribute("title", Movie.FIFTH_MOVIE);
                session.setAttribute("title", Movie.FIFTH_MOVIE);
                dispatcher_movies.forward(request, response);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                break;
            case "pulp_fiction":
                request.setAttribute("query", Manager.FINAL);
                correct_answer = (int) session.getAttribute("correct_answer");
                incorrect_answer = (int)session.getAttribute("incorrect_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                int id =(int)session.getAttribute("number_user");
                User user = new UserController().getUsers().get(id);
                UserController.addQuest(user.getId(), new Quest("Movie", correct_answer, incorrect_answer));
                session.setAttribute("name_of_user", user.getName());
                dispatcher_manager.forward(request, response);
                break;
        }
    }
}
