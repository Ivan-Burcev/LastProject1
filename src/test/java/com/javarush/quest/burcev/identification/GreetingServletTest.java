package com.javarush.quest.burcev.identification;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GreetingServletTest {



    @Test
    public void testDoPost() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);


        when(request.getRequestDispatcher("index.jsp")).thenReturn(requestDispatcher);

        GreetingServlet greetingServlet = new GreetingServlet();


        greetingServlet.doPost(request, response);


        verify(requestDispatcher).forward(request, response);
    }

}