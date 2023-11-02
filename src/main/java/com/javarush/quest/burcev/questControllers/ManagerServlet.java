package com.javarush.quest.burcev.questControllers;

import com.javarush.quest.burcev.enums.Manager;
import com.javarush.quest.burcev.enums.Movie;
import com.javarush.quest.burcev.enums.Riddles;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "managerServlet", value = "/manager-servlet")
public class ManagerServlet extends HttpServlet {
    public static RequestDispatcher dispatcher_riddles;
    public static RequestDispatcher dispatcher_movies;
    public static RequestDispatcher dispatcher_manager;
    public static final int correct_answer = 0;
    public static final int incorrect_answer = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        session.setAttribute("correct_answer", correct_answer);
        session.setAttribute("incorrect_answer", incorrect_answer);

        dispatcher_manager = request.getRequestDispatcher("views/questController/manager.jsp");
        request.setAttribute("query", Manager.START );
        dispatcher_manager.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatcher_riddles = request.getRequestDispatcher("views/questController/riddles.jsp");
        dispatcher_movies = request.getRequestDispatcher("views/questController/movie.jsp");
        dispatcher_manager = request.getRequestDispatcher("views/questController/manager.jsp");
        HttpSession session = request.getSession();
        int incorrect_answer;
        List<Movie> movies;
        {
            movies = new ArrayList<>();
            movies.add(Movie.FIRST_MOVIE);
            movies.add(Movie.SECOND_MOVIE);
            movies.add(Movie.THIRD_MOVIE);
            movies.add(Movie.FOURTH_MOVIE);
            movies.add(Movie.FIFTH_MOVIE);
        }
        String answer = request.getParameter("answer");
        switch(answer) {
            case "riddle":
                request.setAttribute("title", Riddles.FIRST_RIDDLE);
                session.setAttribute("title", Riddles.FIRST_RIDDLE);
                dispatcher_riddles.forward(request, response);
                break;
            case "movie":
                request.setAttribute("title", Movie.FIRST_MOVIE);
                session.setAttribute("title", Movie.FIRST_MOVIE);
                dispatcher_movies.forward(request, response);
                break;
            case "incorrect":
                request.setAttribute("query", Manager.INCORRECT_ANSWER);
                dispatcher_manager.forward(request,response);
                break;
            case "back":
                request.setAttribute("title", session.getAttribute("title"));
                incorrect_answer = (int) session.getAttribute("incorrect_answer");
                incorrect_answer += 1;
                session.setAttribute("incorrect_answer", incorrect_answer);
                if(movies.contains(session.getAttribute("title"))){
                    dispatcher_movies.forward(request,response);
                } else {
                    dispatcher_riddles.forward(request,response);
                }
                break;

        }
    }
}
