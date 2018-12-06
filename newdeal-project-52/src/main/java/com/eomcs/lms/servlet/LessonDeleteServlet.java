package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.LessonDao;

@WebServlet("/lesson/delete")
public class LessonDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  LessonDao lessonDao;

  @Override
  public void init() {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.lessonDao = iocContainer.getBean(LessonDao.class);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int no = Integer.parseInt(request.getParameter("no"));

      request.setAttribute("count", lessonDao.delete(no));
      RequestDispatcher rd =  request.getRequestDispatcher(
          "/lesson/delete.jsp");

      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
