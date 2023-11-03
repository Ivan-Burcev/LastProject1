package com.javarush.quest.burcev.identification;

import static org.junit.jupiter.api.Assertions.*;

import com.javarush.quest.burcev.enums.Manager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticationServletTest {
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private HttpSession session;

    private AuthenticationServlet authenticationServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        authenticationServlet = new AuthenticationServlet();
    }

    @Test
    public void testDoGet() throws Exception {
        when(request.getRequestDispatcher("views/identification/authentication.jsp")).thenReturn(requestDispatcher);

        authenticationServlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPostWithValidData() throws Exception {
        when(request.getParameter("name")).thenReturn("John");
        when(request.getParameter("password")).thenReturn("password");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("views/questController/manager.jsp")).thenReturn(requestDispatcher);

        authenticationServlet.doPost(request, response);

        verify(session).setAttribute("number_user", anyInt());
        verify(request).setAttribute("query", Manager.START);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPostWithInvalidData() throws Exception {
        when(request.getParameter("name")).thenReturn("");
        when(request.getParameter("password")).thenReturn("");
        when(request.getRequestDispatcher("views/identification/authentication.jsp")).thenReturn(requestDispatcher);

        authenticationServlet.doPost(request, response);

        verify(request).setAttribute("incorrect", Manager.ANSWER_IS_NULL);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPostWithIncorrectAnswer() throws Exception {
        when(request.getParameter("name")).thenReturn("John");
        when(request.getParameter("password")).thenReturn("wrongpassword");
        when(request.getRequestDispatcher("views/identification/authentication.jsp")).thenReturn(requestDispatcher);

        authenticationServlet.doPost(request, response);

        verify(request).setAttribute("incorrect", Manager.INCORRECT_ANSWER);
        verify(requestDispatcher).forward(request, response);
    }
}