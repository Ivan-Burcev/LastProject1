package com.javarush.quest.burcev.servletControllers;

import com.javarush.quest.burcev.enums.Movie;
import com.javarush.quest.burcev.enums.PreparedValues;
import com.javarush.quest.burcev.enums.Riddles;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RiddleServletTest {
    private RiddleServlet riddleServlet ;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher dispatcherRiddles;
    @Mock
    private RequestDispatcher dispatcherManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        riddleServlet = new RiddleServlet();


        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("views/questController/riddles.jsp")).thenReturn(dispatcherRiddles);
        when(request.getRequestDispatcher("views/questController/manager.jsp")).thenReturn(dispatcherManager);
    }

    @Test
    public void testDoPostWithCorrectAnswer() throws Exception {
        String[] riddles = {"Riddle1", "Riddle2", "Riddle3", "Riddle4", "Riddle5"};
        Riddles[] enumRiddles = new Riddles[5];
        MockedStatic<PreparedValues> preparedValuesMockedStatic = Mockito.mockStatic(PreparedValues.class);
        preparedValuesMockedStatic.when(PreparedValues::getRiddles).thenReturn(riddles);
        when(PreparedValues.getRiddlesEnum()).thenReturn(enumRiddles);
        when(request.getParameter("answer")).thenReturn("Riddle2");
        when(session.getAttribute("correct_answer")).thenReturn(0);

        riddleServlet.doPost(request, response);

        verify(request).setAttribute("title", enumRiddles[2]);
        verify(session).setAttribute("title", enumRiddles[2]);
        verify(session).setAttribute("correct_answer", 1);
        verify(dispatcherRiddles).forward(request, response);
        preparedValuesMockedStatic.close();
    }

}