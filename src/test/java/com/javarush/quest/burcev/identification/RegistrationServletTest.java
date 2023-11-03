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
class RegistrationServletTest {
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private HttpSession session;

    private RegistrationServlet registrationServlet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        registrationServlet = new RegistrationServlet();
    }

    @Test
    public void testDoPostWithValidData() throws Exception {
        when(request.getParameter("name")).thenReturn("John");
        when(request.getParameter("password")).thenReturn("password");
        when(request.getRequestDispatcher("views/questController/manager.jsp")).thenReturn(requestDispatcher);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("number_user")).thenReturn(0);

        registrationServlet.doPost(request, response);

        verify(session).setAttribute("number_user", 0);
        verify(request).setAttribute("query", Manager.START);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPostWithInvalidData() throws Exception {
        when(request.getParameter("name")).thenReturn("");
        when(request.getParameter("password")).thenReturn("");
        when(request.getRequestDispatcher("views/identification/registration.jsp")).thenReturn(requestDispatcher);

        registrationServlet.doPost(request, response);

        verify(request).setAttribute("incorrect", Manager.ANSWER_IS_NULL);
        verify(requestDispatcher).forward(request, response);
    }

}