package com.javarush.quest.burcev.servletControllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.javarush.quest.burcev.enums.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CorrectAnswerServletTest {
    private CorrectAnswerServlet servlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcherRiddles;

    @Mock
    private RequestDispatcher dispatcherMovie;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servlet = new CorrectAnswerServlet();
    }

    @Test
    public void testDoPost_WithCorrectMovieAnswer() throws ServletException, IOException, ServletException, IOException {
        Movie[] moviesEnum = PreparedValues.getMoviesEnumMovies();
        Riddles[] riddlesEnum = PreparedValues.getRiddlesEnum();
        String[] movies = PreparedValues.getMovies();
        String[] riddles = PreparedValues.getRiddles();

        when(request.getParameter("answer")).thenReturn(movies[0]);
        when(request.getRequestDispatcher("views/questController/correctAnswerMovie.jsp")).thenReturn(dispatcherMovie);

        servlet.doPost(request, response);

        verify(request).setAttribute("query", moviesEnum[0]);
        verify(dispatcherMovie).forward(request, response);
        verify(dispatcherRiddles, never()).forward(request, response);
    }
    @Test
    public void testDoPost_WithCorrectRiddleAnswer() throws ServletException, IOException {
        Movie[] moviesEnum = PreparedValues.getMoviesEnumMovies();
        Riddles[] riddlesEnum = PreparedValues.getRiddlesEnum();
        String[] movies = PreparedValues.getMovies();
        String[] riddles = PreparedValues.getRiddles();

        when(request.getParameter("answer")).thenReturn(riddles[0]);
        when(request.getRequestDispatcher("views/questController/correctAnswerRiddles.jsp")).thenReturn(dispatcherRiddles);

        servlet.doPost(request, response);

        verify(request).setAttribute("query", riddlesEnum[0]);
        verify(dispatcherRiddles).forward(request, response);
        verify(dispatcherMovie, never()).forward(request, response);
    }

    @Test
    public void testDoPost_WithIncorrectAnswer() throws ServletException, IOException {
        Movie[] moviesEnum = PreparedValues.getMoviesEnumMovies();
        Riddles[] riddlesEnum = PreparedValues.getRiddlesEnum();
        String[] movies = PreparedValues.getMovies();
        String[] riddles = PreparedValues.getRiddles();

        when(request.getParameter("answer")).thenReturn("incorrect answer");

        servlet.doPost(request, response);

        verify(request, never()).setAttribute(anyString(), any());
        verify(dispatcherMovie, never()).forward(request, response);
        verify(dispatcherRiddles, never()).forward(request, response);
    }

}