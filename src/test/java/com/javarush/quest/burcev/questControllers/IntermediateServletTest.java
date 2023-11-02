
package com.javarush.quest.burcev.questControllers;




import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.*;
import org.mockito.*;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CorrectAnswerServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher_correct_answer_riddles;

    @Mock
    private RequestDispatcher dispatcher_correct_answer_movie;

    private CorrectAnswerServlet correctAnswerServletTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        correctAnswerServletTest = new CorrectAnswerServlet();
    }

    @Test
    public void testDoPostGirl() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("girl");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostWater() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("water");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostIce() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("ice");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostNewspaper() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("newspaper");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostKnife() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("knife");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostTerminator() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("terminator");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
    @Test
    public void testDoPostMenInBlack() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("men_in_black");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
    @Test
    public void testDoPostBrother() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("brother");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
    @Test
    public void testDoPostMatrix() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("matrix");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
    @Test
    public void testDoPostPulpFiction() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("pulp_fiction");

        correctAnswerServletTest.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
}