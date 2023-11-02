package com.javarush.quest.burcev.servletControllers;

import com.javarush.quest.burcev.enums.Manager;
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
        when(request.getRequestDispatcher("WEB-INF/questController/manager.jsp")).thenReturn(dispatcher_manager);
        when(request.getRequestDispatcher("WEB-INF/questController/riddles.jsp")).thenReturn(dispatcher_riddles);
        when(request.getRequestDispatcher("WEB-INF/questController/movie.jsp")).thenReturn(dispatcher_movies);
    }
    @Test
    public void testDoGet() throws ServletException, IOException {
        managerServlet.doGet(request, response);
        when(request.getAttribute("query")).thenReturn(Manager.START);
        verify(session).setAttribute("correct_answer", ManagerServlet.correct_answer);
        verify(session).setAttribute("incorrect_answer", ManagerServlet.incorrect_answer);
        verify(dispatcher_manager).forward(request, response);
    }


    @AfterEach
    void tearDown() {
    }
}