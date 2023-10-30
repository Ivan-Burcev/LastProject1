
package com.javarush.quest.burcev.questControllers;




import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.*;
import org.mockito.*;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IntermediateServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher_correct_answer_riddles;

    @Mock
    private RequestDispatcher dispatcher_correct_answer_movie;

    private IntermediateServlet intermediateServlet;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        intermediateServlet = new IntermediateServlet();
    }

    @Test
    public void testDoPostGirl() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("girl");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostWater() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("water");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostIce() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("ice");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostNewspaper() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("newspaper");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostKnife() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerRiddles.jsp")).thenReturn(dispatcher_correct_answer_riddles);

        when(request.getParameter("answer")).thenReturn("knife");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_riddles).forward(request, response);
    }
    @Test
    public void testDoPostTerminator() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("terminator");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
    @Test
    public void testDoPostMenInBlack() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("men_in_black");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
    @Test
    public void testDoPostBrother() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("brother");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
    @Test
    public void testDoPostMatrix() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("matrix");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
    @Test
    public void testDoPostPulpFiction() throws Exception {
        when(request.getRequestDispatcher("WEB-INF/quest/correctAnswerMovie.jsp")).thenReturn(dispatcher_correct_answer_movie);

        when(request.getParameter("answer")).thenReturn("pulp_fiction");

        intermediateServlet.doPost(request, response);

        verify(dispatcher_correct_answer_movie).forward(request, response);
    }
}