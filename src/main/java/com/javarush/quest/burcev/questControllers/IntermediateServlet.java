
package com.javarush.quest.burcev.questControllers;

import com.javarush.quest.burcev.enums.*;
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

        Movie[] moviesEnum = PreparedValues.getMoviesEnumMovies();
        Riddles[] riddlesEnum = PreparedValues.getRiddlesEnum();
        String[] movies = PreparedValues.getMovies();
        String[] riddles  = PreparedValues.getRiddles();
        String answer = request.getParameter("answer");
        for (int i = 0; i <5 ; i++) {
            if(movies[i].equals(answer)){
                request.setAttribute("query", moviesEnum[i]);
                dispatcher_correct_answer_movie.forward(request, response);
                return;
            } else if (riddles[i].equals(answer)){
                request.setAttribute("query", riddlesEnum[i]);
                dispatcher_correct_answer_riddles.forward(request, response);
                return;
            }
        }
    }
    }

