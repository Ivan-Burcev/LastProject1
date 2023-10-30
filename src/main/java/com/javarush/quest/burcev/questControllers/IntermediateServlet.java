
package com.javarush.quest.burcev.questControllers;

import com.javarush.quest.burcev.enums.Movie;
import com.javarush.quest.burcev.enums.Riddles;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "intermediateServlet", value = "/intermediate-servlet")
public class IntermediateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher_correct_answer_riddles = request.getRequestDispatcher("WEB-INF/questController/correctAnswerRiddles.jsp");
        RequestDispatcher dispatcher_correct_answer_movie = request.getRequestDispatcher("WEB-INF/questController/correctAnswerMovie.jsp");


        String answer = request.getParameter("answer");
        switch(answer) {
            case "girl":
                request.setAttribute("query", Riddles.FIRST_RIDDLE);
                dispatcher_correct_answer_riddles.forward(request, response);
                break;
            case "water":
                request.setAttribute("query", Riddles.SECOND_RIDDLE);
                dispatcher_correct_answer_riddles.forward(request, response);
                break;
            case "ice":
                request.setAttribute("query", Riddles.THIRD_RIDDLE);
                dispatcher_correct_answer_riddles.forward(request, response);
                break;
            case "newspaper":
                request.setAttribute("query", Riddles.FOURTH_RIDDLE);
                dispatcher_correct_answer_riddles.forward(request, response);
                break;
            case "knife":
                request.setAttribute("query", Riddles.FIFTH_RIDDLE);
                dispatcher_correct_answer_riddles.forward(request, response);
                break;
            case "terminator":
                request.setAttribute("query", Movie.FIRST_MOVIE);
                dispatcher_correct_answer_movie.forward(request, response);
                break;
            case "men_in_black":
                request.setAttribute("query", Movie.SECOND_MOVIE);
                dispatcher_correct_answer_movie.forward(request, response);
                break;
            case "brother":
                request.setAttribute("query", Movie.THIRD_MOVIE);
                dispatcher_correct_answer_movie.forward(request, response);
                break;
            case "matrix":
                request.setAttribute("query", Movie.FOURTH_MOVIE);
                dispatcher_correct_answer_movie.forward(request, response);
                break;
            case "pulp_fiction":
                request.setAttribute("query", Movie.FIFTH_MOVIE);
                dispatcher_correct_answer_movie.forward(request, response);
                break;

        }

    }
}
