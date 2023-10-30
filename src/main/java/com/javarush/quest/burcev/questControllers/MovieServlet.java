package com.javarush.quest.burcev.questControllers;

import com.javarush.quest.burcev.enums.*;
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
        String [] movies = PreparedValues.getMovies();
        Movie [] enumMovies = PreparedValues.getMoviesEnumMovies();
        String answer = request.getParameter("answer");
        for (int i = 0; i < 4; i++) {
            if(answer.equals(movies[i])){
                request.setAttribute("title", enumMovies[i+1]);
                session.setAttribute("title",  enumMovies[i+1]);
                dispatcher_movies.forward(request, response);
                correct_answer = (int) session.getAttribute("correct_answer");
                correct_answer += 1;
                session.setAttribute("correct_answer", correct_answer);
                return;
            }
        }
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

    }
}
