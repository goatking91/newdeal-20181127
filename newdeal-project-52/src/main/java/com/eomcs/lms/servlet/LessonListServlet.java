package com.eomcs.lms.servlet;


import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@WebServlet("/lesson/list")
public class LessonListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  LessonDao lessonDao;

  @Override
  public void init() throws ServletException {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.lessonDao = iocContainer.getBean(LessonDao.class);
  }
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      
      List<Lesson> list = lessonDao.findAll();
      request.setAttribute("list", list);
      
      
      RequestDispatcher rd = this.getServletContext()
          .getRequestDispatcher("/lesson/list.jsp");
      
      response.setContentType("text/html;charset=UTF-8");
      
      rd.include(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }

}