package com.javarush.quest.burcev.servletControllers;

import com.javarush.quest.burcev.enums.Manager;
import com.javarush.quest.burcev.enums.Movie;
import com.javarush.quest.burcev.enums.Riddles;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import org.junit.jupiter.api.*;

import org.mockito.*;

import java.io.IOException;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ManagerServletTest {
    private ManagerServlet managerServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher dispatcher_manager;
    @Mock
    private RequestDispatcher dispatcher_movies;
    @Mock
    private RequestDispatcher dispatcher_riddles;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        managerServlet = new ManagerServlet();
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("views/questController/manager.jsp")).thenReturn(dispatcher_manager);
        when(request.getRequestDispatcher("views/questController/riddles.jsp")).thenReturn(dispatcher_riddles);
        when(request.getRequestDispatcher("views/questController/movie.jsp")).thenReturn(dispatcher_movies);
    }
    @Test
    public void testDoGet() throws ServletException, IOException {
        managerServlet.doGet(request, response);
        when(request.getAttribute("query")).thenReturn(Manager.START);
        verify(session).setAttribute("correct_answer", ManagerServlet.correct_answer);
        verify(session).setAttribute("incorrect_answer", ManagerServlet.incorrect_answer);

        verify(dispatcher_manager).forward(request, response);
    }
    @Test
    public void testDoPostRiddle() throws ServletException, IOException {
        when(request.getParameter("answer")).thenReturn("riddle");
        managerServlet.doPost(request, response);
        when(request.getAttribute("title")).thenReturn(Riddles.FIRST_RIDDLE);
        when(session.getAttribute("title")).thenReturn(Riddles.FIRST_RIDDLE);
        verify(dispatcher_riddles).forward(request, response);
    }
    @Test
    public void testDoPostMovie() throws ServletException, IOException {
        when(request.getParameter("answer")).thenReturn("movie");
        managerServlet.doPost(request, response);
        when(request.getAttribute("title")).thenReturn(Movie.FIRST_MOVIE);
        when(session.getAttribute("title")).thenReturn(Movie.FIRST_MOVIE);
        verify(dispatcher_movies).forward(request, response);
    }
    @Test
    public void testDoPostIncorrect() throws ServletException, IOException {
        when(request.getParameter("answer")).thenReturn("incorrect");
        managerServlet.doPost(request, response);
        when(request.getAttribute("query")).thenReturn(Manager.INCORRECT_ANSWER);
        verify(dispatcher_manager).forward(request, response);
    }
    @Test
    public void testDoPostBack() throws ServletException, IOException {
        when(request.getParameter("answer")).thenReturn("back");
        when(session.getAttribute("title")).thenReturn(Movie.FIRST_MOVIE);
        when(session.getAttribute("incorrect_answer")).thenReturn(0);
        managerServlet.doPost(request, response);
        when(request.getAttribute("title")).thenReturn(Movie.FIRST_MOVIE);
        verify(dispatcher_movies).forward(request,response);



    }



    @AfterEach
    void tearDown() {
    }
}