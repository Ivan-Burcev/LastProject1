package com.javarush.quest.burcev.servletControllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.javarush.quest.burcev.controller.UserController;
import com.javarush.quest.burcev.enums.Manager;
import com.javarush.quest.burcev.enums.Movie;
import com.javarush.quest.burcev.enums.PreparedValues;
import com.javarush.quest.burcev.enums.Riddles;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import org.junit.jupiter.api.*;

import org.mockito.*;

import java.io.IOException;

class MovieServletTest {
    private MovieServlet movieServlet;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher dispatcherMovies;
    @Mock
    private RequestDispatcher dispatcherManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        movieServlet = new MovieServlet();


        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("views/questController/movie.jsp")).thenReturn(dispatcherMovies);
        when(request.getRequestDispatcher("views/questController/manager.jsp")).thenReturn(dispatcherManager);
    }

    @Test
    public void testDoPostWithCorrectAnswer() throws Exception {
        String[] movies = {"movie1", "movie2", "movie3", "movie4", "movie5"};
        Movie[] enumMovies = new Movie[5];
        MockedStatic <PreparedValues> preparedValuesMockedStatic = Mockito.mockStatic(PreparedValues.class);
        preparedValuesMockedStatic.when(PreparedValues::getMovies).thenReturn(movies);
        when(PreparedValues.getMoviesEnumMovies()).thenReturn(enumMovies);
        when(request.getParameter("answer")).thenReturn("movie2");
        when(session.getAttribute("correct_answer")).thenReturn(0);
        when(session.getAttribute("incorrect_answer")).thenReturn(0);

        movieServlet.doPost(request, response);

        verify(request).setAttribute("title", enumMovies[2]);
        verify(session).setAttribute("title", enumMovies[2]);
        verify(session).setAttribute("correct_answer", 1);
        verify(dispatcherMovies).forward(request, response);
        preparedValuesMockedStatic.close();
    }

}